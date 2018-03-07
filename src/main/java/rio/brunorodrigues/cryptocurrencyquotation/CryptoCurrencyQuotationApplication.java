package rio.brunorodrigues.cryptocurrencyquotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableWebFlux
public class CryptoCurrencyQuotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoCurrencyQuotationApplication.class, args);
	}

	@Bean
	WebClient webClient() {
		return WebClient.builder().build();
	}
}
