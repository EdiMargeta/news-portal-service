package com.newsPortal.newsPortal.model.specification;

import com.newsPortal.newsPortal.model.command.news.FilterNewsCommand;
import com.newsPortal.newsPortal.model.entity.News;
import org.springframework.data.jpa.domain.Specification;

public class NewsSpecification {

    private NewsSpecification() {
    }

    public static Specification<News> getNewsSpecification(FilterNewsCommand command) {
        SharedSpecification<News> sharedSpecification = new SharedSpecification<>();
        return Specification.where((sharedSpecification.getEqual(command.getId(), "id"))
                .and(sharedSpecification.getLike(command.getHeadline(), "headline"))
                .and(sharedSpecification.getLike(command.getBody(), "body"))
                .and(sharedSpecification.getLike(command.getCategory(), "category"))
                .and(sharedSpecification.getLike(command.getDescription(), "description"))
                .and(sharedSpecification.getEqual(command.getDate(), "date"))
                .and(sharedSpecification.getLike(command.getAuthor(), "author")));
    }

}
