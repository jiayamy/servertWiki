package com.servert.wiki.repository.entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servert.wiki.domain.entities.ServertInfo;

@Repository
public interface ServertInfoRepository extends JpaRepository<ServertInfo, Long>{
	
	List<ServertInfo> findByServertType(Integer servertType);

}
