package mentorship.roadmap.microservices.service_b.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient serviceBWebClient(
            @Value("${service-c.url}") String serviceCUrl) {
        return WebClient.builder()
                .baseUrl(serviceCUrl)
                .build();
    }
}