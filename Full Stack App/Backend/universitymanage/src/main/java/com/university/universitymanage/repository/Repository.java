package com.university.universitymanage.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.university.universitymanage.model.University;
public interface Repository extends JpaRepository<University,Integer>{

}
