package rabbit.send.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rabbit.send.service.RabbitProducerService;

@RestController
@RequestMapping("/rabbitmq")
public class MessageController {

    private final RabbitProducerService producerService;

    public MessageController(RabbitProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return ResponseEntity.ok("Mensaje enviado con éxito: " + message);
    }
}