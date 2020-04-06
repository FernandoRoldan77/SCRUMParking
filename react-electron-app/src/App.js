import React from "react";
import {Switch,BrowserRouter} from "react-router-dom";
import Route from "react-router-dom/es/Route";
import Home from './Home';
import GRIDParking from "./GRIDParking";
import 'bootstrap/dist/css/bootstrap.css';

export default function App() {
    return (
        <BrowserRouter>
            <div>
                <Switch>
                    <Route exact path="/"> <Home/> </Route>
                    <Route exact path="/GRIDParking"> <GRIDParking/> </Route>
                </Switch>
            </div>
        </BrowserRouter>
    )
}