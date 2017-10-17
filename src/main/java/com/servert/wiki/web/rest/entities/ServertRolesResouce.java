package com.servert.wiki.web.rest.entities;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.servert.wiki.domain.entities.ServertRole;
import com.servert.wiki.service.entities.ServertRolesService;
import com.servert.wiki.web.rest.util.PaginationUtil;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class ServertRolesResouce {
	
	private final Logger logger = LoggerFactory.getLogger(ServertRolesResouce.class);
	
	@Inject
	private ServertRolesService servertRolesService;
	
	@GetMapping("/servertRoles")
    @Timed
    public ResponseEntity<List<ServertRole>> getAllUsers(@ApiParam Pageable pageable) {
        final Page<ServertRole> page = servertRolesService.getServertRolesByLogin(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/servertRoles");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
}
