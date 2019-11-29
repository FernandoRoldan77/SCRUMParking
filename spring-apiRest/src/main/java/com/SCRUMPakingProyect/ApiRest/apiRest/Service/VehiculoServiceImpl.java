package com.SCRUMPakingProyect.ApiRest.apiRest.Service;

import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.PropietarioDAO;
import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.VehiculoDAO;
import com.SCRUMPakingProyect.ApiRest.model.Propietario;
import com.SCRUMPakingProyect.ApiRest.model.Vehiculo;


import java.util.List;

public class VehiculoServiceImpl implements VehiculoService {

    private VehiculoDAO vehiculoDAO;
    private PropietarioDAO propietarioDAO;


    public VehiculoServiceImpl(VehiculoDAO vehiculoDAO, PropietarioDAO propietarioDAO) {
        this.vehiculoDAO = vehiculoDAO;
        this.propietarioDAO = propietarioDAO;
    }


    @Override
        public List<Vehiculo> listarTodos() {
        List<Vehiculo> listaVehiculos= vehiculoDAO.listarTodos();
        return listaVehiculos;
    }

    @Override
    public void registrar(Vehiculo vehiculo) {
        this.vehiculoDAO.registrar(vehiculo);
    }

    @Override
    public void registrarVehiculoYPropietario(Vehiculo vehiculo, Propietario propietario) {
        this.propietarioDAO.registrar(propietario);
        this.vehiculoDAO.registrar(vehiculo);
    }

    @Override
    public Vehiculo recuperarVehiculo(String patente){
        return this.vehiculoDAO.recuperarVehiculo(patente);
    }

    @Override
    public void retirarVehiculo(String patente){
        //imprimirTicket();
        //calculoDeIngresos();
        this.vehiculoDAO.retirarVehiculo(patente);
    }
}
