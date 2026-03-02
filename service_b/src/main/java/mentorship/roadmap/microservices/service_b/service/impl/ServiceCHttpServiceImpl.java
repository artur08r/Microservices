package mentorship.roadmap.microservices.service_b.service.impl;

import lombok.RequiredArgsConstructor;
import mentorship.roadmap.microservices.service_b.model.ServiceCRequestDto;
import mentorship.roadmap.microservices.service_b.service.ServiceCHttpService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class ServiceCHttpServiceImpl implements ServiceCHttpService {

    private final WebClient webClient;

    @Value("${service-c.uri}")
    private String uri;

    @Override
    public void sendMessageToServiceC(ServiceCRequestDto request) {
        webClient.post()
                .uri(uri)
                .bodyValue(request)
                .retrieve()
                .toBodilessEntity()
                .block();
    }
}