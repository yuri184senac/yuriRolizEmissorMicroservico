package yuriRoliz.emissorMicroservico.controllers;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yuriRoliz.emissorMicroservico.dto.CarroDTO;

@RestController
@RequestMapping("carros")
public class CarroController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @PostMapping("/adicionar")
    @CrossOrigin(origins = "*")
    public ResponseEntity<CarroDTO> adicionarCarro(@RequestBody CarroDTO carroDTO) {
        rabbitTemplate.convertAndSend("direct-exchange-default", "queue-a-key", carroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroDTO);
    }
}
