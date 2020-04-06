import 'bootstrap/dist/css/bootstrap.min.css';
import React, { Component } from 'react';
// import logo from './logo.jpeg';
import logo from './resources/img6.png';
import './CSS/principal.css';
import {withRouter} from 'react-router-dom';

class Home extends Component {
    constructor(props) {
           super(props)
           this.handleListarVehiculos = this.handleListarVehiculos.bind(this);
       }
       handleListarVehiculos = event => {
           event.preventDefault();
           this.props.history.push("/GRIDParking")
       }
       render() {
           return (
               <div className="container-fluid">
                   <div className="row">
                       <div className="col-12 text-center" id="menu">
                           <div className='titleGRID'>
                                <h1 className="titleH1">SCRUMParking</h1>
                           </div>
                           <div id="img2">
                               <img src={logo} alt="Logo"
                               />
                           </div>
                           <div className="form-group">
                               <button type="button" className="btn btn-dark btn-lg ingresar" onClick={this.handleListarVehiculos}>Ingresar</button>
                           </div>
                       </div>
                   </div>
               </div>
           );
       }
}
export default withRouter(Home);