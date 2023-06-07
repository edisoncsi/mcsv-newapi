package eco.com.spring.mcsv.newapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class McsvNewapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(McsvNewapiApplication.class, args);
	}

}
