package rio.brunorodrigues.cryptocurrencyquotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.BinanceAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcoint.api.BitcoinTradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.BraziliexAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.mercadobitcoin.api.MercadoBitcoinAPI;

@RestController
@RequestMapping("/tickers")
public class TickerController {

    @Autowired
    private BitcoinTradeAPI bitcoinTradeAPI;

    @Autowired
    private BraziliexAPI braziliexAPI;

    @Autowired
    private MercadoBitcoinAPI mercadoBitcoinAPI;

    @Autowired
    private BinanceAPI binanceAPI;

    @GetMapping(produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
    public Flux<TickerResponse> getTickers() {
        return
                Flux.merge(
                        bitcoinTradeAPI.getTicker("BTC"),
                        mercadoBitcoinAPI.getTicker(),
                        binanceAPI.getTicker(),
                        braziliexAPI.getTicker("btc_brl")
                );

    }
}
