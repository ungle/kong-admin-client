package io.github.ungle.kong.client.model;

public class IdNameRelation {
	private String id;
	private String name;

	public IdNameRelation() {
	}

	public IdNameRelation(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
