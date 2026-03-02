package mentorship.roadmap.microservices.service_a.util;

import mentorship.roadmap.microservices.service_a.entity.Message;
import mentorship.roadmap.microservices.service_a.model.ServiceARequestDto;
import mentorship.roadmap.microservices.service_a.model.ServiceBRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message toMessage(ServiceARequestDto request);
    ServiceBRequestDto toDto(Message message);
}