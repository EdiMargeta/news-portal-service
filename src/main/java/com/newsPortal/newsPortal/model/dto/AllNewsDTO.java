package com.newsPortal.newsPortal.model.dto;

import com.newsPortal.newsPortal.model.entity.News;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class AllNewsDTO {
    private Map<String, List<NewsDTO>> allNews;

    public static NewsDTO fromEntity(News news) {
        NewsDTO dto = new NewsDTO();
        dto.setId(news.getId());
        dto.setHeadline(news.getHeadline());
        dto.setDescription(news.getDescription());
        dto.setBody(news.getBody());
        dto.setCategory(news.getCategory());
        dto.setDate(news.getDate());
        dto.setAuthor(news.getAuthor());
        dto.setCoverImage(news.getCoverImage());

        return dto;
    }

    public static List<NewsDTO> fromList(List<News> news) {
        return news.stream().map(NewsDTO::fromEntity).collect(Collectors.toList());
    }
}
