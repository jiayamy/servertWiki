package com.servert.wiki.service.entities;

import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.servert.wiki.domain.entities.ServertRole;
import com.servert.wiki.repository.entities.ServertRolesRepository;
import com.servert.wiki.security.SecurityUtils;
import com.servert.wiki.web.rest.vm.ServertRoleVM;

@Service
public class ServertRolesService {
	
	private Logger logger = LoggerFactory.getLogger(ServertRolesService.class);
	
	@Inject
	private ServertRolesRepository servertRolesRepository;
	
	public Page<ServertRole> getServertRolesByLogin(Pageable pageable){
		return servertRolesRepository.findAllByLogin(pageable, SecurityUtils.getCurrentUserLogin());
	}
	
	public ServertRole saveServertRoles(ServertRoleVM servertRoleVM){
		ServertRole servertRole = new ServertRole();
		servertRole.setAtk(servertRoleVM.getAtk());
		servertRole.setHp(servertRoleVM.getHp());
		servertRole.setLevel(servertRoleVM.getLevel());
		servertRole.setLogin(SecurityUtils.getCurrentUserLogin());
		servertRole.setName(servertRoleVM.getName());
		servertRole.setSkillOneLevel(servertRoleVM.getSkillOneLevel());
		servertRole.setSkillThreeLevel(servertRoleVM.getSkillThreeLevel());
		servertRole.setSkillTwoLevel(servertRoleVM.getSkillTwoLevel());
		servertRole.setToolLevel(servertRoleVM.getToolLevel());
		servertRole.setType(servertRoleVM.getType());
		servertRolesRepository.save(servertRole);
		return servertRole;
	}
	
	public Optional<ServertRoleVM> updateServertRole(ServertRoleVM servertRoleVM){
		return Optional.of(servertRolesRepository
				.findOne(servertRoleVM.getId()))
				.map(servertRole -> {
					servertRole.setAtk(servertRoleVM.getAtk());
					servertRole.setHp(servertRoleVM.getHp());
					servertRole.setLevel(servertRoleVM.getLevel());
					servertRole.setName(servertRoleVM.getName());
					servertRole.setSkillOneLevel(servertRoleVM.getSkillOneLevel());
					servertRole.setSkillTwoLevel(servertRoleVM.getSkillTwoLevel());
					servertRole.setSkillThreeLevel(servertRoleVM.getSkillThreeLevel());
					servertRole.setToolLevel(servertRoleVM.getToolLevel());
					servertRole.setType(servertRoleVM.getType());
					servertRolesRepository.save(servertRole);
					return servertRole;
				}).map(ServertRoleVM::new);
	}
}
