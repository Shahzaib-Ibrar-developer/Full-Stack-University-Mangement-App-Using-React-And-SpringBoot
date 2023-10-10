"use client"
import React, { useState } from "react"


const Input = () => {
    const [name, setName] = useState("")
    const [fatherName, setFatherName] = useState("")
    const [cnic, setCNIC] = useState("")
    const [matricMarks, setMatricMarks] = useState("")
    const [interMarks, setInterMarks] = useState("")
    const [fatherCNIC, setFatherCNIC] = useState("")
    const [department, setDepartment] = useState("")
    const [section, setSection] = useState("")
    const [admissionDate, setAddmissionDate] = useState("")
    const [feeStatus, setFeeStatus] = useState("")
    const [data, setData] = useState([])
  

        const HandleFormSubmition = (e) => {
            e.preventDefault();
            const university = { name, fatherName, cnic, matricMarks, interMarks, fatherCNIC, department, section, admissionDate, feeStatus };
            fetch("http://localhost:8080/university/add", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(university)
            }).then(() => {
                alert("New Student Add")
                console.log("New Student Add")
            })
            .then(() => {
                console.log("New Student Added");
                // Reset form fields here
                setName("");
                setFatherName("");
                setCNIC("");
                setMatricMarks("");
                setInterMarks("");
                setFatherCNIC("");
                setDepartment("");
                setSection("");
                setFeeStatus("");
                setAddmissionDate("");
                // ... (reset other fields)
            })
            .catch((error) => {
                console.error("Error adding student:", error);
            });
        }
        
    return (
        <div className="form-bg">
        <form onSubmit={HandleFormSubmition}>
            <label>
                Name:
                <input
                    value={name}
                    type="text"
                    onChange={(e) => setName(e.target.value)}
                />
            </label>
            <label>
                Father Name:
                <input
                    value={fatherName}
                    type="text"
                    onChange={(e) => setFatherName(e.target.value)}
                />
            </label>
            <label>
                CNIC:
                <input
                    value={cnic}
                    type="text"
                    onChange={(e) => setCNIC(e.target.value)}
                />
            </label>
            <label>
                Matric Marks:
                <input
                    value={matricMarks}
                    type="text"
                    onChange={(e) => setMatricMarks(e.target.value)}
                />
            </label>
            <label>
                InterMarks:
                <input
                    value={interMarks}
                    type="text"
                    onChange={(e) => setInterMarks(e.target.value)}
                />
            </label>
            <label>
                FatherCNIC:
                <input
                    value={fatherCNIC}
                    type="text"
                    onChange={(e) => setFatherCNIC(e.target.value)}
                />
            </label>
            <label>
                Department:
                <input
                    value={department}
                    type="text"
                    onChange={(e) => setDepartment(e.target.value)}
                />
            </label>
            <label>
                Section:
                <input
                    value={section}
                    type="text"
                    onChange={(e) => setSection(e.target.value)}
                />
            </label>
            <label>
                Addmission Date:
                <input
                    value={admissionDate}
                    type="date"
                    onChange={(e) => setAddmissionDate(e.target.value)}
                />
            </label>
            <label>
                Fee Status:
                <input
                    value={feeStatus}
                    type="text"
                    onChange={(e) => setFeeStatus(e.target.value)}
                />
            </label>

            <button className="btn" type="submit">Submit</button>
        </form>
        </div>
    )
}


export default Input