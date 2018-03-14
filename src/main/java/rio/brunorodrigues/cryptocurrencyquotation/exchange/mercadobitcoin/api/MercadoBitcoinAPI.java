package rio.brunorodrigues.cryptocurrencyquotation.exchange.mercadobitcoin.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.mercadobitcoin.api.response.MercadorBitcoinTickerResponse;

import java.time.Duration;

@Component
public class MercadoBitcoinAPI {

    private final String TICKER_URL = "https://www.mercadobitcoin.net/api/btc/ticker/";

    public Flux<MercadorBitcoinTickerResponse> getTicker() {
        return WebClient.
                create(TICKER_URL).
                get().
                header("Content-Type", MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                bodyToFlux(MercadorBitcoinTickerResponse.class).
                delaySubscription(Duration.ofSeconds(1)).repeat();

    }
}
