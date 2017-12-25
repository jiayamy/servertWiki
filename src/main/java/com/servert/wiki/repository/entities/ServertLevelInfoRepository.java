package com.servert.wiki.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servert.wiki.domain.entities.ServertLevelInfo;

@Repository
public interface ServertLevelInfoRepository extends JpaRepository<ServertLevelInfo, Long>{
	
	ServertLevelInfo findOneByServertIdAndLevel(Long servertId, Integer level);
}
