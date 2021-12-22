package com.newsPortal.newsPortal.model.specification;

import com.newsPortal.newsPortal.model.command.user.FilterUserCommand;
import com.newsPortal.newsPortal.model.entity.User;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {

    private UserSpecification() {
    }

    public static Specification<User> getUserSpecification(FilterUserCommand command) {
        SharedSpecification<User> sharedSpecification = new SharedSpecification<>();
        return Specification.where((sharedSpecification.getEqual(command.getId(), "id")));
    }
}
