package com.newsPortal.newsPortal.service.news;

import com.newsPortal.newsPortal.model.command.DeleteCommand;
import com.newsPortal.newsPortal.model.command.base.ApiBaseCommand;
import com.newsPortal.newsPortal.model.command.base.ApiBasePageCommand;
import com.newsPortal.newsPortal.model.command.news.FilterNewsCommand;
import com.newsPortal.newsPortal.model.command.news.SaveNewsCommand;
import com.newsPortal.newsPortal.model.dto.NewsDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBaseDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ApiBasePageDTO;
import com.newsPortal.newsPortal.model.dto.base.base.ErrorInfo;
import com.newsPortal.newsPortal.model.dto.base.base.PageDTO;
import com.newsPortal.newsPortal.model.entity.News;
import com.newsPortal.newsPortal.model.specification.NewsSpecification;
import com.newsPortal.newsPortal.repository.NewsRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    public NewsServiceImpl(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    @Transactional
    public ApiBaseDTO<NewsDTO> save(ApiBaseCommand<SaveNewsCommand> command) {

//        News news;
//        if (command.getCommand().getId() != null) {
//            Optional<News> accountBookOptional = this.newsRepository
//                    .findByIdAndCompanyId(command.getCommand().getId(), command.getCommand().getCompanyId());
//            if (accountBookOptional.isPresent()) {
//                accountBook = accountBookOptional.get();
//                command.getCommand().updateEntity(accountBook);
//            } else {
//                return ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR);
//            }
//        } else {
        News news = command.getCommand().toEntity();
//        }
        this.newsRepository.save(news);
        return ApiBaseDTO.generateSuccessResponse(NewsDTO.fromEntity(news));


//        News news = command.getCommand().toEntity();
//        return ApiBaseDTO.generateSuccessResponse(NewsDTO.fromEntity(newsRepository.save(news)));
    }

    @Override
    public Boolean delete(DeleteCommand command) {
        newsRepository.deleteById(command.getId());
        return true;
    }

    @Override
    @Transactional
    public ApiBasePageDTO<NewsDTO> filterAll(ApiBasePageCommand<FilterNewsCommand> command) {
        Page<News> news = newsRepository.findAll(NewsSpecification.getNewsSpecification(command.getCommand()),
                command.getPagination().generatePagingAndSortingRequest());
        return ApiBasePageDTO.setApiPageResponse(NewsDTO.fromList(news.getContent()), PageDTO.ofPage(news));
    }

    @Override
    public ApiBaseDTO<NewsDTO> get(Long id) {
        return newsRepository.findById(id)
                .map(article -> ApiBaseDTO.generateSuccessResponse(NewsDTO.fromEntity(article)))
                .orElseGet(() -> ApiBaseDTO.generateErrorResponse(ErrorInfo.GENERAL_ERROR));
    }

    @Override
    public List<NewsDTO> getRecentNews() {
        List<News> news = newsRepository.getRecentByCategories();

        return NewsDTO.fromList(news);
    }

    //TODO send map instead of list to frontend, change to map in frontend also. Test if map works better then list if not, go with the list.
    public Map<String, NewsDTO> convertListAfterJava8(List<NewsDTO> news) {
        Map<String, NewsDTO> map = news.stream()
                .collect(Collectors.toMap(NewsDTO::getCategory, Function.identity()));
        return map;
    }
}
