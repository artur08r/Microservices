package mentorship.roadmap.microservices.service_c.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_c.model.ServiceCResponseDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC_OUT = "out";

    private final KafkaTemplate<String, ServiceCResponseDto> kafkaTemplate;

    public void send(String key, ServiceCResponseDto value) {
        log.info("Sending message to Kafka topic={}, key={}, value={}", TOPIC_OUT, key, value);
        kafkaTemplate.send(TOPIC_OUT, key, value);
    }
}