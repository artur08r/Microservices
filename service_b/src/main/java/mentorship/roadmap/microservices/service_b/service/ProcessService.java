
package mentorship.roadmap.microservices.service_b.service;

import mentorship.roadmap.microservices.service_b.model.ServiceBRequestDto;

public interface ProcessService {

    void process(ServiceBRequestDto request);
}
