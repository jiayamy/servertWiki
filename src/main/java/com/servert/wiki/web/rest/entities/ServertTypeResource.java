package com.servert.wiki.web.rest.entities;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.servert.wiki.security.SecurityUtils;
import com.servert.wiki.service.entities.ServertTypeService;
import com.servert.wiki.web.rest.vm.ServertTypeVM;

@RestController
@RequestMapping("/api")
public class ServertTypeResource {
	
	private final Logger logger = LoggerFactory.getLogger(ServertRolesResouce.class);
	
	@Autowired
	private ServertTypeService servertTypeService;
	
	@GetMapping(value = "/servertType")
	@Timed
	public ResponseEntity<List<ServertTypeVM>> getAllServertTypes(){
		logger.info(SecurityUtils.getCurrentUserLogin() + " REST request to get a page of Servert Types");
		final List<ServertTypeVM> types = servertTypeService.getAllServertType();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(types, headers, HttpStatus.OK);
	}
}
