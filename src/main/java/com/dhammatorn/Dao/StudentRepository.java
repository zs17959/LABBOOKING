package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;


public interface StudentRepository extends CrudRepository<Student,Integer>{

    //@Query("SELECT u FROM Student u WHERE u.id = :id")
    //public Student getStudentById(@Param("id") int id);

    //@Modifying(clearAutomatically = true, flushAutomatically = true)
    //@Query("UPDATE Student SET name = :name WHERE id = :id")
    //public Student updateStudentById(@Param("id") int id, @Param("name") String name);

    //@Query("DELETE Student u WHERE u.id = :id")
    //public Student deleteStudentById(@Param("id") int id);

    @Query(value = "SELECT u FROM Student u WHERE u.username = :username")
    public List<Student> findByUsername(@Param("username") String username);

    @Query(value = "SELECT u FROM Student u WHERE u.ucard = :ucard")
    public List<Student> findByUcard(@Param("ucard") String ucard);

}
