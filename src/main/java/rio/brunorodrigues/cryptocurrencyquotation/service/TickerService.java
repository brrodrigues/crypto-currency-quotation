package rio.brunorodrigues.cryptocurrencyquotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TickerResponse;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.TradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.binance.api.BinanceAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.bitcointrade.api.BitcoinTradeAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.braziliex.api.BraziliexAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.cexio.api.CexIOAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.coinbase.api.CoinbaseAPI;
import rio.brunorodrigues.cryptocurrencyquotation.exchange.mercadobitcoin.api.MercadoBitcoinAPI;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Get All ticker from Trade API which extends TradeAPI
 */
@Service
public class TickerService {

    private TradeAPI api;

    @Autowired
    private ApplicationContext context;

    public Flux<? extends TickerResponse> getTickers() {

        Map<String, TradeAPI> beanNamesForType = context.getBeansOfType(TradeAPI.class);

        ArrayList<TradeAPI> tradeAPIS = new ArrayList<>(beanNamesForType.values());

        Flux[] objects = new Flux[tradeAPIS.size()];

        for (int i = 0; i < tradeAPIS.size(); i++) {
            objects[i] = tradeAPIS.get(i).getTicker();

        }

        return Flux.merge(objects);

    }
}
