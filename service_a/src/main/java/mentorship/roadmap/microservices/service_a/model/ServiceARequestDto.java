package mentorship.roadmap.microservices.service_a.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceARequestDto {
    String content;
    String type;
}