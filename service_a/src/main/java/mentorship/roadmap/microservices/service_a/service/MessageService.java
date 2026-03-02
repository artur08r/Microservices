package mentorship.roadmap.microservices.service_a.service;

import mentorship.roadmap.microservices.service_a.model.ServiceARequestDto;

public interface MessageService {

    void analyzeMessage(ServiceARequestDto message);
}