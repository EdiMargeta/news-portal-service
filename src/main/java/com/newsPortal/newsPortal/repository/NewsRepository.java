package com.newsPortal.newsPortal.repository;

import com.newsPortal.newsPortal.model.command.base.ApiBasePageCommand;
import com.newsPortal.newsPortal.model.command.news.FilterNewsCommand;
import com.newsPortal.newsPortal.model.dto.NewsDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBasePageDTO;
import com.newsPortal.newsPortal.model.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long>, JpaSpecificationExecutor<News> {

    @Query(value="SELECT * " +
            "FROM " +
            "(SELECT *, " +
            "ROW_NUMBER() OVER (PARTITION BY category ORDER BY date DESC) as country_rank " +
            "FROM news) ranked " +
            "WHERE country_rank <= 3;", nativeQuery=true)
    List<News> getRecentByCategories();
}

