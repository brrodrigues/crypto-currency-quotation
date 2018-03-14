package rio.brunorodrigues.cryptocurrencyquotation.exchange;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Date;

@JsonPropertyOrder(value = {"exchange","timestamp","data"})
public interface TickerResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "dd/MM/yyyy HH:mm:ss")
    default Date getTimestamp() {
        return new Date();
    }

    String getExchange();
}
