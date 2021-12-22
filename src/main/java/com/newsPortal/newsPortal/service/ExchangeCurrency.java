package com.newsPortal.newsPortal.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange")
public interface ExchangeCurrency {
    @GetMapping("/test/message")
    public String getCurrency();
}