package com.newsPortal.newsPortal.model.command.news;

import com.newsPortal.newsPortal.model.entity.News;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class SaveNewsCommand {
    private Long id;
    private String headline;
    private String description;
    private String body;
    private String category;
    private LocalDate date;
    private String author;
    private String coverImage;

    public News toEntity() {
        News news = new News();
        news.setId(this.id);
        news.setHeadline(this.headline);
        news.setDescription(this.description);
        news.setBody(this.body);
        news.setCategory(this.category);
        news.setDate(LocalDate.now());
        news.setAuthor(this.author);
        news.setCoverImage(this.coverImage);

        return news;
    }
}
