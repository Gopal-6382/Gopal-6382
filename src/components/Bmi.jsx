import React, { useState } from 'react';

const BMICalculatorBox = () => {
  const [height, setHeight] = useState('');
  const [weight, setWeight] = useState('');
  const [bmi, setBMI] = useState(null);
  const [error, setError] = useState('');

  const calculateBMI = () => {
    setError('');
    const h = parseFloat(height);
    const w = parseFloat(weight);

    if (isNaN(h) || isNaN(w) || h <= 0 || w <= 0) {
      setBMI(null);
      setError('Please enter valid positive numbers for height and weight.');
      return;
    }

    const result = w / ((h / 100) ** 2);
    setBMI(result.toFixed(2));
  };

  const resetForm = () => {
    setHeight('');
    setWeight('');
    setBMI(null);
    setError('');
  };

  const containerStyle = {
    width: '100vw',
    height: '100vh',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#f0f2f5',
  };

  const boxStyle = {
    display: 'flex',
    flexDirection: 'row',
    backgroundColor: '#ffffff',
    borderRadius: '16px',
    boxShadow: '0 8px 20px rgba(0,0,0,0.1)',
    width: '90%',
    maxWidth: '900px',
    height: 'auto',
    overflow: 'hidden',
  };

  const leftStyle = {
    flex: 1,
    backgroundColor: '#e6f0ff',
    display: 'flex',
    justifyContent: 'center',
    alignItems: 'center',
    padding: '20px',
  };

  const imageStyle = {
    width: '100%',
    maxWidth: '300px',
    borderRadius: '12px',
  };

  const rightStyle = {
    flex: 1,
    padding: '30px',
    display: 'flex',
    flexDirection: 'column',
    justifyContent: 'center',
  };

  const inputStyle = {
    padding: '12px',
    marginBottom: '12px',
    borderRadius: '8px',
    border: '1px solid #ccc',
    fontSize: '16px',
  };

  const buttonStyle = {
    padding: '12px',
    borderRadius: '8px',
    fontSize: '16px',
    marginRight: '10px',
    cursor: 'pointer',
    border: 'none',
  };

  return (
    <div style={containerStyle}>
      <div style={boxStyle}>
        {/* Left - Image */}
        <div style={leftStyle}>
          <img
            src="https://images.pexels.com/photos/12599543/pexels-photo-12599543.jpeg"
            alt="BMI"
            style={imageStyle}
          />
        </div>

        {/* Right - Form */}
        <div style={rightStyle}>
          <h2 style={{ marginBottom: '16px', color: '#333' }}>BMI Calculator</h2>

          <input
            type="number"
            placeholder="Enter height in cm"
            value={height}
            onChange={(e) => setHeight(e.target.value)}
            style={inputStyle}
          />

          <input
            type="number"
            placeholder="Enter weight in kg"
            value={weight}
            onChange={(e) => setWeight(e.target.value)}
            style={inputStyle}
          />

          <div style={{ display: 'flex', marginBottom: '12px' }}>
            <button
              onClick={calculateBMI}
              style={{
                ...buttonStyle,
                backgroundColor: '#2563eb',
                color: '#fff',
              }}
            >
              Calculate
            </button>
            <button
              onClick={resetForm}
              style={{
                ...buttonStyle,
                backgroundColor: '#9ca3af',
                color: '#fff',
              }}
            >
              Reset
            </button>
          </div>

          {error && <p style={{ color: 'red' }}>{error}</p>}

          {bmi && !error && (
            <div style={{ color: 'green', fontWeight: 'bold' }}>
              Your BMI is: {bmi}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default BMICalculatorBox;
