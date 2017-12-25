package com.servert.wiki.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.servert.wiki.config.Constants;
import com.servert.wiki.domain.AbstractAuditingEntity;

@Entity
@Table(name = "w_servert_role")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "servertRole")
public class ServertRole extends AbstractAuditingEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 1, max = 50)
    @Column(name = "login_", length = 50, unique = true, nullable = false)
    private String login;
    
    
    @NotNull
    @Column(name = "servert_id", length = 20)
    private Long servertId;
    
    
    @NotNull
    @Column(name = "type_",length = 11)
    private Integer type;
    
    @NotNull
    @Column(name = "level_",length = 11)
    private Integer level;
    
    @NotNull
    @Column(name = "skill_1_level",length = 11)
    private Integer skillOneLevel;
    
    @NotNull
    @Column(name = "skill_2_level",length = 11)
    private Integer skillTwoLevel;
    
    @NotNull
    @Column(name = "skill_3_level",length = 11)
    private Integer skillThreeLevel;
    
    @NotNull
    @Column(name = "tool_level",length = 11)
    private Integer toolLevel;

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

	public Long getServertId() {
		return servertId;
	}

	public void setServertId(Long servertId) {
		this.servertId = servertId;
	}


	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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
    
}
