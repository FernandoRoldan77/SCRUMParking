package com.SCRUMPakingProyect.ApiRest.model;


import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
public class Propietario {

        @Id
        @Column(unique = true)
        //@Max(9)
        private int documento;

        @NotBlank(message = "El nombre no puede ser vacio")
        private String nombre;

        @NotBlank(message = "El apellido no puede ser vacio")
        private String apellido;


        public Propietario() {}

        public Propietario(int documento, @NotNull(message = "El nombre no puede ser vacio") String nombre, @NotNull(message = "El apellido no puede ser vacio") String apellido) {
           this.documento = documento;
           this.nombre = nombre;
           this.apellido = apellido;
        }


        public int getDocumento() {
                return documento;
        }

        public void setDocumento(int documento) {
                this.documento = documento;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getApellido() {
                return apellido;
        }

        public void setApellido(String apellido) {
                this.apellido = apellido;
        }


}
