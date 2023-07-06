import './App.css';
import 'semantic-ui-css/semantic.min.css'

import NaviMenu from './layouts/NaviMenu';
import { Container } from 'semantic-ui-react';
import SubredditPage from './pages/HomePage';
import Dashboard from './layouts/Dashboard';
import { Route, Routes } from 'react-router-dom';
import HomePage from './pages/HomePage';
import SignInPage from './pages/SignInPage';


export const api = "http://localhost:8091/api/"

function App() {
  return (
    <div>
      <Routes>
        <Route path='/' element={<SignInPage />}/>
        <Route path="/*" element={<NaviMenu />} />
      </Routes>


      <Dashboard />
    </div>




    // <div className="App">

    //   <NaviMenu />

    //   <Container >
    //     <Dashboard />
    //   </Container>

    // </div>
  );
}

export default App;


