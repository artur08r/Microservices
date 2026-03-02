package mentorship.roadmap.microservices.service_a.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
@Getter
@Setter
@ToString
public class Message {

    @Id
    private String id;

    private String type;

    private String content;
}