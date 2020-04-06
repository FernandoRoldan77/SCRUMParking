package com.SCRUMPakingProyect.ApiRest.apiRest.Dao;

import com.SCRUMPakingProyect.ApiRest.model.Ganancia;

public interface GananciaDAO {

    public void guardar(Ganancia ganancia);

    public Ganancia recuperar(int id);

    public void actualizar(Ganancia ganancia);

}
