package com.servert.wiki.repository.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servert.wiki.domain.entities.ServertTypeInfo;

@Repository
public interface ServertTypeRepository extends JpaRepository<ServertTypeInfo, Integer>{

}
