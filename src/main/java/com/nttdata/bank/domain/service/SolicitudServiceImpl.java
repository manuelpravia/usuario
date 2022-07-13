package com.nttdata.bank.domain.service;

import com.nttdata.bank.config.CacheConfig;
import com.nttdata.bank.domain.dto.SolicitudDto;
import com.nttdata.bank.infraestructure.data.document.Solicitud;
import com.nttdata.bank.infraestructure.data.repository.UsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class SolicitudServiceImpl implements  SolicitudService{

    @Autowired
    UsuarioRepository usuarioRepository;

    private final SolicitudEventService solicitudEventService;

    public SolicitudServiceImpl(SolicitudEventService solicitudEventService) {
        super();
        this.solicitudEventService = solicitudEventService;
    }

    @Override
    public Mono<SolicitudDto> create(SolicitudDto solicitudDto) {
        log.info("solicitud enviada: " + solicitudDto.toString());
        this.solicitudEventService.publish(solicitudDto);
        log.info("solicitud enviada: " + solicitudDto.toString());
        Solicitud solicitud = new Solicitud();
        solicitud.setNombre(solicitudDto.getNombre());
        solicitud.setDni(solicitudDto.getDni());
        solicitud.setEmail(solicitudDto.getEmail());
        solicitud.setTelefono(solicitudDto.getTelefono());
        solicitud.setIdModedero(solicitudDto.getIdModedero());
        solicitud.setAmount(solicitudDto.getAmount());
        solicitud.setModoPago(solicitudDto.getModoPago());
        log.info("datos que se guardan en BD: " + solicitud.toString());
        Mono.just(solicitud).doOnSuccess(solicitud1 ->usuarioRepository.save(solicitud1) );

        return Mono.just(solicitudDto);
    }


    @Cacheable(cacheNames = CacheConfig.USER_CACHE,unless = "#result==null")
    @Override
    public Mono<Solicitud> findById(String id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Flux<Solicitud> findAll() {
        return usuarioRepository.findAll();
    }
}
