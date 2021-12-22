package com.newsPortal.newsPortal.service.news;

import com.newsPortal.newsPortal.model.command.DeleteCommand;
import com.newsPortal.newsPortal.model.command.base.ApiBaseCommand;
import com.newsPortal.newsPortal.model.command.base.ApiBasePageCommand;
import com.newsPortal.newsPortal.model.command.news.FilterNewsCommand;
import com.newsPortal.newsPortal.model.command.news.SaveNewsCommand;
import com.newsPortal.newsPortal.model.command.user.FilterUserCommand;
import com.newsPortal.newsPortal.model.dto.NewsDTO;
import com.newsPortal.newsPortal.model.dto.auth.UserDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBasePageDTO;

import java.util.List;

public interface NewsService {

    ApiBaseDTO<NewsDTO> save(ApiBaseCommand<SaveNewsCommand> command);

    Boolean delete(DeleteCommand command);

    ApiBasePageDTO<NewsDTO> filterAll(ApiBasePageCommand<FilterNewsCommand> command);

    ApiBaseDTO<NewsDTO> get (Long id);

    List<NewsDTO> getRecentNews ();

}
