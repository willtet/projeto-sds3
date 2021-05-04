import DataTable from 'components/DataTable';
import Footer from 'components/Footer';
import React from 'react';
import NavBar from './components/Navbar'; 

function App() {
  return (
    <>
      <NavBar/>
      <div className="container">
        <h1> Hello World</h1>
        <DataTable/>
      </div>
      <Footer />
    </>
  );
}

export default App;
