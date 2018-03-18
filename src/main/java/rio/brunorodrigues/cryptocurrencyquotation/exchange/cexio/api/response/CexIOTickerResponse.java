package rio.brunorodrigues.cryptocurrencyquotation.exchange.cexio.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.response.BinanceTickerData;

public class CexIOTickerResponse implements TickerResponse {

    private String message;

    @JsonProperty(value = "data")
    private CexIOTickerData data;

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

    public CexIOTickerData getData() {
        return data;
    }

    public void setData(CexIOTickerData data) {
        this.data = data;
    }
}
