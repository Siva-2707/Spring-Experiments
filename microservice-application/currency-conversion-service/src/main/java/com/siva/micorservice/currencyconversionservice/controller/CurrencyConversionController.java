package com.siva.micorservice.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.siva.micorservice.currencyconversionservice.bean.CurrencyConversion;
import com.siva.micorservice.currencyconversionservice.proxy.CurrencyExchangeProxy;

@RestController
@RequestMapping("currency-conversion")
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;

    @GetMapping("/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retriveCurrencyConversion(@PathVariable String from, @PathVariable String to,
            @PathVariable BigDecimal quantity) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        String url = "http://localhost:8000/currency-exchange/from/{from}/to/{to}";

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate().getForEntity(url,
                CurrencyConversion.class, uriVariables);
        System.out.println("Status: " + responseEntity.getStatusCode() + " Response: " + responseEntity.getBody());
        CurrencyConversion currencyConversion = responseEntity.getBody();
        if (currencyConversion == null)
            System.out.println(currencyConversion);
        else
            return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
                    currencyConversion.getConversionMultiple(),
                    currencyConversion.getConversionMultiple().multiply(quantity),
                    currencyConversion.getEnvironment() + " from Rest Template");
        return null;
        // return new CurrencyConversion(1000L, from, to, BigDecimal.valueOf(65), BigDecimal.valueOf(650));

    }

    @GetMapping("/feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retriveCurrencyConversionWithFeign(@PathVariable String from, @PathVariable String to,
            @PathVariable BigDecimal quantity) {
        CurrencyConversion currencyConversion = currencyExchangeProxy.getExchangeValue(from, to);
        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
                currencyConversion.getConversionMultiple(),
                currencyConversion.getConversionMultiple().multiply(quantity),
                currencyConversion.getEnvironment() + " from Feign");
    }

    // @GetMapping("/test")
    // public String test() {
    //     return "Test";
    // }
}
