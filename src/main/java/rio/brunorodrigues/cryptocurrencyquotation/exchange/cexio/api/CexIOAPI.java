package rio.brunorodrigues.cryptocurrencyquotation.exchange.cexio.api;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.cexio.api.response.CexIOTickerData;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.cexio.api.response.CexIOTickerResponse;

import java.time.Duration;

@Component
public class CexIOAPI implements TradeAPI{

    private static final String TICKER_URL = "https://cex.io/api/ticker/BTC/USD";

    private Long second = 1L;

    public Flux<CexIOTickerResponse> getTicker() {
        return Flux.empty();
        /*return WebClient.
                create(TICKER_URL).
                get().
                header("Content-Type", MediaType.APPLICATION_JSON_VALUE).
                retrieve().
                //onStatus(HttpStatus::is4xxClientError, (Function<ClientResponse, Mono<? extends Throwable>>) changeRateRequest(600L)).
                //onStatus(HttpStatus::is2xxSuccessful,  (Function<ClientResponse, Mono<? extends Throwable>>) changeRateRequest(1L)).
                        bodyToFlux(CexIOTickerData.class).
                        log().
                        map(this::createResponseDefault).
                        delaySubscription(Duration.ofSeconds(second)).repeat();*/

    }

    private CexIOTickerResponse createResponseDefault(CexIOTickerData tickerData){
        CexIOTickerResponse tickerResponse = new CexIOTickerResponse();
        tickerResponse.setData(tickerData);
        return tickerResponse;
    }
}
