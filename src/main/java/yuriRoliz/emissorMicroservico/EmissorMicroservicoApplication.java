package yuriRoliz.emissorMicroservico;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableRabbit
@SpringBootApplication
public class EmissorMicroservicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmissorMicroservicoApplication.class, args);
	}

}
