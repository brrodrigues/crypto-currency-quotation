package rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcoint.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcoint.api.response.BitcoinTradeTickerResponse;

import java.time.Duration;

@Component
public class BitcoinTradeAPI {

    private final String URL = "https://api.bitcointrade.com.br/v1/public/BTC/ticker";

    public Flux<BitcoinTradeTickerResponse> getTicker(String ticker) {
        return WebClient.
                create(URL).
                get().
                header("Content-Type", MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                bodyToFlux(BitcoinTradeTickerResponse.class).
                delaySubscription(Duration.ofSeconds(1)).repeat();

    }
}
