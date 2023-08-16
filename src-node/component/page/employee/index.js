import axios from "axios";
import { useState, useEffect } from "react";
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';

import "bootstrap/dist/css/bootstrap.min.css";
import "sweetalert2/dist/sweetalert2.min.css";

const MySwal = withReactContent(Swal);

let Employee = () => {
  const [data, setData] = useState([{}]);
  const [id, setId] = useState(0);
  const [name, setName] = useState("");
  const [status, setStatus] = useState(false);
  const [show, setShow] = useState(false);

  const handleClose = () => {
    setId(0);
    setName('');
    setShow(false);
  };

  const handleShow = () => setShow(true);

  const handleEdit = (employee) => {
    setId(employee.employee_id);
    setName(employee.employee_name);
    handleShow();
  };

  const handleDelete = (id) => {
    MySwal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this data!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, cancel!',
    }).then((result) => {
      if (result.isConfirmed) {
        axios.delete(`http://localhost:8088/api/employee/${employee.employee_id}`)
          .then((response) => {
            if (response.data.status === 200) {
              setStatus(true);
              MySwal.fire('Deleted!', 'The employee has been deleted.', 'success');
            }
          })
          .catch((error) => {
            console.log(error);
          })
          .finally(() => {
            setStatus(false);
          });
      }
    });
  };

  const onSubmit = () => {
    handleClose();
    let requestMethod = 'POST';
    let requestUrl = 'http://localhost:8088/api/employee';

    if (id !== 0) {
      requestMethod = 'PUT';
      requestUrl = `http://localhost:8088/api/employee/${id}`;
    }

    const requestData = {
      "employee_id": id,
      "employee_name": name
    };

    axios({
      method: requestMethod,
      headers: {
        'Content-Type': 'application/json',
      },
      url: requestUrl,
      data: JSON.stringify(requestData)
    }).then((response) => {
      if (response.data.status === 200) {
        setStatus(true);
        MySwal.fire('Saved!', 'The Employee has been saved.', 'success');
      }
    }).catch((error) => {
      console.log(error);
    }).finally(() => {
      setStatus(false);
    });
  };

  useEffect(() => {
    axios({
      method: "GET",
      url: "http://localhost:8088/api/employee"
    }).then((response) => {
      setData(response.data.data);
    }).catch((error) => {
      console.log(error);
    });
  }, [status]);

  return (
    <div>
      <button onClick={handleShow}>Create</button>
      <table>
        <thead>
          <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>ACTION</th>
          </tr>
        </thead>
        <tbody>
          {data.map(x => (
            <tr key={x.employee_id}>
              <td>{x.employee_id}</td>
              <td>{x.employee_name}</td>
              <td>
                <Button variant="link" onClick={() => handleEdit(x.id)}>Edit</Button> |
                <Button variant="link" onClick={() => handleDelete(x.id)}>Delete</Button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <Modal show={show} onHide={handleClose}>
        <Modal.Header closeButton>
          <Modal.Title>Modal heading</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <input type="text" id="employee_id" value={id} onChange={e => setId(e.target.value)} />
          <input type="text" id="employee_name" value={name} onChange={e => setName(e.target.value)} />
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" onClick={onSubmit}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
};

export default Employee;
