package com.toDo.toDoApp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ToDoEntity {
	
	@Id
	@GeneratedValue
	private Long id;
	private String value;
	private boolean completed;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public ToDoEntity(Long id, String value, boolean isCompleted) {
		super();
		this.id = id;
		this.value = value;
		this.completed = isCompleted;
	}
	public ToDoEntity() {
		super();
	}
	
	

}
