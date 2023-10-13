import React, { useState } from 'react';
import Select from 'react-select';
import axios from 'axios';
import { BiInfoCircle } from 'react-icons/bi';

const options = [
  { value: '0', label: '0' },
  { value: '1', label: '1' },
  { value: '2', label: '2' },
  { value: '3', label: '3' },
  { value: '4', label: '4' },
  { value: '5', label: '5' },
  { value: '6', label: '6' },
  { value: '7', label: '7' },
  { value: '8', label: '8' },
  { value: '9', label: '9' }
];

function Generate({ onResult }) {
  const [selectedDigits, setSelectedDigits] = useState([]);

  const handleChange = (selectedOptions) => {
    setSelectedDigits(selectedOptions.map(option => parseInt(option.value)));
  };

  const handleClick = () => {
    axios
      .post('http://localhost:8081/generate', Array.from(selectedDigits))
      .then(response => {
        onResult("");
        onResult(response.data); // Call the callback function with the result
      })
      .catch(error => {
        console.error('There was an error!', error);
      });
  };

  const isButtonDisabled = selectedDigits.length === 0; // Check if selectedDigits is empty

  return (
    <div className="generate-container">
      <div className="generate-input"><Select
        isMulti
        name="Digits"
        options={options}
        className="select-input"
        classNamePrefix="select"
        onChange={handleChange}
      />
      <BiInfoCircle className="info" data-toggle="tooltip" title="Select at least one digit to generate token"></BiInfoCircle>
      </div>
      <button onClick={handleClick} disabled={isButtonDisabled} className="btn btn-success">Generate</button>
    </div>
  );
}

export default Generate;
