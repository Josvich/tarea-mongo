package com.josue.tareaclasemongo.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Contactos")
@Data
public class Contactos {

    private String correo;
    private String celular;
}
