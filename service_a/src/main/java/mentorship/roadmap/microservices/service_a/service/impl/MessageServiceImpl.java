package mentorship.roadmap.microservices.service_a.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_a.entity.Message;
import mentorship.roadmap.microservices.service_a.model.ServiceARequestDto;
import mentorship.roadmap.microservices.service_a.repository.MessageRepository;
import mentorship.roadmap.microservices.service_a.service.MessageService;
import mentorship.roadmap.microservices.service_a.service.ServiceBHttpService;
import mentorship.roadmap.microservices.service_a.util.MessageMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final ServiceBHttpService serviceBHttpService;
    private final MessageMapper messageMapper;

    @Override
    public void analyzeMessage(ServiceARequestDto request) {
        Message message = messageMapper.toMessage(request);
        messageRepository.save(message);
        log.info(message.toString());
        serviceBHttpService.sendMessageToServiceB(messageMapper.toDto(message));
    }
}