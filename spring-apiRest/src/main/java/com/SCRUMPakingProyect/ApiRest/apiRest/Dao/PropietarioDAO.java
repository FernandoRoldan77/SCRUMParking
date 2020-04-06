package com.SCRUMPakingProyect.ApiRest.apiRest.Dao;

import com.SCRUMPakingProyect.ApiRest.model.Propietario;

import java.util.List;

public interface PropietarioDAO {

    public void registrar(Propietario propietario);

    public List<Propietario> listarTodos();

    public Propietario recuperarPropietario(int documento);

    public void eliminar(int documento);
}
