package com.servert.wiki.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import com.servert.wiki.domain.AbstractAuditingEntity;

@Entity
@Table(name = "w_servert_name")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "servertName")
public class ServertName extends AbstractAuditingEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
    @Column(name = "servert_id",length = 20)
	private Long servertId;
	
	@NotNull
    @Size(max = 20)
    @Column(name = "servert_name",length = 20)
	private String servertName;

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

	public String getServertName() {
		return servertName;
	}

	public void setServertName(String servertName) {
		this.servertName = servertName;
	}
	
}
