package com.university.universitymanage.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "university_db")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String fatherName;
    private String cnic; // Corrected field name
    private double matricMarks;
    private double interMarks;
    private String fatherCNIC;
    private String department; // Corrected field name
    private String section; // Corrected field name
    private String admissionDate; // Corrected field name
    private String feeStatus;

    public University() {
        super();
        // TODO Auto-generated constructor stub
    }

    public University(String name, String fatherName, String cnic, double matricMarks, double interMarks,
            String fatherCNIC, String department, String section, String admissionDate, String feeStatus) {

        super();
        this.name = name;
        this.fatherName = fatherName;
        this.cnic = cnic;
        this.matricMarks = matricMarks;
        this.interMarks = interMarks;
        this.fatherCNIC = fatherCNIC;
        this.department = department;
        this.section = section;
        this.admissionDate = admissionDate;
        this.feeStatus = feeStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public double getMatricMarks() {
        return matricMarks;
    }

    public void setMatricMarks(double matricMarks) {
        this.matricMarks = matricMarks;
    }

    public double getInterMarks() {
        return interMarks;
    }

    public void setInterMarks(double interMarks) {
        this.interMarks = interMarks;
    }

    public String getFatherCNIC() {
        return fatherCNIC;
    }

    public void setFatherCNIC(String fatherCNIC) {
        this.fatherCNIC = fatherCNIC;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getFeeStatus() {
        return feeStatus;
    }

    public void setFeeStatus(String feeStatus) {
        this.feeStatus = feeStatus;
    }
}
