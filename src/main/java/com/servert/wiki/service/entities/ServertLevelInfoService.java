package com.servert.wiki.service.entities;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servert.wiki.repository.entities.ServertLevelInfoRepository;
import com.servert.wiki.web.rest.vm.ServertLevelInfoVM;

@Service
@Transactional
public class ServertLevelInfoService {
	
	private Logger logger = LoggerFactory.getLogger(ServertLevelInfoService.class);
	
	@Autowired
	private ServertLevelInfoRepository servertLevelInfoRepository;
	
	public Optional<ServertLevelInfoVM> getServertLevelInfo(ServertLevelInfoVM servertLevelInfoVM){
		return Optional.of(
				servertLevelInfoRepository.findOneByServertIdAndLevel(servertLevelInfoVM.getServertId(), servertLevelInfoVM.getLevel()))
				.map(ServertLevelInfoVM::new);
	}
	
	public Optional<List<ServertLevelInfoVM>> getAllServertLevelInfo(){
		servertLevelInfoRepository.findAll();
		
		return null;
	}

}
