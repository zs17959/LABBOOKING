package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Booking;
import com.dhammatorn.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BookingRepository extends CrudRepository<Booking,Integer>{
//    @Query("SELECT u FROM Student u WHERE u.id = :id")
//    public Student getStudentById(@Param("id") int id);

    @Query(value = "SELECT u FROM Booking u WHERE u.student = :student")
    public List<Booking> findByStudent(@Param("student") int student);

}
