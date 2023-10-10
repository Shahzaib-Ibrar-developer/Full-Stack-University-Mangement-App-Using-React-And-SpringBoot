package com.university.universitymanage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.university.universitymanage.model.University;
import com.university.universitymanage.service.Services;


@RestController
@RequestMapping("/university")
@CrossOrigin
public class UniversityController {
@Autowired
private Services universityServices;



@PostMapping("/add")
public String add(@RequestBody University university) {
	universityServices.saveInfo(university);
	return "new student is added";
}



@GetMapping("/getAll")
public List<University> getAll(){
	return universityServices.getAll();
}



@DeleteMapping("/delete/{id}")
public ResponseEntity<String> deleteById(@PathVariable int id) {
    try {
        universityServices.deleteByID(id);
        return ResponseEntity.ok(id + " is Deleted");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user");
    }
}

@PutMapping("/update/{id}")
public ResponseEntity<University> updateUniversityById(@PathVariable int id, @RequestBody University updatedUniversity) {
    University updated = universityServices.updateByID(id, updatedUniversity);

    if (updated != null) {
        return new ResponseEntity<>(updated, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}



}
