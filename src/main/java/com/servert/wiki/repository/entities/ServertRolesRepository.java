package com.servert.wiki.repository.entities;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servert.wiki.domain.entities.ServertRole;

@Repository
public interface ServertRolesRepository extends JpaRepository<ServertRole, Long>{
	
	Page<ServertRole> findAllByLogin(Pageable pageable, String login);
	
}
