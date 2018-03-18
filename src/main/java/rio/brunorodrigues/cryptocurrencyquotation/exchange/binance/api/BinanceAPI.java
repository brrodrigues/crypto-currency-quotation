package rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.response.BinanceTickerData;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.response.BinanceTickerResponse;

import java.time.Duration;


@Component
public class BinanceAPI implements TradeAPI {

    private final Logger LOG = LoggerFactory.getLogger(BinanceAPI.class);

    private static final String TICKER_URL = "https://api.binance.com/api/v1/ticker/24hr?symbol=BTCUSDT";

    private Long second = 1L;

    @Override
    public Flux<BinanceTickerResponse> getTicker() {
        LOG.info("Entrando Binance!!!");

        return WebClient.
                create(TICKER_URL).
                get().
                header("Content-Type", MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                //onStatus(HttpStatus::is4xxClientError, (Function<ClientResponse, Mono<? extends Throwable>>) changeRateRequest(600L)).
                //onStatus(HttpStatus::is2xxSuccessful,  (Function<ClientResponse, Mono<? extends Throwable>>) changeRateRequest(1L)).
                bodyToFlux(BinanceTickerData.class).
                        log().
                map(this::createResponseDefault).
                delaySubscription(Duration.ofSeconds(second)).repeat();

    }

    private Long changeRateRequest(Long value) {
        return second = value;
    }


    private BinanceTickerResponse createResponseDefault(BinanceTickerData tickerData){
        BinanceTickerResponse binanceTickerResponse = new BinanceTickerResponse();
        binanceTickerResponse.setData(tickerData);
        return binanceTickerResponse;
    }


}
