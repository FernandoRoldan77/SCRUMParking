package com.SCRUMPakingProyect.ApiRest.Controller;

import com.SCRUMPakingProyect.ApiRest.apiRest.Dao.VehiculoDAOImpl;
import com.SCRUMPakingProyect.ApiRest.apiRest.Service.VehiculoService;
import com.SCRUMPakingProyect.ApiRest.apiRest.Service.VehiculoServiceImpl;
import com.SCRUMPakingProyect.ApiRest.model.Vehiculo;
import com.SCRUMPakingProyect.ApiRest.runner.TransactionRunner;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//Indiciamos que es un controlador rest
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
//@RequestMapping("/api") //esta sera la raiz de la url, es decir http://127.0.0.1:8080/api/
public class VehiculoRestController {

    //Inyectamos el servicio para poder hacer uso de el
  /*  @Autowired*/
    private VehiculoService vehiculoService = new VehiculoServiceImpl(new VehiculoDAOImpl());


    @RequestMapping("/hello")
    public String index() {
        return "Spring Boot Example!!";
    }

    /*Este método se hará cuando por una petición GET (como indica la anotación) se llame a la url
    http://127.0.0.1:8080/api/vehiculos*/
    @GetMapping("/vehiculos")
    public List<Vehiculo> findAll() {
        //retornará todos los vehiculos
        return TransactionRunner.run(() -> {
            List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
            vehiculos = vehiculoService.findAll();
            return vehiculos;
        });
    }

/*
    @GetMapping("/error")
    public String getError(){
        throw new RuntimeException("Exception .. hay un problema");
    }
*/
}