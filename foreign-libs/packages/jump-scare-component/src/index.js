import React, { useState, useEffect } from 'react';
const JumpScare = () => {
  const [visible, setVisible] = useState(false);

  useEffect(() => {
    const timer = setTimeout(() => {
      setVisible(true);
    }, 3000);
    return () => clearTimeout(timer);
  }, [setVisible]);

  return (
    <h1 style={{color: "red", display: visible ? "block" : "none"}}>
      Boo! Scary Red Text!
    </h1>
  );
};
export default JumpScare;
