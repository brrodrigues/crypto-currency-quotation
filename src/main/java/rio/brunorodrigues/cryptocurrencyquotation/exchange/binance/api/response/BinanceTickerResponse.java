package rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;

public class BinanceTickerResponse implements TickerResponse {

    private String message;

    @JsonProperty(value = "data")
    private BinanceTickerData data;

    @Override
    public String getExchange() {
        return "Binance";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BinanceTickerData getData() {
        return data;
    }

    public void setData(BinanceTickerData data) {
        this.data = data;
    }
}
