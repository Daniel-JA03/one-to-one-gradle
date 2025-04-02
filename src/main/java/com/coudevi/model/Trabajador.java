package com.coudevi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "trabajador")
public class Trabajador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @OneToOne(mappedBy = "trabajador", cascade = CascadeType.ALL, orphanRemoval = true)
    private Contrato contrato;


    public Trabajador() {
    }

    public Trabajador(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Método de conveniencia
    public void asignarContrato(Contrato con) {
        this.contrato = con;
        con.setTrabajador(this);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
