package mentorship.roadmap.microservices.service_b.util;

import mentorship.roadmap.microservices.service_b.model.ServiceBRequestDto;
import mentorship.roadmap.microservices.service_b.model.ServiceCRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    ServiceCRequestDto toDto(ServiceBRequestDto message);
}