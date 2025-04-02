package com.coudevi;

import com.coudevi.model.Contrato;
import com.coudevi.model.TipoContrato;
import com.coudevi.model.Trabajador;
import com.coudevi.service.TrabajadorService;

import java.util.Date;

public class MainOneToOne {
    public static void main(String[] args) {

        TrabajadorService service = new TrabajadorService();

        // Crear Trabajador
         Trabajador trabajador = new Trabajador("Diego Sebastian", "Cubas Illanes");

        // Crear Contrato
         Contrato contrato = new Contrato(TipoContrato.INDEFINIDO, 8);

        // Asignar Contrato al Trabajador
         trabajador.asignarContrato(contrato);

        // Persistir
         service.crearTrabajador(trabajador);

        // Recuperar y mostrar
        service.obtenerTrabajadores().forEach(t -> {
            System.out.println("Trabajador: " + t.getNombre() + " " + t.getApellido());
            // Verificar si el trabajador tiene un contrato asociado
            if (t.getContrato() != null) {
                System.out.println("Tipo Contrato: " + t.getContrato().getTipoContrato());
                System.out.println("Horas Semanales: " + t.getContrato().getHorasSemanales());
            } else {
                System.out.println("** El trabajador no tiene contrato **");
            }
        });

        service.cerrar();
    }
}
