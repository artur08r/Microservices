package mentorship.roadmap.microservices.service_a.service.impl;

import lombok.RequiredArgsConstructor;
import mentorship.roadmap.microservices.service_a.model.ServiceBRequestDto;
import mentorship.roadmap.microservices.service_a.service.ServiceBHttpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ServiceBHttpServiceImpl implements ServiceBHttpService {

    private final WebClient webClient;

    @Value("${service-b.uri}")
    private String uri;

    @Override
    public void sendMessageToServiceB(ServiceBRequestDto message) {
        webClient.post()
                .uri(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(message)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }
}