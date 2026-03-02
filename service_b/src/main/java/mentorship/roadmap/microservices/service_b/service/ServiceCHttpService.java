package mentorship.roadmap.microservices.service_b.service;

import mentorship.roadmap.microservices.service_b.model.ServiceCRequestDto;

public interface ServiceCHttpService {

    void sendMessageToServiceC(ServiceCRequestDto request);
}