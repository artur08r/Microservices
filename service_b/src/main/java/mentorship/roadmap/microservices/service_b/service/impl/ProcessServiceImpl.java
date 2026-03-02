package mentorship.roadmap.microservices.service_b.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_b.model.ServiceBRequestDto;
import mentorship.roadmap.microservices.service_b.service.ProcessService;
import mentorship.roadmap.microservices.service_b.service.ServiceCHttpService;
import mentorship.roadmap.microservices.service_b.util.MessageMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProcessServiceImpl implements ProcessService {

    private final MessageMapper messageMapper;
    private final StringRedisTemplate redisTemplate;
    private final ServiceCHttpService serviceCHttpService;

    private final String IMPORTANT = "important";

    @Override
    public void process(ServiceBRequestDto request) {

        if (IMPORTANT.equalsIgnoreCase(request.getType())) {
            String key = "important:" + request.getId();
            String value = request.getContent();
            redisTemplate.opsForValue().set(key, value, Duration.ofMinutes(5));
            log.info("Saved important message to Redis with key={} TTL=5m", key);
        }

        serviceCHttpService.sendMessageToServiceC(messageMapper.toDto(request));
    }
}