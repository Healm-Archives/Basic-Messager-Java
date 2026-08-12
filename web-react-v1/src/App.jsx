import './App.css';

import { Navigate, Outlet, Route, Routes } from 'react-router-dom';
import Login from './components/login/login';
import Dashboard from './components/daskboard/dashboard';
import Nav from './components/nav/nav';
import Register from './components/register/register';

function App() {

  return (

    <div className="App">
      <Routes >

        <Route path = "/" element = {
          <>
            <Nav />
            <div className = "App-section">
              <Outlet />
            </div>
          </>
        }>

          <Route index element = {
            <>                              
                hello
            </>
          } />

          <Route path = "/login" element = { <Login /> } />

          <Route path = "/register" element = { <Register/> } />

          <Route path = "/home" element = { <Dashboard />} />

          <Route path = "*" element = {
            <Navigate to = "/login" replace/>
          }/>

        </Route>

      </Routes>

    </div>

  );

}

export default App
