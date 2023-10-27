package com.hasret.currency.controller;

import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerStatistics;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyController {
    private final BinanceApiRestClient client;


    public CurrencyController(BinanceApiRestClient binanceApiRestClient){
        this.client=binanceApiRestClient;
    }

    //for example: localhost:8080/BTCUSDT
    @GetMapping("/{pair}")
    public String price (@PathVariable String pair){
        //to get the dynamically changing prices
        TickerStatistics tickerStatistics = client.get24HrPriceStatistics(pair);
        return "The exchange rate of the pair " + pair + ":  "+ new BigDecimal(tickerStatistics.getLastPrice());
    }
}
