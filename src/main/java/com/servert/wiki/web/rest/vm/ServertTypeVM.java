package com.servert.wiki.web.rest.vm;

import java.io.Serializable;
import java.util.List;

import com.servert.wiki.domain.entities.ServertInfo;
import com.servert.wiki.domain.entities.ServertTypeInfo;

public class ServertTypeVM implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ServertTypeVM(ServertTypeInfo servertTypeInfo, List<ServertInfo> servertInfos){
		this.type = servertTypeInfo.getType();
		this.typeName = servertTypeInfo.getTypeName();
		this.servertInfos = servertInfos;
	}
	
	public ServertTypeVM() {
		super();
	}

	public ServertTypeVM(Integer type, String typeName, List<ServertInfo> servertInfos) {
		super();
		this.type = type;
		this.typeName = typeName;
		this.servertInfos = servertInfos;
	}

	private Integer type;
	
	private String typeName;
	
	private List<ServertInfo> servertInfos;

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

	public List<ServertInfo> getServertInfos() {
		return servertInfos;
	}

	public void setServertInfos(List<ServertInfo> servertInfos) {
		this.servertInfos = servertInfos;
	}
	
}
