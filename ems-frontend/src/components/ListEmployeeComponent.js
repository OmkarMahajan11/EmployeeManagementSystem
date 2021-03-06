import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import EmployeeService from "../services/EmployeeService";

const ListEmployeeComponent = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    getAllEmployees();
  }, []);

  function getAllEmployees() {
    EmployeeService.getAllEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => console.log(error));
  }

  function deleteEmployee(id) {
    EmployeeService.deleteEmployee(id)
      .then((response) => {
        getAllEmployees();
      })
      .catch((error) => console.log(error));
  }

  return (
    <div className="container">
      <h2 className="text-center">List Employees</h2>
      <Link to="/add-employee" className="btn btn-primary mb-2">
        Add Employee
      </Link>
      <table className="table table-border table-striped">
        <thead>
          <th>Employee Id</th>
          <th>Employee First Name</th>
          <th>Employee Last Name</th>
          <th>Employee Email Id</th>
          <th>Actions</th>
        </thead>
        <tbody>
          {employees.map((e) => {
            return (
              <tr key={e.id}>
                <td>{e.id}</td>
                <td>{e.firstName}</td>
                <td>{e.lastName}</td>
                <td>{e.emailId}</td>
                <td>
                  <Link className="btn btn-info" to={`/edit-employee/${e.id}`}>
                    Update
                  </Link>
                  <button
                    className="btn btn-danger"
                    onClick={() => {
                      deleteEmployee(e.id);
                    }}
                    style={{ marginLeft: "10px" }}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default ListEmployeeComponent;
