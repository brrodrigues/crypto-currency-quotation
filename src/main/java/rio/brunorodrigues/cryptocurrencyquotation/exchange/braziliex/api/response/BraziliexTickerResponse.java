package rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.response;

import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.response.data.BraziliexTickerData;

public class BraziliexTickerResponse implements TickerResponse {

    private final String exchange = "Braziliex";
    private String message;
    private BraziliexTickerData data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExchange() {
        return exchange;
    }

    public BraziliexTickerData getData() {
        return data;
    }

    public void setData(BraziliexTickerData data) {
        this.data = data;
    }

}
