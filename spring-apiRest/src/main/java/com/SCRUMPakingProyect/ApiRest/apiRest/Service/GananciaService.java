package com.SCRUMPakingProyect.ApiRest.apiRest.Service;

import com.SCRUMPakingProyect.ApiRest.model.Ganancia;

import java.util.List;

public interface GananciaService {

    public void guardar(Ganancia ganancia);

    public Ganancia recupera(int id);

    public void actualizar(Ganancia ganancia);
}
