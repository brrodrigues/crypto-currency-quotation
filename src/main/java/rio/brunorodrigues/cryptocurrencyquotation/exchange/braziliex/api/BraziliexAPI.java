package rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.response.BraziliexTickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.response.data.BraziliexTickerData;

import java.io.IOException;
import java.time.Duration;

@Component
public class BraziliexAPI implements TradeAPI {

    private final Logger LOG = LoggerFactory.getLogger(BraziliexAPI.class);

    public final static String URL = "https://braziliex.com/CexIOAPI/v1/public/ticker";

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Flux<BraziliexTickerResponse> getTicker() {
        LOG.info("Entrando Braziliex!!!");

        return WebClient.
                create(URL + "/btc_brl").
                get().
                retrieve().
                bodyToFlux(String.class).
                log().
                map(this::readFrom).
                map(this::prepareReturnResponse).
                delaySubscription(Duration.ofSeconds(1)).repeat();
                //exchange().flatMapMany(clientResponse -> clientResponse.bodyToFlux(String.class));
                //.repeat();

    }

    private BraziliexTickerData readFrom(String value){

        BraziliexTickerData data = null;

        try {
            data = objectMapper.readValue(value, BraziliexTickerData.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private BraziliexTickerResponse prepareReturnResponse(BraziliexTickerData data){
        BraziliexTickerResponse tickerResponse = new BraziliexTickerResponse();
        tickerResponse.setData(data);
        return tickerResponse;
    }

}
