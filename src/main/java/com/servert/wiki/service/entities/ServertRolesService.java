package com.servert.wiki.service.entities;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servert.wiki.domain.entities.ServertLevelInfo;
import com.servert.wiki.domain.entities.ServertInfo;
import com.servert.wiki.domain.entities.ServertRole;
import com.servert.wiki.repository.entities.ServertLevelInfoRepository;
import com.servert.wiki.repository.entities.ServertNameRepository;
import com.servert.wiki.repository.entities.ServertRolesRepository;
import com.servert.wiki.security.SecurityUtils;
import com.servert.wiki.web.rest.vm.ServertRoleVM;

@Service
@Transactional
public class ServertRolesService {
	
	private Logger logger = LoggerFactory.getLogger(ServertRolesService.class);
	
	@Autowired
	private ServertRolesRepository servertRolesRepository;
	
	@Autowired
	private ServertNameRepository servertNameRepository;
	
	@Autowired
	private ServertLevelInfoRepository servertLevelInfoRepository;
	
	public Page<ServertRoleVM> getServertRolesByLogin(Pageable pageable){
		Page<ServertRoleVM> datas = servertRolesRepository.findAllByLogin(pageable, SecurityUtils.getCurrentUserLogin()).map(ServertRoleVM::new);
		List<ServertRoleVM> list = datas.getContent();
		for(ServertRoleVM servertRoleVM : list){
			Long servertId = servertRoleVM.getServertId();
			Integer level = servertRoleVM.getLevel();
			ServertInfo servertName = servertNameRepository.findOneByServertId(servertId);
			if(servertName != null){
				servertRoleVM.setName(servertName.getServertName());
			}
			ServertLevelInfo servertLevelInfo = servertLevelInfoRepository.findOneByServertIdAndLevel(servertId, level);
			if(servertLevelInfo != null){
				servertRoleVM.setAtk(servertLevelInfo.getAtk());
				servertRoleVM.setHp(servertLevelInfo.getHp());
			}
		}
		return datas;
	}
	
	public ServertRole saveServertRoles(ServertRoleVM servertRoleVM){
		ServertRole servertRole = new ServertRole();
		servertRole.setServertId(servertRoleVM.getServertId());
		servertRole.setLevel(servertRoleVM.getLevel());
		servertRole.setLogin(SecurityUtils.getCurrentUserLogin());
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
					servertRole.setServertId(servertRoleVM.getServertId());
					servertRole.setLevel(servertRoleVM.getLevel());
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
