package mentorship.roadmap.microservices.service_c.service;

import mentorship.roadmap.microservices.service_c.model.ServiceCRequestDto;

public interface SaveService {

    void save(ServiceCRequestDto request);
}