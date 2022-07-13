package com.nttdata.bank.api;


import com.nttdata.bank.domain.dto.SolicitudDto;
import com.nttdata.bank.domain.service.SolicitudService;
import com.nttdata.bank.infraestructure.data.document.Solicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/solicitudes")
public class solicitudApi {

    @Autowired
    SolicitudService solicitudService;

    @PostMapping
    public Mono<SolicitudDto> save(@RequestBody SolicitudDto solicitudDto){
        return solicitudService.create(solicitudDto);
    }

    @GetMapping
    public Flux<Solicitud> findAll(){
        return  solicitudService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Solicitud> findById(@PathVariable String id){
        return solicitudService.findById(id);
    }
}
