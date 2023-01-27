package com.vs.REST;

public class Employees {
	private long id;
	private String name;
	private String domain;

	// constructor
	// getters
	// toString

	public Employees(long id, String name, String domain) {
		super();
		this.id = id;
		this.name = name;
		this.domain = domain;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDomain() {
		return domain;
	}

	@Override
	public String toString() {
		return "Employees [id=" + id + ", name=" + name + ", domain=" + domain + "]";
	}

}
