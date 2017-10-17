package com.servert.wiki.web.rest.entities;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.servert.wiki.domain.entities.ServertRole;
import com.servert.wiki.security.SecurityUtils;
import com.servert.wiki.service.entities.ServertRolesService;
import com.servert.wiki.web.rest.util.HeaderUtil;
import com.servert.wiki.web.rest.util.PaginationUtil;
import com.servert.wiki.web.rest.vm.ServertRoleVM;

import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/api")
public class ServertRolesResouce {
	
	private final Logger logger = LoggerFactory.getLogger(ServertRolesResouce.class);
	
	private static final String ENTITY_NAME = "entities";
	
	@Inject
	private ServertRolesService servertRolesService;
	
	@GetMapping("/servertRoles")
    @Timed
    public ResponseEntity<List<ServertRole>> getAllServertRoles(@ApiParam Pageable pageable) {
        logger.info(SecurityUtils.getCurrentUserLogin() + " REST request to get a page of Servert Roles");
		final Page<ServertRole> page = servertRolesService.getServertRolesByLogin(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/servertRoles");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }
	
	@PostMapping("/addServertRole")
	@Timed
	public ResponseEntity saveServertRoles(@Valid @RequestBody  ServertRoleVM servertRoleVM) throws URISyntaxException{
		logger.info(SecurityUtils.getCurrentUserLogin() + " REST request to add Servert Roles");
		if (servertRoleVM.getId() != null) {
			return ResponseEntity.badRequest()
	                .headers(HeaderUtil.createFailureAlert(ENTITY_NAME, "idexists", "A new servert cannot already have an ID"))
	                .body(null);
		}else{
			ServertRole servertRole = servertRolesService.saveServertRoles(servertRoleVM);
			return ResponseEntity.created(new URI("/api/users/" + servertRole.getName()))
					.headers(HeaderUtil.createAlert( "entities.created", servertRole.getName()))
					.body(servertRoleVM);
		}
	}
}