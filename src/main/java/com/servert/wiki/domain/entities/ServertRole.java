package com.servert.wiki.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

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
    @Size(max = 50)
    @Column(name = "name_",length = 50)
    private String name;
    
    @NotNull
    @Column(name = "type_",length = 11)
    private Integer type;
    
    @NotNull
    @Column(name = "atk_",length = 20)
    private Long atk;
    
    @NotNull
    @Column(name = "hp_",length = 20)
    private Long hp;
    
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