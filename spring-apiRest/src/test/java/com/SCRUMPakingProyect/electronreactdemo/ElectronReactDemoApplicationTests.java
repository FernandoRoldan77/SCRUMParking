package com.SCRUMPakingProyect.electronreactdemo;

import com.SCRUMPakingProyect.ApiRest.model.Ganancia;
import com.SCRUMPakingProyect.ApiRest.model.Propietario;
import com.SCRUMPakingProyect.ApiRest.model.Vehiculo;
import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ElectronReactDemoApplicationTests extends BuilderTest {

    @Before
    public void setUp(){
        super.setUp();
    }

//    @After
//    public void cleanup(){
//        super.cleanup();
//    }

    @Test
    public void testParaGenerarLaEstructuraDeLaBaseDeDatos(){
        Ganancia ganancia = TransactionRunner.run(this::gananciaActual);
	    Propietario cacho = TransactionRunner.run(this::propietarioDelFiatUno);
        Vehiculo fiat = TransactionRunner.run(this::fiatUno);

        Vehiculo fiatRecuperado = super.fiatUnoRecuperado(fiat.getPosicion());
        Propietario cachoRecuperado = super.propietarioRecuperado(30456789);

        Assert.assertEquals(cacho.getDocumento(),cachoRecuperado.getDocumento());
        Assert.assertEquals(fiat.getPatente(), fiatRecuperado.getPatente());

        Assert.assertEquals(fiatRecuperado.getPropietario().getDocumento(),cachoRecuperado.getDocumento());
        Assert.assertEquals(fiatRecuperado.getPropietario().getNombre(),cachoRecuperado.getNombre());

        Calendar c = getHoraYFechaActual();
        ganancia.setPagos(cantidadDeHoras(fiatRecuperado, c,ganancia.getValorActual()));

        TransactionRunner.run(() -> this.gananciaService.actualizar(ganancia));

        Assert.assertEquals(new Double(100), ganancia.getValorActual());
    }

    private Double cantidadDeHoras(Vehiculo vehiculo, Calendar c, Double valor) {
        int cantidadDeHorasActual = c.get(Calendar.HOUR_OF_DAY) - vehiculo.getHoraYdiaDeIngreso().get(Calendar.HOUR_OF_DAY);
        if(cantidadDeHorasActual == 0) {
            return new Double(valor);
        }
        return new Double(cantidadDeHorasActual * valor);
    }

    private Calendar getHoraYFechaActual() {
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        return c;
    }
}
