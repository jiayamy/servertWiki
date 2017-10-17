package com.servert.wiki.service.entities;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servert.wiki.domain.entities.ServertRole;
import com.servert.wiki.repository.entities.ServertRolesRepository;
import com.servert.wiki.security.SecurityUtils;

@Service
public class ServertRolesService {
	
	private Logger logger = LoggerFactory.getLogger(ServertRolesService.class);
	
	@Inject
	private ServertRolesRepository servertRolesRepository;
	
	public Page<ServertRole> getServertRolesByLogin(Pageable pageable){
		return servertRolesRepository.findAllByLogin(pageable, SecurityUtils.getCurrentUserLogin());
	}
	
	public void saveServertRoles(ServertRole servertRole){
		servertRolesRepository.save(servertRole);
	}
}
