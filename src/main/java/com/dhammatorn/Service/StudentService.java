/*
LAB BOOKING AND ATTENDANCE - SPE 2018/19
This file is the service file for the student and their actions.
This file is where the logic for the functions happens. It makes use of the
student repository and entity.
*/

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
public class StudentService {

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


    /*
    Saves a student
    */
    public void addStudent(Student student){
       studentRepository.save(student);
    }

    /*
    Returns a list of all students.
    */
    public List<Student> getAllStudent(){
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    /*
    Returns student by searching via ID
    */
    public Optional<Student> getStudentById(int id){
        return studentRepository.findById(id);
    }

    /*
    Getds a student by their username, will return first item in list. This
    function is often used with the one directly below.
    */
    public Student getStudentByUsername(String username){
        List<Student> students = studentRepository.findByUsername(username);
        return students.get(0);
    }

    /*
    Gets a student by their username. Returns number of these students.
    */
    public int getMaybeStudentByUsername(String username){
        List<Student> students = studentRepository.findByUsername(username);
        return students.size();
    }

    /*
    This function returns a student by finding them with their ucard.
    It makes use of a list of students and if this list is empty, it returns
    a temporary user object to indicate there is not a student with such a
    UCARD number.
    */
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

    /*
    This function saves a student.
    */
    public void updateStudent(Student student){
        studentRepository.save(student);
    }

    /*
    This functoin saves the student from the registration page.
    It also associates this with a role, where "USER" is this can be changed
    to "ADMIN" to make the default user have the ADMIN role. This is useful
    for testing perposes, since ADMIN has all the access.
    Via the file data.sql, it updates the first account with the ADMIN role, so
    there will be at least one admin.
    */
    public void saveStudent(Student student) {
        student.setPassword(bCryptPasswordEncoder.encode(student.getPassword()));
        student.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        student.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        studentRepository.save(student);
    }

    /*
    This function deletes the student by their ID
    */
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    /*
    This function updates the students strikes by using their ID.
    It overwrites the given student which has the strikes updated.
    */
    public void updateStudentStrikesByID(Student student){
        studentRepository.save(student);
    }

}
