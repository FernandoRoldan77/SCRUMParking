package com.SCRUMPakingProyect.ApiRest.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
public class Vehiculo {

    @Id
    @Column(unique=true)
    @NotBlank(message = "El nombre de pantente no puede ser vacio")
    private String patente;

    @NotBlank(message = "La marca del vehiculo no puede ser vacio")
    private String marca;

    @NotBlank(message = "El modelo del vehiculo no puede ser vacio")
    private String modelo;

    private Calendar horaYdiaDeIngreso;

    @NotBlank(message = "El tipo de vehiculo no puede ser vacio")
    private String tipoVehiculo;

    //@Column(unique=true)
    @NotNull(message = "El propietario no puede ser nullo")
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Propietario propietario;

    @Min(0)
    private int posicion;

    public Vehiculo() {}

    public Vehiculo(@NotBlank(message = "El nombre de pantente no puede ser vacio") String patente, @NotBlank(message = "La marca del vehiculo no puede ser vacio") String marca, @NotBlank(message = "El modelo del vehiculo no puede ser vacio") String modelo, Calendar horaYdiaDeIngreso, @NotBlank(message = "El tipo de vehiculo no puede ser vacio") String tipoVehiculo, @NotNull(message = "El propietario no puede ser nullo") Propietario propietario, @Min(0) int posicion) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.horaYdiaDeIngreso = horaYdiaDeIngreso;
        this.tipoVehiculo = tipoVehiculo;
        this.propietario = propietario;
        this.posicion = posicion;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Calendar getHoraYdiaDeIngreso() {
        return horaYdiaDeIngreso;
    }

    public void setHoraYdiaDeIngreso(Calendar horaYdiaDeIngreso) {
        this.horaYdiaDeIngreso = horaYdiaDeIngreso;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

}
