package com.canyard.sessions.data;

public class Person {
	private String name;
	private String title;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Person(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}
	
	
}
