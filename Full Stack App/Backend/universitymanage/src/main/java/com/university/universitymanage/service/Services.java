package com.university.universitymanage.service;


import java.util.List;

import com.university.universitymanage.model.University;

public interface Services {
public List<University> getAll();
public String saveInfo(University university);
public void deleteByID(int id);
public University updateByID(int Id,University updatedUniversity);
}
