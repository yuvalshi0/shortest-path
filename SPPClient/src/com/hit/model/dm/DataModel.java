package com.hit.model.dm;

import java.util.UUID;

public class DataModel<T> {
	public final UUID id;
	private T body;
	public final String name;
	
	public DataModel( UUID id,T body, String name) {
		this.id = id;
		this.body = body;
		this.name = name;
	}
	
	public T getBody() {
		return body;
	}
	
	 @Override
	 public String toString() {
	       return name;
	    }
}
