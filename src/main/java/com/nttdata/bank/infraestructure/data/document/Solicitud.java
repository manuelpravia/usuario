package com.nttdata.bank.infraestructure.data.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "solicitudes")
public class Solicitud {

    @Id
    private String id;
    private String nombre;
    private String dni;
    private String email;
    private String telefono;
    private String idModedero;
    private BigDecimal amount;
    private String modoPago;
}
