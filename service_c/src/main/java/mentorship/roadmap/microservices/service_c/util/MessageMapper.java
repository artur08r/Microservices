
package mentorship.roadmap.microservices.service_c.util;

import mentorship.roadmap.microservices.service_c.entity.Message;
import mentorship.roadmap.microservices.service_c.model.ServiceCRequestDto;
import mentorship.roadmap.microservices.service_c.model.ServiceCResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper {

    Message toMessage(ServiceCRequestDto request);
    ServiceCResponseDto toKafkaResponse(Message message);
}
