package mentorship.roadmap.microservices.service_b.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceBRequestDto {
    String id;
    String content;
    String type;
}