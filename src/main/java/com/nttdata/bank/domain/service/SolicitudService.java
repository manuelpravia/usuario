package com.nttdata.bank.domain.service;

import com.nttdata.bank.domain.dto.SolicitudDto;
import com.nttdata.bank.infraestructure.data.document.Solicitud;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SolicitudService {


    Mono<SolicitudDto> create(SolicitudDto solicitudDto);

    Mono<Solicitud> findById(String id);

    Flux<Solicitud> findAll();


}
