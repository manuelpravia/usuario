package com.nttdata.bank.infraestructure.data.repository;

import com.nttdata.bank.infraestructure.data.document.Solicitud;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UsuarioRepository extends ReactiveMongoRepository<Solicitud,String> {

}
