package rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.response.BinanceTickerData;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.response.BinanceTickerResponse;

import java.time.Duration;

@Component
public class BinanceAPI {

    private static final String TICKER_URL = "https://api.binance.com/api/v1/ticker/24hr?symbol=BTCUSDT";

    public Flux<BinanceTickerResponse> getTicker() {
        return WebClient.
                create(TICKER_URL).
                get().
                header("Content-Type", MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                bodyToFlux(BinanceTickerData.class).
                map(this::createResponseDefault).
                delaySubscription(Duration.ofSeconds(1)).repeat();

    }

    private BinanceTickerResponse createResponseDefault(BinanceTickerData tickerData){
        BinanceTickerResponse binanceTickerResponse = new BinanceTickerResponse();
        binanceTickerResponse.setData(tickerData);
        return binanceTickerResponse;
    }


}
