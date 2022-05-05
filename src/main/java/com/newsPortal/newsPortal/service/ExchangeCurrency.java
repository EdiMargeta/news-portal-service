package com.newsPortal.newsPortal.service;

import com.newsPortal.newsPortal.model.dto.NewsDTO;
import com.newsPortal.newsPortal.model.dto.WorldNewsDTO;
import com.newsPortal.newsPortal.model.dto.WorldNewsResultDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="currency-exchange")
public interface ExchangeCurrency {
    @GetMapping("/world-news/get-world-news")
    public WorldNewsResultDTO getWorldNews();
}