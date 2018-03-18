package rio.brunorodrigues.cryptocurrencyquotation.exchange.coinbase.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.coinbase.api.response.CoinbaseData;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.coinbase.api.response.CoinbaseTickerResponse;

import java.time.Duration;

@Component
public class CoinbaseAPI implements TradeAPI {

    private static final String TICKER_URL = "https://api.gdax.com/products/BTC-USD/ticker";

    private Long second = 1L;

    public Flux<CoinbaseTickerResponse> getTicker() {
        return WebClient.
                create(TICKER_URL).
                //header("Content-Type", MediaType.APPLICATION_JSON_VALUE).
                get().
                retrieve().
                bodyToFlux(CoinbaseData.class).
                log().
                map(this::createResponseDefault).
                delaySubscription(Duration.ofSeconds(second)).repeat();

    }

    private Long changeRateRequest(Long value) {
        return second = value;
    }

    private CoinbaseTickerResponse createResponseDefault(CoinbaseData tickerData){
        CoinbaseTickerResponse response = new CoinbaseTickerResponse();
        response.setData(tickerData);
        return response;
    }


}
