package com.SCRUMPakingProyect.ApiRest.apiRest.Service;

import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.PropietarioDAO;
import com.SCRUMPakingProyect.ApiRest.model.Propietario;

import java.util.List;

public class PropietarioServiceImpl implements PropietarioService {

    private PropietarioDAO propietarioDAO;

    public PropietarioServiceImpl(PropietarioDAO propietarioDAO) {
        this.propietarioDAO = propietarioDAO;
    }

    @Override
    public void registrar(Propietario propietario) {
        this.propietarioDAO.registrar(propietario);
    }

    @Override
    public List<Propietario> listarTodos() {
        List<Propietario> listaPropietarios= propietarioDAO.listarTodos();
        return listaPropietarios;
    }

    @Override
    public Propietario recuperarPropietario(int documento) {
        return this.propietarioDAO.recuperarPropietario(documento);
    }

    @Override
    public void eliminar(int documento) {
       this.propietarioDAO.eliminar(documento);
    }
}
