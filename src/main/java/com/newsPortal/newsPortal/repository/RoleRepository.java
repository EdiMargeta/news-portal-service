package com.newsPortal.newsPortal.repository;

import com.newsPortal.newsPortal.model.entity.ERole;
import com.newsPortal.newsPortal.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
