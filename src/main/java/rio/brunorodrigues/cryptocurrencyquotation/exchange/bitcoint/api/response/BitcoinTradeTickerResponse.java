package rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcoint.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcoint.api.response.data.BitcoinTradeTickerData;

import java.util.Date;

public class BitcoinTradeTickerResponse implements TickerResponse {

    private final String exchange = "BitcoinTrade";

    private String message;
    private BitcoinTradeTickerData data;

    public String getExchange() {
        return exchange;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public BitcoinTradeTickerData getData() {
        return data;
    }

    public void setData(BitcoinTradeTickerData data) {
        this.data = data;
    }

}
