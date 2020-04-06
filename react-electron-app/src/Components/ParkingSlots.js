import React from 'react';
import API from './API.js';

class ParkingSlots extends React.Component{
    constructor(props){
        super(props)
        this.state = {
            titulo: 'Slots',
            vehicles: [],
            tableHidden: true
        }
        this.getVehicles = this.getVehicles.bind(this);
    }

    getVehicles(){
        this.setState(oldState => ({ tableHidden: !oldState.tableHidden }));
    }

    componentDidMount(){
        API.get(`vehiculos`)
            .then(res => {
            const vehicles = res.data;
            this.setState({ vehicles });
        }).catch(console.log)
    }

    render(){
        return (
            <div>
                <h1>{this.state.titulo}</h1>
                <button className='btn btn-dark' onClick={this.getVehicles}>Show Vehicles</button>
                <div>
                    <table hidden={this.state.tableHidden} className="table table-dark">
                    <thead>
                        <tr>
                            <th scope="col">ID Vehiculo</th>
                            <th scope="col">Nombre Vehiculo</th>
                        </tr>
                    </thead>
                    <tbody>
                        { this.state.vehicles.map(vehicle =>
                            <tr key={vehicle.id}>
                                <td>{vehicle.id}</td>
                                <td>{vehicle.nombreVehiculo}</td>
                            </tr>
                        )}
                    </tbody>
                    </table>
                </div>
            </div>
        )
    }
}

export default ParkingSlots;