package com.newsPortal.newsPortal.model.command.news;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FilterNewsCommand {
    private Long id;
    private String headline;
    private String description;
    private String body;
    private String category;
    private String coverImage;
    private LocalDate date;
    private String author;
}
