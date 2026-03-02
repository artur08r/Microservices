package mentorship.roadmap.microservices.service_a.service;

import mentorship.roadmap.microservices.service_a.model.ServiceBRequestDto;

public interface ServiceBHttpService {

    void sendMessageToServiceB(ServiceBRequestDto message);
}