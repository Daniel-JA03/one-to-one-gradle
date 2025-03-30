package com.coudevi.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "documento")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoDocumento tipo;

    @Temporal(TemporalType.DATE)
    private Date fechaExpedicion;

    // Lado propietario: se crea la columna "persona_id"
    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    public Documento() {
        // Constructor vacío requerido por JPA
    }

    public Documento(TipoDocumento tipo, Date fechaExpedicion) {
        this.tipo = tipo;
        this.fechaExpedicion = fechaExpedicion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public Date getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(Date fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
