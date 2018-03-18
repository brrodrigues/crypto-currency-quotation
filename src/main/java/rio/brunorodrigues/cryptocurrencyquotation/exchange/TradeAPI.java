package rio.brunorodrigues.cryptocurrencyquotation.exchange;

import reactor.core.publisher.Flux;

public interface TradeAPI {

    Flux<? extends TickerResponse> getTicker();

}
