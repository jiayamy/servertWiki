package com.servert.wiki.domain.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Table(name = "w_servert_type_info")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "servertTypeInfo")
public class ServertTypeInfo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(name = "type_",length = 11)
	private Integer type;
	
	@NotNull
    @Column(name = "type_name", length = 50)
	private String typeName;

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
	
}
