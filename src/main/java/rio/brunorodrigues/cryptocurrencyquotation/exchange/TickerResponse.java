package rio.brunorodrigues.cryptocurrencyquotation.exchange;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public interface TickerResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "dd/MM/yyyy HH:mm:ss")
    default Date getTimestamp() {
        return new Date();
    }

}
