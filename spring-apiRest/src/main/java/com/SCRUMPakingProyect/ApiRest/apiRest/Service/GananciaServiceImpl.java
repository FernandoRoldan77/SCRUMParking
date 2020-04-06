package com.SCRUMPakingProyect.ApiRest.apiRest.Service;

import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.GananciaDAO;
import com.SCRUMPakingProyect.ApiRest.model.Ganancia;

public class GananciaServiceImpl implements GananciaService {

    private GananciaDAO gananciaDAO;

    public GananciaServiceImpl(GananciaDAO gananciaDAO) {
        this.gananciaDAO = gananciaDAO;
    }

    @Override
    public void guardar(Ganancia ganancia) {
        this.gananciaDAO.guardar(ganancia);
    }

    @Override
    public Ganancia recupera(int id) {
        return this.gananciaDAO.recuperar(id);
    }

    @Override
    public void actualizar(Ganancia ganancia) {
      this.gananciaDAO.actualizar(ganancia);
    }
}
