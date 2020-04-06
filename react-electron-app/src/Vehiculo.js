import React from 'react';

export default class Object extends React.Component {
       constructor(props){
            super(props);
            this.state = {
                patente: '',
                tipoVehiculo: '',
                marca: '',
                modelo: '',
                documento: '',
                nombre: '',
                apellido: ''
            }
        }

render() {
     return(<div>
              <label>{this.state.patente}</label>
              <label>{this.state.tipoVehiculo}</label>
              <label>{this.state.marca}</label>
              <label>{this.state.modelo}</label>
              <label>{this.state.documento}</label>
              <label>{this.state.nombre}</label>
              <label>{this.state.apellido}</label>
           </div>
     )
     }


}
