package rio.brunorodrigues.cryptocurrencyquotation.exchange.coinbase.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;

public class CoinbaseTickerResponse implements TickerResponse {

    private String message;

    @JsonProperty(value = "data")
    private CoinbaseData data;

    @Override
    public String getExchange() {
        return "Coinbase";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CoinbaseData getData() {
        return data;
    }

    public void setData(CoinbaseData data) {
        this.data = data;
    }
}
