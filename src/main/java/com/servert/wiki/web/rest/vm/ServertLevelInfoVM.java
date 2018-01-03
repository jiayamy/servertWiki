package com.servert.wiki.web.rest.vm;

import java.io.Serializable;

import com.servert.wiki.domain.entities.ServertLevelInfo;

public class ServertLevelInfoVM implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ServertLevelInfoVM(ServertLevelInfo servertLevelInfo){
		this(servertLevelInfo.getId(), servertLevelInfo.getServertId(), servertLevelInfo.getLevel(), servertLevelInfo.getAtk(), servertLevelInfo.getHp());
	}
	
	public ServertLevelInfoVM() {
		super();
	}

	public ServertLevelInfoVM(Long id, Long servertId, Integer level, Long atk, Long hp) {
		super();
		this.id = id;
		this.servertId = servertId;
		this.level = level;
		this.atk = atk;
		this.hp = hp;
	}

	private Long id;
	
	private Long servertId;
	
	private Integer level;
	
	private Long atk;
	
	private Long hp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
