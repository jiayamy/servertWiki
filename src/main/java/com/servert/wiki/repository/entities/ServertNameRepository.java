package com.servert.wiki.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servert.wiki.domain.entities.ServertInfo;

@Repository
public interface ServertNameRepository extends JpaRepository<ServertInfo, Long>{
	
	ServertInfo findOneByServertId(Long servertId);
}
