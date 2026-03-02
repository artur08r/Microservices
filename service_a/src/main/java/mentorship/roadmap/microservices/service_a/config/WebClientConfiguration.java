package mentorship.roadmap.microservices.service_a.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient serviceBWebClient(
            @Value("${service-b.url}") String serviceBUrl) {
        return WebClient.builder()
                .baseUrl(serviceBUrl)
                .build();
    }

}