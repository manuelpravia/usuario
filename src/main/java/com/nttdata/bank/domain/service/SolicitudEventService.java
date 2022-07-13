package com.nttdata.bank.domain.service;


import com.nttdata.bank.domain.dto.SolicitudDto;
import com.nttdata.bank.events.Event;
import com.nttdata.bank.events.EventType;
import com.nttdata.bank.events.SolicitudCreateEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;
import java.util.UUID;

@Component
public class SolicitudEventService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.solicitud.name:solicitudes}")
    private String topicCustomer;

    public void publish(SolicitudDto solicitudDto) {

        SolicitudCreateEvent created = new SolicitudCreateEvent();
        created.setData(solicitudDto);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());

        this.producer.send(topicCustomer, created);
    }
}
