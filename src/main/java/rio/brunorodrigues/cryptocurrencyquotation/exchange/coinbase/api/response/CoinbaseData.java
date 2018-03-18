package rio.brunorodrigues.cryptocurrencyquotation.exchange.coinbase.api.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class CoinbaseData {

    private String tradeId;
    private String price;
    private String size;
    private String bid;
    private String ask;
    private Date time;

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty(value = "buy")
    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    @JsonProperty(value = "sell")
    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
