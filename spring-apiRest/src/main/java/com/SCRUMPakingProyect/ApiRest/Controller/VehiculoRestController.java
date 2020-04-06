package com.SCRUMPakingProyect.ApiRest.Controller;

import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.GananciaDAOImpl;
import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.PropietarioDAOImpl;
import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.VehiculoDAOImpl;
import com.SCRUMPakingProyect.ApiRest.apiRest.Service.*;
import com.SCRUMPakingProyect.ApiRest.model.Ganancia;
import com.SCRUMPakingProyect.ApiRest.model.Vehiculo;
import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Document;
import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

//Indiciamos que es un controlador rest
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class VehiculoRestController {

    private VehiculoService vehiculoService = new VehiculoServiceImpl(new VehiculoDAOImpl(),new PropietarioDAOImpl());
    private GananciaService gananciaService = new GananciaServiceImpl(new GananciaDAOImpl());
    private PropietarioService propietarioService = new PropietarioServiceImpl(new PropietarioDAOImpl());

    @GetMapping("/vehiculo/{posicion}")
    public Vehiculo vehiculo(@PathVariable Integer posicion) {
           return TransactionRunner.run(() -> vehiculoService.recuperarVehiculo(posicion));
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://8080/api/vehiculos*/
    @GetMapping("/vehiculos")
    public List<Vehiculo> vehiculos() {
        //retornará todos los vehiculos
        return TransactionRunner.run(() -> {
            List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
            vehiculos = vehiculoService.listarTodos();
            return vehiculos;
        });
    }

    @PostMapping("/vehiculoIngresado")
    public void ingresarVehiculo(@Valid @RequestBody Vehiculo vehiculo) {
        Calendar c = getHoraYFechaActual();
        vehiculo.setHoraYdiaDeIngreso(c);

        TransactionRunner.run(() -> vehiculoService.registrarVehiculoYPropietario(vehiculo,vehiculo.getPropietario()));
    }

    private Calendar getHoraYFechaActual() {
        Date d = new Date();
        Calendar c = new GregorianCalendar();
        c.setTime(d);
        return c;
    }

    @DeleteMapping("/vehiculo/{posicion}")
    public void retirarVehiculo(@PathVariable int posicion) {
            Vehiculo vehiculo = this.vehiculo(posicion);

//            int documeto = vehiculo.getPropietario().getDocumento();

            Calendar c = getHoraYFechaActual();

            Ganancia ganancia = TransactionRunner.run(() -> this.gananciaService.recupera(1));

            ganancia.setPagos(cantidadDeHoras(vehiculo, c,ganancia.getValorActual()));
            ganancia.setPrecioCobrado(cantidadDeHoras(vehiculo, c,ganancia.getValorActual()));

            TransactionRunner.run(() -> this.gananciaService.actualizar(ganancia));

            TransactionRunner.run(() ->  this.vehiculoService.retirarVehiculo(posicion));

//            TransactionRunner.run(() ->  this.propietarioService.eliminar(documeto));

    }

    private Double cantidadDeHoras(Vehiculo vehiculo, Calendar c,Double valor) {
        int cantidadDeHorasActual = c.get(Calendar.HOUR_OF_DAY) - vehiculo.getHoraYdiaDeIngreso().get(Calendar.HOUR_OF_DAY);
          if(cantidadDeHorasActual <= 1) {
              return valor;
          }
          return new Double(cantidadDeHorasActual * valor);
    }

    @GetMapping("/valorGanancia")
    public Double getGanaciaActual(){
        Ganancia ganancia = TransactionRunner.run(() -> this.gananciaService.recupera(1));
        ganancia.ganaciaActual();
        return ganancia.getValorActual();
    }

    @GetMapping("/valorCobrado")
    public Double getValorCobrado(){
        Ganancia ganancia = TransactionRunner.run(() -> this.gananciaService.recupera(1));
        return ganancia.getPrecioCobrado();
    }

    @PostMapping("/ganancia")
    public void ganancia(@Valid @RequestBody Ganancia ganancia){
         TransactionRunner.run(() -> this.gananciaService.guardar(ganancia));
    }

    @GetMapping("/error")
    public String getError(){
        throw new RuntimeException("Exception .. hay un problema");
    }
}
