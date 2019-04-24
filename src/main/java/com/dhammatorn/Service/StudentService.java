package com.dhammatorn.Service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.dhammatorn.Entity.Student;
import com.dhammatorn.Entity.Role;
import com.dhammatorn.Dao.StudentRepository;
import com.dhammatorn.Dao.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import com.dhammatorn.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
//this is where Buisness logic happens (where database meets web) -- middle ground/layer
public class StudentService {


    //we need a way to access the Dao
    //create an instance of the Dao
    @Autowired
    public StudentRepository studentRepository;
    public RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public StudentService(StudentRepository studentRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    public void addStudent(Student student){
       studentRepository.save(student);
    }

    //function to return all students
    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    //function to get Student by ID
    //copy this to service to connect them
    public Optional<Student> getStudentById(int id){
        return studentRepository.findById(id);
    }

    public Student getStudentByUsername(String username){
        List<Student> students = studentRepository.findByUsername(username);
        return students.get(0);
    }

    public int getMaybeStudentByUsername(String username){
        List<Student> students = studentRepository.findByUsername(username);
        return students.size();
    }

    public Student getStudentByUcard(String ucard){
        List<Student> students = studentRepository.findByUcard(ucard);
        if (students.isEmpty()){
            Student temp = new Student();
            temp.setUsername("-1");
            System.out.println(temp.getUsername());
            return (temp);
        } else {
            System.out.println(students.get(0).getUsername());
            return students.get(0);
        }

    }

    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    public void saveStudent(Student student) {
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        student.setActive(1);
        Role userRole = roleRepository.findByRole("ADMIN");
        student.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        studentRepository.save(student);
    }

    // Delete a student by using a given ID
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    //Update student strikes by giving an id
    public void updateStudentStrikesByID(Student student){
        studentRepository.save(student);
    }

}
