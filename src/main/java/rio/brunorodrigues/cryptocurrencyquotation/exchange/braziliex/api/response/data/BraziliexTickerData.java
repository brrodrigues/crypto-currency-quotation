package rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.response.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BraziliexTickerData {

    private String active;
    private BigDecimal marketFeeDiscount;
    private String market;
    private BigDecimal last;
    private BigDecimal percentChange;
    private BigDecimal baseVolume;
    private BigDecimal baseVolume24;
    private BigDecimal quoteVolume24;
    private BigDecimal highestBid24;
    private BigDecimal lowestAsk24;
    private BigDecimal lowestAsk;
    private BigDecimal highestBid;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public BigDecimal getMarketFeeDiscount() {
        return marketFeeDiscount;
    }

    public void setMarketFeeDiscount(BigDecimal marketFeeDiscount) {
        this.marketFeeDiscount = marketFeeDiscount;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public BigDecimal getLast() {
        return last;
    }

    public void setLast(BigDecimal last) {
        this.last = last;
    }

    public BigDecimal getPercentChange() {
        return percentChange;
    }

    public void setPercentChange(BigDecimal percentChange) {
        this.percentChange = percentChange;
    }

    @JsonProperty(value = "volume")
    public BigDecimal getBaseVolume() {
        return baseVolume;
    }

    public void setBaseVolume(BigDecimal baseVolume) {
        this.baseVolume = baseVolume;
    }

    public BigDecimal getBaseVolume24() {
        return baseVolume24;
    }

    public void setBaseVolume24(BigDecimal baseVolume24) {
        this.baseVolume24 = baseVolume24;
    }

    public BigDecimal getQuoteVolume24() {
        return quoteVolume24;
    }

    public void setQuoteVolume24(BigDecimal quoteVolume24) {
        this.quoteVolume24 = quoteVolume24;
    }

    public BigDecimal getHighestBid24() {
        return highestBid24;
    }

    public void setHighestBid24(BigDecimal highestBid24) {
        this.highestBid24 = highestBid24;
    }

    public BigDecimal getLowestAsk24() {
        return lowestAsk24;
    }

    public void setLowestAsk24(BigDecimal lowestAsk24) {
        this.lowestAsk24 = lowestAsk24;
    }

    @JsonProperty(value = "sell")
    public BigDecimal getLowestAsk() {
        return lowestAsk;
    }

    public void setLowestAsk(BigDecimal lowestAsk) {
        this.lowestAsk = lowestAsk;
    }

    @JsonProperty(value = "buy")
    public BigDecimal getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(BigDecimal highestBid) {
        this.highestBid = highestBid;
    }

}
