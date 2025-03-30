package com.coudevi;

import com.coudevi.model.Documento;
import com.coudevi.model.Persona;
import com.coudevi.model.TipoDocumento;
import com.coudevi.service.PersonaService;

import java.util.Date;

public class MainOneToOne {
    public static void main(String[] args) {
        PersonaService service = new PersonaService();

        // Crear persona
        Persona persona = new Persona("Juan Pérez 2");

        // Crear documento
        Documento doc = new Documento(TipoDocumento.CARNET_EXTRANJERIA, new Date());

        // Asignar documento a la persona
        persona.asignarDocumento(doc);

        // Persistir
        service.crearPersona(persona);

        // Recuperar y mostrar
        service.obtenerPersonas().forEach(p -> {
            System.out.println("Persona: " + p.getNombre());
            if (p.getDocumento() != null) {
                System.out.println("  Documento Tipo: " + p.getDocumento().getTipo());
                System.out.println("  Fecha Exp: " + p.getDocumento().getFechaExpedicion());
            }
        });

        service.cerrar();
    }
}
