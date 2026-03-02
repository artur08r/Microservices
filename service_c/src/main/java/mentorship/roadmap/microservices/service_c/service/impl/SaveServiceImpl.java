package mentorship.roadmap.microservices.service_c.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_c.entity.Message;
import mentorship.roadmap.microservices.service_c.kafka.KafkaProducer;
import mentorship.roadmap.microservices.service_c.model.ServiceCRequestDto;
import mentorship.roadmap.microservices.service_c.repository.MessageRepository;
import mentorship.roadmap.microservices.service_c.service.SaveService;
import mentorship.roadmap.microservices.service_c.util.MessageMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SaveServiceImpl implements SaveService {

    private final MessageMapper messageMapper;
    private final MessageRepository repository;
    private final KafkaProducer kafkaProducer;

    @Override
    public void save(ServiceCRequestDto request) {

        Message message = repository.save(messageMapper.toMessage(request));
        kafkaProducer.send(message.getId().toString(), messageMapper.toKafkaResponse(message));
    }
}