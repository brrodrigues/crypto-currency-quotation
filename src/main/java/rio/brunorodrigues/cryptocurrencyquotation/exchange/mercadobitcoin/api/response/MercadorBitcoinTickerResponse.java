package rio.brunorodrigues.cryptocurrencyquotation.exchange.mercadobitcoin.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.mercadobitcoin.api.response.data.MercadoBitcoinTickerData;

public class MercadorBitcoinTickerResponse implements TickerResponse {

    private final String exchange = "MercadoBitcoin";
    private String message;
    private MercadoBitcoinTickerData data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonProperty( value = "data")
    public MercadoBitcoinTickerData getData() {
        return data;
    }

    @JsonProperty( value = "ticker")
    public void setData(MercadoBitcoinTickerData data) {
        this.data = data;
    }

    @Override
    public String getExchange() {
        return exchange;
    }

}
