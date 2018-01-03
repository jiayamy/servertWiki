package com.servert.wiki.service.entities;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.servert.wiki.domain.entities.ServertInfo;
import com.servert.wiki.domain.entities.ServertTypeInfo;
import com.servert.wiki.repository.entities.ServertInfoRepository;
import com.servert.wiki.repository.entities.ServertTypeRepository;
import com.servert.wiki.web.rest.vm.ServertTypeVM;

@Service
@Transactional
public class ServertTypeService {
	
	private Logger logger = LoggerFactory.getLogger(ServertTypeService.class);
	
	@Autowired
	private ServertTypeRepository servertTypeRepository;
	
	@Autowired
	private ServertInfoRepository servertInfoRepository;
	
	
	public List<ServertTypeVM> getAllServertType(){
		List<ServertTypeInfo> list = servertTypeRepository.findAll();
		List<ServertTypeVM> result = new ArrayList<>();
		for(ServertTypeInfo servertTypeInfo : list){
			List<ServertInfo> servertInfos = servertInfoRepository.findByServertType(servertTypeInfo.getType());
			ServertTypeVM servertTypeVM = new ServertTypeVM(servertTypeInfo, servertInfos);
			result.add(servertTypeVM);
		}
		return result;
	}
}
