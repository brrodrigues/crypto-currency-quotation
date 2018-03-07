package rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcoint.api.response.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class BitcoinTradeTickerData {

    private BigDecimal high;
    private BigDecimal volume;
    @JsonProperty(value = "trades_quantity")
    private BigDecimal tradesQuantity;
    private BigDecimal last;
    private BigDecimal buy;
    private BigDecimal sell;
    private Date date;

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getTradesQuantity() {
        return tradesQuantity;
    }

    public void setTradesQuantity(BigDecimal tradesQuantity) {
        this.tradesQuantity = tradesQuantity;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getBuy() {
        return buy;
    }

    public void setBuy(BigDecimal buy) {
        this.buy = buy;
    }

    public BigDecimal getSell() {
        return sell;
    }

    public void setSell(BigDecimal sell) {
        this.sell = sell;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
