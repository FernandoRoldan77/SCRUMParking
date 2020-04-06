package com.SCRUMPakingProyect.ApiRest.apiRest.Service;

import com.SCRUMPakingProyect.ApiRest.model.Propietario;
import com.SCRUMPakingProyect.ApiRest.model.Vehiculo;

import java.util.List;

public interface VehiculoService {

    public void registrar(Vehiculo vehiculo);

    public void registrarVehiculoYPropietario(Vehiculo vehiculo, Propietario propietario);

    public List<Vehiculo> listarTodos();

    public Vehiculo recuperarVehiculo(int posicion);

    public Vehiculo recuperarVehiculoPorPatente(String patente);

    public void retirarVehiculo(Integer posicion);
}
