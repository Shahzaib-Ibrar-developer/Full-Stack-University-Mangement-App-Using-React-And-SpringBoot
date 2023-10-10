"use client"
import { useEffect, useState } from "react";


const Home = () => {
    const [students, setStudents] = useState([]);
    const [search, setSearch] = useState("")



    useEffect(() => {
        fetch("http://localhost:8080/university/getAll")
            .then(res => res.json())
            .then((result) => {
                setStudents(result);
            })
    }, []);

    function deleteStudent(id) {
        fetch(`http://localhost:8080/university/delete/${id}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
            },
        })
            .then(response => {
                if (response.ok) {
                    console.log('Student deleted successfully');

                    // Update the state by filtering out the deleted student
                    setStudents(prevStudents => prevStudents.filter(student => student.id !== id));
                } else {
                    console.error('Error deleting student');
                    // Handle errors or show error messages
                }
            })
            .catch(error => {
                console.error('Network error:', error);
                // Handle network errors
            });
    }

    const filteredStudents = students.filter((student) =>
    student.name.toLowerCase().includes(search.toLowerCase())
);



    return (


        <>
            <div className="center-container">
                <div className="SearchBar">
                    <input
                        className="bar"
                        placeholder="Search..."
                        type="text"
                        value={search}
                        onChange={(e) => setSearch(e.target.value)}
                    />
                    <ul className="list">
                    {filteredStudents.map((student) => (
                            <li 
                                key={student.id}
                                className="listItem"
                            >
                                {student.name}
                            </li>
                        ))}
                    </ul>
                </div>
            </div>

            <div className="maindata">
                <h1>Students Information Center</h1>
                <div className="student-list">
                {filteredStudents.map((student)  => (
                        <div key={student.id} className="student-card">
                            <div className="student-header">
                                <h2>{student.name}</h2>
                                <p>ID: {student.id}</p>
                            </div>
                            <div className="student-details">
                                <p>Father Name: {student.fatherName}</p>
                                <p>CNIC: {student.cnic}</p>
                                <p>Matric Marks: {student.matricMarks}</p>
                                <p>Inter Marks: {student.interMarks}</p>
                                <p>Father CNIC: {student.fatherCNIC}</p>
                                <p>Department: {student.department}</p>
                                <p>Section: {student.section}</p>
                                <p>Admission Date: {student.admissionDate}</p>
                                <p>Fee Status: {student.feeStatus}</p>
                                <div className="btns-data">
                                    {/* <button className="bt" onClick={() => setShowUpdateUniversity(!showUpdateUniversity)}>Update</button> */}
                                    <button className="bt" onClick={() => deleteStudent(student.id)}>Delete</button>
                                </div>
                            </div>
                        </div>
                    ))}
                </div>
            </div>

        </>
    )
}


export default Home