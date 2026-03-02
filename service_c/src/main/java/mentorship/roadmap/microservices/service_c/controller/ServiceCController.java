package mentorship.roadmap.microservices.service_c.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_c.model.ServiceCRequestDto;
import mentorship.roadmap.microservices.service_c.service.SaveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ServiceCController {

    private final SaveService saveService;

    @PostMapping("/save")
    public ResponseEntity<Void> process(@RequestBody ServiceCRequestDto request) {

        log.info("Received request in Service C: type={}", request.getType());

        saveService.save(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}