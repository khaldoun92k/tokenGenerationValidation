import Generate from './Generate';
import Validate from './Validate';
import React, { useState } from 'react';

function Home() {
  const [generatedResult, setGeneratedResult] = useState('');

  const handleResult = (result) => {
    setGeneratedResult(result);
  };

  return (

    
    <div className="container">
    <h1 className="title">Token Generation/Validation</h1>
      <input className="result-input" value={generatedResult} disabled></input>
        <Generate onResult={handleResult} />
        <Validate generatedResult={generatedResult} />
    </div>

  );
}

export default Home;