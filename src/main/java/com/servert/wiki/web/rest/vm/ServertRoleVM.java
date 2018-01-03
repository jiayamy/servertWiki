package com.servert.wiki.web.rest.vm;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.servert.wiki.config.Constants;
import com.servert.wiki.domain.entities.ServertRole;

public class ServertRoleVM implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ServertRoleVM(ServertRole servertRole) {
		this(servertRole.getId(), servertRole.getLogin(), null, servertRole.getType(),servertRole.getServertId(),
				servertRole.getLevel(), servertRole.getSkillOneLevel(),
				servertRole.getSkillTwoLevel(), servertRole.getSkillThreeLevel(), servertRole.getToolLevel(),
				servertRole.getCreatedBy(), servertRole.getCreatedDate(), servertRole.getLastModifiedBy(),
				servertRole.getLastModifiedDate());
	}
	
    public ServertRoleVM() {
		super();
	}

	public ServertRoleVM(Long id, String login, String name, Integer type, Long servertId, Integer level,
			Integer skillOneLevel, Integer skillTwoLevel, Integer skillThreeLevel, Integer toolLevel, String createdBy,
			Instant createdDate, String lastModifiedBy, Instant lastModifiedDate) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.type = type;
		this.servertId = servertId;
		this.level = level;
		this.skillOneLevel = skillOneLevel;
		this.skillTwoLevel = skillTwoLevel;
		this.skillThreeLevel = skillThreeLevel;
		this.toolLevel = toolLevel;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	
	public ServertRoleVM(Long id, String login, String name, Integer type, Long servertId, Integer level, Long atk,
			Long hp, Integer skillOneLevel, Integer skillTwoLevel, Integer skillThreeLevel, Integer toolLevel,
			String createdBy, Instant createdDate, String lastModifiedBy, Instant lastModifiedDate) {
		super();
		this.id = id;
		this.login = login;
		this.name = name;
		this.type = type;
		this.servertId = servertId;
		this.level = level;
		this.atk = atk;
		this.hp = hp;
		this.skillOneLevel = skillOneLevel;
		this.skillTwoLevel = skillTwoLevel;
		this.skillThreeLevel = skillThreeLevel;
		this.toolLevel = toolLevel;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}


	/*
	 * id
	 */
	private Long id;
    
	/*
	 * 登陆账号
	 */
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    private String login;
    
    /*
     * servert name
     */
    @Size(max = 50)
    private String name;
    
    /**
     * servert type
     */
    private Integer type;
    
    private String typeName;
    
    private Long servertId;
    
    private Integer level;
    
    private Long atk;
    
    private Long hp;
    
    private Integer skillOneLevel;
    
    private Integer skillTwoLevel;
    
    private Integer skillThreeLevel;
    
    private Integer toolLevel;
    
    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getServertId() {
		return servertId;
	}

	public void setServertId(Long servertId) {
		this.servertId = servertId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getSkillOneLevel() {
		return skillOneLevel;
	}

	public void setSkillOneLevel(Integer skillOneLevel) {
		this.skillOneLevel = skillOneLevel;
	}

	public Integer getSkillTwoLevel() {
		return skillTwoLevel;
	}

	public void setSkillTwoLevel(Integer skillTwoLevel) {
		this.skillTwoLevel = skillTwoLevel;
	}

	public Integer getSkillThreeLevel() {
		return skillThreeLevel;
	}

	public void setSkillThreeLevel(Integer skillThreeLevel) {
		this.skillThreeLevel = skillThreeLevel;
	}

	public Integer getToolLevel() {
		return toolLevel;
	}

	public void setToolLevel(Integer toolLevel) {
		this.toolLevel = toolLevel;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Instant getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Instant createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Instant getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Instant lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Long getAtk() {
		return atk;
	}

	public void setAtk(Long atk) {
		this.atk = atk;
	}

	public Long getHp() {
		return hp;
	}

	public void setHp(Long hp) {
		this.hp = hp;
	}
    
}
