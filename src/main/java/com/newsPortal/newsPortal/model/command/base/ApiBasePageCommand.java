package com.newsPortal.newsPortal.model.command.base;

import com.newsPortal.newsPortal.model.command.base.ApiBaseCommand;
import com.newsPortal.newsPortal.model.command.base.PaginationAndSortingCommand;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiBasePageCommand<T> extends ApiBaseCommand<T> {
    private PaginationAndSortingCommand pagination = new PaginationAndSortingCommand();

}
