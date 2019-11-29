package com.SCRUMPakingProyect.ApiRest.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(unique=true)
    @NotBlank(message = "El nombre de pantente no puede ser vacio")
    private String patente;

    @NotBlank(message = "La marca del vehiculo no puede ser vacio")
    private String marca;

    @NotBlank(message = "El modelo del vehiculo no puede ser vacio")
    private String modelo;

    @NotNull(message = "El dia de ingreso no puede ser vacio")
    private String diaDeIngreso;

    @NotNull(message = "La hora de ingreso no puede ser vacio")
    private String horaDeIngreso;

    @NotNull(message = "El tipo de vehiculo no puede ser vacio")
    private String tipoVehiculo;

    //@Column(unique=true)
    @NotNull(message = "El propietario no puede ser vacio")
    @ManyToOne(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Propietario propietario;

    @Min(1)
    private int posicion;

    private int valor;

    public Vehiculo() {}

    public Vehiculo(String marca) {
        this.marca = marca;
    }

    public Vehiculo(String patente,String tipoVehiculo, String marca) {
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
    }

    public Vehiculo(@NotBlank(message = "El nombre de pantente no puede ser vacio") String patente, @NotBlank(message = "El tipo de vehiculo no puede ser vacio") String tipoVehiculo, @NotBlank(message = "La marca del vehiculo no puede ser vacio") String marca, @NotBlank(message = "El modelo del vehiculo no puede ser vacio") String modelo, Propietario propietario, @Min(1) int posicion) {
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.posicion = posicion;
    }

    public Vehiculo(int id, @NotBlank(message = "El nombre de pantente no puede ser vacio") String patente, @NotBlank(message = "El tipo de vehiculo no puede ser vacio") String tipoVehiculo, @NotBlank(message = "La marca del vehiculo no puede ser vacio") String marca, @NotBlank(message = "El modelo del vehiculo no puede ser vacio") String modelo, Propietario propietario, @Min(1) int posicion) {
        this.id = id;
        this.patente = patente;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.propietario = propietario;
        this.posicion = posicion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getHoraDeIngreso(){
        return this.horaDeIngreso;
    }

    public void setHoraDeIngreso(String horaDeIngreso){
        this.horaDeIngreso = horaDeIngreso;
    }

    public String getDiaDeIngreso(){
        return this.diaDeIngreso;
    }

    public void setDiaDeIngreso(String diaDeIngreso){
        this.diaDeIngreso = diaDeIngreso;
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

    @Override
    public String toString() {
        return "Vehiculo{" +
                "patente='" + patente + '\'' +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", propietario=" + propietario +
                ", posicion=" + posicion +
                '}';
    }
}
