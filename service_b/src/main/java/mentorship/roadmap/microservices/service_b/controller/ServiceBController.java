package mentorship.roadmap.microservices.service_b.controller;

import lombok.extern.slf4j.Slf4j;
import mentorship.roadmap.microservices.service_b.model.ServiceBRequestDto;
import mentorship.roadmap.microservices.service_b.service.ProcessService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class ServiceBController {

    private final ProcessService processService;

    public ServiceBController(ProcessService processService) {
        this.processService = processService;
    }

    @PostMapping("/process")
    public ResponseEntity<Void> process(@RequestBody ServiceBRequestDto request) {

        log.info("Received request in Service B: id={}, type={}", request.getId(), request.getType());

        processService.process(request);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}