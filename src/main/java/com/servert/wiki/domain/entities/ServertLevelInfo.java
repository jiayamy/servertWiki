package com.servert.wiki.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import com.servert.wiki.domain.AbstractAuditingEntity;

@Entity
@Table(name = "w_servert_level_info")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "servertLevelInfo")
public class ServertLevelInfo extends AbstractAuditingEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Column(name = "servert_id",length = 20)
	private Long servertId;
	
	@NotNull
    @Column(name = "level_",length = 11)
	private Integer level;
	
	@NotNull
    @Column(name = "atk_",length = 20)
	private Long atk;
	
	@NotNull
    @Column(name = "hp_",length = 20)
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
