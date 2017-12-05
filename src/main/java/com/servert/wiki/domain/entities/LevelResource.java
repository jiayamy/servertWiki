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
@Table(name = "w_level_resource")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "levelResouce")
public class LevelResource extends AbstractAuditingEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Column(name = "servert_id",length = 20)
	private Long servertId;
	
	@NotNull
    @Column(name = "level_from",length = 11)
	private Integer levelFrom;
	
	@NotNull
    @Column(name = "level_to",length = 11)
	private Integer levelTo;
	
	@Column(name = "resource_id_1",length = 20)
	private Long resourceIdOne;
	
	@Column(name = "resource_id_2",length = 20)
	private Long resourceIdTwo;
	
	@NotNull
	@Column(name = "qb_",length = 20)
	private Long qb;

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

	public Integer getLevelFrom() {
		return levelFrom;
	}

	public void setLevelFrom(Integer levelFrom) {
		this.levelFrom = levelFrom;
	}

	public Integer getLevelTo() {
		return levelTo;
	}

	public void setLevelTo(Integer levelTo) {
		this.levelTo = levelTo;
	}

	public Long getResourceIdOne() {
		return resourceIdOne;
	}

	public void setResourceIdOne(Long resourceIdOne) {
		this.resourceIdOne = resourceIdOne;
	}

	public Long getResourceIdTwo() {
		return resourceIdTwo;
	}

	public void setResourceIdTwo(Long resourceIdTwo) {
		this.resourceIdTwo = resourceIdTwo;
	}

	public Long getQb() {
		return qb;
	}

	public void setQb(Long qb) {
		this.qb = qb;
	}
	
}
