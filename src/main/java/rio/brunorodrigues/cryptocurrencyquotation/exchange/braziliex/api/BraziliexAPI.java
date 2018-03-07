package rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.response.BraziliexTickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.response.data.BraziliexTickerData;

import java.io.IOException;
import java.time.Duration;

@Component
public class BraziliexAPI  {

    public final static String URL = "https://braziliex.com/api/v1/public/ticker";

    @Autowired
    private ObjectMapper objectMapper;

    public Flux<BraziliexTickerResponse> getTicker(String ticker) {
        return WebClient.
                create(URL + "/" + ticker).
                get().
                retrieve().bodyToFlux(String.class).map(this::readFrom).map(this::prepareReturnResponse).delaySubscription(Duration.ofSeconds(1)).repeat();
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
