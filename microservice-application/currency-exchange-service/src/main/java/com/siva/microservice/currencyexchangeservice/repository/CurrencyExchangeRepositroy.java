package com.siva.microservice.currencyexchangeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siva.microservice.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepositroy extends JpaRepository<CurrencyExchange, Long> {

    List<CurrencyExchange> findByFromAndTo(String from, String to);

}
