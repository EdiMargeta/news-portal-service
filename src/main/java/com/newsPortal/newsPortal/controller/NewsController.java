package com.newsPortal.newsPortal.controller;

import com.newsPortal.newsPortal.model.command.DeleteCommand;
import com.newsPortal.newsPortal.model.command.base.ApiBaseCommand;
import com.newsPortal.newsPortal.model.command.base.ApiBasePageCommand;
import com.newsPortal.newsPortal.model.command.news.FilterNewsCommand;
import com.newsPortal.newsPortal.model.command.news.SaveNewsCommand;
import com.newsPortal.newsPortal.model.dto.NewsDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBasePageDTO;
import com.newsPortal.newsPortal.service.ExchangeCurrency;
import com.newsPortal.newsPortal.service.news.NewsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class NewsController {
    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/message")
    public String test() {
        return "Hello JavaInUse Called in First Service";
    }


    @ApiOperation("Save News")
    @RequestMapping("/save")
    public ApiBaseDTO<NewsDTO> save(@RequestBody ApiBaseCommand<SaveNewsCommand> command) {
        return newsService.save(command);
    }

    @ApiOperation("Delete News")
    @RequestMapping("/delete")
    public Boolean delete(@RequestBody DeleteCommand command) {
        return newsService.delete(command);
    }

    @ApiOperation("Filter News")
    @GetMapping("/{id}")
    public ApiBaseDTO<NewsDTO> get(@PathVariable Long id){
        return newsService.get(id);
    }

    @ApiOperation("Filter All News")
    @RequestMapping("/filter-all-by-category")
    public ApiBasePageDTO<NewsDTO> filterAll(@RequestBody ApiBasePageCommand<FilterNewsCommand> command){
        return newsService.filterAll(command);
    }

    @ApiOperation("Filter Last News")
    @GetMapping("/filter-all-recent")
    public List<NewsDTO> getRecentNews(){
        return newsService.getRecentNews();
    }

    @ApiOperation("Get World news")
    @GetMapping("/world-news")
    public List<NewsDTO> getWorldNews(){
        return newsService.getWorldNews();
    }

}
