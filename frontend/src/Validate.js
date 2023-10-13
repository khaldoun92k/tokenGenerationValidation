import React, { useState } from 'react';
import axios from 'axios';
import { BiXCircle, BiCheckCircle } from 'react-icons/bi';

function Validate({ generatedResult }) {
  const [isValid, setIsValid] = useState(null);

  const handleClick = () => {
    axios
      .post('http://localhost:8082/validate', generatedResult)
      .then(response => {
        setIsValid(response.data);
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  };

  const isButtonDisabled = generatedResult === ""; // Check if generatedResult is null

  return (
    <div >
  <button className="btn btn-primary" onClick={handleClick} disabled={isButtonDisabled}>
     Validate
   </button>
   <div className="validate-container">
   {isValid === null && <BiXCircle className="validate-icon" style={{ color: 'grey' }} />}
   {isValid === true && <BiCheckCircle className="validate-icon" style={{ color: 'green' }} />}
   {isValid === false && <BiXCircle className="validate-icon" style={{ color: 'red' }} />}
   </div>
    </div>
  );
}

export default Validate;
