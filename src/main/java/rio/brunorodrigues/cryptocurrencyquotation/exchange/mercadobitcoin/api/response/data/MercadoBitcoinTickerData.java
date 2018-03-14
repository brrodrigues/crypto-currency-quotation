package rio.brunorodrigues.cryptocurrencyquotation.exchange.mercadobitcoin.api.response.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class MercadoBitcoinTickerData {

    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal volume;
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

    @JsonProperty(value = "vol")
    public void setVolume(BigDecimal volume) {
        this.volume = volume;
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

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss.SSSZ")
    public Date getDate() {
        return date;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    public void setDate(Date date) {
        this.date = date;
    }
}
