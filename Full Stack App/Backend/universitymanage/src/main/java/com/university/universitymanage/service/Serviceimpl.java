package com.university.universitymanage.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.university.universitymanage.model.University;
import com.university.universitymanage.repository.Repository;


@Service
public class Serviceimpl implements Services {

	@Autowired
	private Repository universityRepository;

	@Override
	public String saveInfo(University university) {
		University savedUniversity = universityRepository.save(university);
		return "University saved with ID: " + savedUniversity.getId();
	}

	@Override
	public List<University> getAll() {
		return universityRepository.findAll();
	}

	@Override
	public void deleteByID(int id) {
		universityRepository.deleteById(id);
	}
	
	@Override
    public University updateByID(int id, University updatedUniversity) {
        // Find the existing university by its ID
        University existingUniversity = universityRepository.findById(id).orElse(null);

        if (existingUniversity != null) {
            existingUniversity.setName(updatedUniversity.getName());
            existingUniversity.setFatherName(updatedUniversity.getFatherName());
            existingUniversity.setCnic(updatedUniversity.getCnic());
            existingUniversity.setMatricMarks(updatedUniversity.getMatricMarks());
            existingUniversity.setInterMarks(updatedUniversity.getInterMarks());
            existingUniversity.setFatherCNIC(updatedUniversity.getFatherCNIC());
            existingUniversity.setDepartment(updatedUniversity.getDepartment());
            existingUniversity.setSection(updatedUniversity.getSection());
            existingUniversity.setAdmissionDate(updatedUniversity.getAdmissionDate());
            existingUniversity.setFeeStatus(updatedUniversity.getFeeStatus());

            return universityRepository.save(existingUniversity);
        } else {
           
            return null; 
        }
      
    }
	
	
}