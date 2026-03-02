package mentorship.roadmap.microservices.service_a.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_a.model.ServiceARequestDto;
import mentorship.roadmap.microservices.service_a.service.MessageService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MessageService messageService;

    private static final String TOPIC_IN = "in";

    @KafkaListener(topics = TOPIC_IN, groupId = "service-a")
    public void consume(ConsumerRecord<String, ServiceARequestDto> record) {

        log.info("Consume message in Service A: type={}", record.value().getType());

        ServiceARequestDto message = record.value();
        messageService.analyzeMessage(message);
    }
}