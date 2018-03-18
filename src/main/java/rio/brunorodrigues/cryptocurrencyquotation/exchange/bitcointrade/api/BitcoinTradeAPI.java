package rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcointrade.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcointrade.api.response.BitcoinTradeTickerResponse;

import java.time.Duration;

@Component
public class BitcoinTradeAPI implements TradeAPI {

    private final Logger LOG = LoggerFactory.getLogger(BitcoinTradeAPI.class);

    private final String URL = "https://api.bitcointrade.com.br/v1/public/BTC/ticker";

    public Flux<BitcoinTradeTickerResponse> getTicker() {
        LOG.info("Entrando BitcoinTrade!!!");
        return
                WebClient.
                create(URL).
                get().
                header("Content-Type", MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                bodyToFlux(BitcoinTradeTickerResponse.class).
                        log().
                delaySubscription(Duration.ofSeconds(1)).repeat();

    }
}
