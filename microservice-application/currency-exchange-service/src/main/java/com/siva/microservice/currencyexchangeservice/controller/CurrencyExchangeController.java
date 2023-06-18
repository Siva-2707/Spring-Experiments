package com.siva.microservice.currencyexchangeservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siva.microservice.currencyexchangeservice.bean.CurrencyExchange;
import com.siva.microservice.currencyexchangeservice.repository.CurrencyExchangeRepositroy;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepositroy repositroy;

    @GetMapping("/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to) {
        // CurrencyExchange currencyExchange = new CurrencyExchange(1001L, from, to, BigDecimal.valueOf(50));
        List<CurrencyExchange> findByFromAndTo = repositroy.findByFromAndTo(from, to);
        if (findByFromAndTo.size() <= 0) {
            return null;
        }

        CurrencyExchange currencyExchange = findByFromAndTo.get(0);

        currencyExchange.setEnvironment(env.getProperty("local.server.port"));

        return currencyExchange;
    }
}
