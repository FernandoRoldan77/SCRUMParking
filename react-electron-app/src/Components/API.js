import axios from 'axios';

axios.defaults.baseURL = "http://localhost:8080";
axios.defaults.timeout = 20000; // 20s
axios.defaults.headers.post['Content-Type'] = 'application/json';

const crearVehiculo = ({patente,tipoVehiculo,marca,modelo,
                       documento,nombre,apellido,posicion}) => {
  return axios.post('/vehiculoIngresado', {
      patente: patente,
      tipoVehiculo: tipoVehiculo,
      marca: marca,
      modelo: modelo,
      diaDeIngreso: "",
      horaDeIngreso: "",
      propietario:{
                     documento: documento,
                      nombre: nombre,
                     apellido: apellido
                  },
      valor: 0,
      posicion: posicion
     })
  .then(response => {
    return Promise.resolve(response);
  })
  .catch(error => {
    return Promise.reject(error.response.data);
  });
}

const getVehiculo = (posicion) => {
    return axios.get(`/vehiculo/${posicion}`)
    .then(response => {
      return Promise.resolve(response);
    })
    .catch(error => {
      return Promise.reject(error.response.data);
    })
}

const getVehiculos = () => {
    return axios.get(`/vehiculos`)
    .then(response => {
      return Promise.resolve(response);
    })
    .catch(error => {
      return Promise.reject(error.response.data);
    })
}

const retirarVehiculo = (posicion) => {
    return axios.delete(`/vehiculo/${posicion}`)
    .then(response => {
      return Promise.resolve(response);
    })
    .catch(error => {
      return Promise.reject(error.response.data);
    })
}

const getValorCobrado = () => {
  return axios.get(`/valorCobrado`)
  .then(response => {
    return Promise.resolve(response);
  })
  .catch(error => {
    return Promise.reject(error.response.data);
  })
}

const getValorGanancia = () => {
  return axios.get(`/valorGanancia`)
  .then(response => {
    return Promise.resolve(response);
  })
  .catch(error => {
    return Promise.reject(error.response.data);
  })  
}

export {crearVehiculo,getVehiculos,retirarVehiculo,getVehiculo,getValorCobrado,getValorGanancia}