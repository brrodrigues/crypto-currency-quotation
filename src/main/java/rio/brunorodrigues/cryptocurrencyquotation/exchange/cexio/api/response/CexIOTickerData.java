package rio.brunorodrigues.cryptocurrencyquotation.exchange.cexio.api.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class CexIOTickerData {

    private BigDecimal low;
    private BigDecimal high;
    private BigDecimal last;
    private BigDecimal volume;
    private BigDecimal volume30d;
    private BigDecimal bid;
    private BigDecimal ask;


    private Date timestamp;

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getVolume30d() {
        return volume30d;
    }

    public void setVolume30d(BigDecimal volume30d) {
        this.volume30d = volume30d;
    }

    @JsonProperty(value = "buy")
    public BigDecimal getBid() {
        return bid;
    }

    public void setBid(BigDecimal bid) {
        this.bid = bid;
    }

    @JsonProperty(value = "sell")
    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "dd/MM/yyyy HH:mm:ss")
    public Date getTimestamp() {
        return timestamp;
    }

    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
