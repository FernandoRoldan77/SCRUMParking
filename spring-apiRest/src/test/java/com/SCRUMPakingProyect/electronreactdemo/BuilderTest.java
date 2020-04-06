package com.SCRUMPakingProyect.electronreactdemo;

import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.*;
import com.SCRUMPakingProyect.ApiRest.apiRest.Service.*;
import com.SCRUMPakingProyect.ApiRest.model.Ganancia;
import com.SCRUMPakingProyect.ApiRest.model.Propietario;
import com.SCRUMPakingProyect.ApiRest.model.Vehiculo;
import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.tomcat.jni.Local;
import sun.util.calendar.BaseCalendar;
import sun.util.calendar.LocalGregorianCalendar;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner.run;

public class BuilderTest {
    protected DataDAO dataDAO;
    protected VehiculoDAOImpl vehiculoDAO;
    protected GananciaDAO gananciaDAO;
    protected GananciaService gananciaService;
    protected VehiculoService vehiculoService;
    protected PropietarioDAO propietarioDAO;
    protected PropietarioService propietarioService;

    public BuilderTest(){}

    public void setUp() {
        this.dataDAO = new HibernateDataDAOImpl();
        this.vehiculoDAO = new VehiculoDAOImpl();
        this.propietarioDAO = new PropietarioDAOImpl();
        this.gananciaDAO = new GananciaDAOImpl();
        this.gananciaService = new GananciaServiceImpl(gananciaDAO);
        this.vehiculoService = new VehiculoServiceImpl(vehiculoDAO, propietarioDAO);
        this.propietarioService = new PropietarioServiceImpl(propietarioDAO);
    }

    public void cleanup() {
        run(() -> dataDAO.clear());
    }

    public Propietario propietarioDelFiatUno() {
        Propietario propietarioDelFiatUno = new Propietario(30456789,"Cacho","Try");
        this.propietarioDAO.registrar(propietarioDelFiatUno);
        return propietarioDelFiatUno;
    }

    public Propietario cacho = new Propietario(30456789, "Cacho", "Try");

    public Vehiculo fiatUno() {
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        Vehiculo fiatUno = new Vehiculo("FIA123","FIAT","FIAT UNO" ,c,"Auto",cacho,1);
        this.vehiculoService.registrar(fiatUno);
        return fiatUno;
    }

    public Ganancia gananciaActual() {
        Ganancia ganancia = new Ganancia(new Double(100));
        this.gananciaService.guardar(ganancia);
        return ganancia;
    }
/*
    public Vehiculo renaultDoce(){
        Vehiculo renaultDoce = new Vehiculo("REN456","Auto","RENAULT", "DOCE",cacho,2);
        renaultDoce.setDiaDeIngreso("HOY");
        renaultDoce.setHoraDeIngreso(LocalTime.now().toString());
        this.vehiculoService.registrar(renaultDoce);
        return renaultDoce;
    }
*/
    public Vehiculo fiatUnoRecuperado(Integer posicion) {
        return TransactionRunner.run(() ->
                this.vehiculoService.recuperarVehiculo(posicion));
    }

    public Propietario propietarioRecuperado(int documento) {
        return TransactionRunner.run(() ->
                this.propietarioService.recuperarPropietario(documento));
    }

    public Vehiculo renaultDoceRecuperado(Integer posicion) {
        return TransactionRunner.run(() ->
                this.vehiculoService.recuperarVehiculo(posicion));
    }

    public Vehiculo fordKaRecuperado(Integer posicion) {
        return TransactionRunner.run(() ->
                this.vehiculoService.recuperarVehiculo(posicion));
    }
}
