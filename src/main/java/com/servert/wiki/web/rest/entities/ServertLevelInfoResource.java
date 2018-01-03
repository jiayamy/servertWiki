package com.servert.wiki.web.rest.entities;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.servert.wiki.security.SecurityUtils;
import com.servert.wiki.service.entities.ServertLevelInfoService;
import com.servert.wiki.web.rest.util.HeaderUtil;
import com.servert.wiki.web.rest.vm.ServertLevelInfoVM;

import io.github.jhipster.web.util.ResponseUtil;

@RestController
@RequestMapping("/api")
public class ServertLevelInfoResource {
	
	private final Logger logger = LoggerFactory.getLogger(ServertLevelInfoResource.class);
	
	private static final String ENTITY_NAME = "servertLevelInfo";
	
	@Autowired
	private ServertLevelInfoService servertLevelInfoService;
	
	@PostMapping(value = "/getLevelInfo")
	@Timed
	public ResponseEntity<ServertLevelInfoVM> getServertLevelInfo(@Valid @RequestBody ServertLevelInfoVM servertLevelInfoVM){
		logger.info(SecurityUtils.getCurrentUserLogin() + " REST request to get Servert Level Info");
		if(servertLevelInfoVM.getServertId() == null || servertLevelInfoVM.getLevel() == null){
			return ResponseEntity.badRequest()
	                .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "level must between 1~100", "params error"))
	                .body(null);
		}
		Optional<ServertLevelInfoVM> servertLevelInfo = servertLevelInfoService.getServertLevelInfo(servertLevelInfoVM);
		return ResponseUtil.wrapOrNotFound(servertLevelInfo,null);
	}
}
