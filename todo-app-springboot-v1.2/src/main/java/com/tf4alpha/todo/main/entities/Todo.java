package com.tf4alpha.todo.main.entities;


public class Todo {

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String todoItem;
	private String completed;
	private String shortdescription ;
	private String date;
	private String priority;
	
	public Todo() {
		super();
	}

	public Todo(long id, String todoItem, String completed, String shortdescription, String date, String priority) {
		super();
		this.id = id;
		this.todoItem = todoItem;
		this.completed = completed;
		this.shortdescription = shortdescription;
		this.date = date;
		this.priority = priority;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTodoItem() {
		return todoItem;
	}

	public void setTodoItem(String todoItem) {
		this.todoItem = todoItem;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getShortdescription() {
		return shortdescription;
	}

	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", todoItem=" + todoItem + ", completed=" + completed + ", shortdescription="
				+ shortdescription + ", date=" + date + ", priority=" + priority + ", getId()=" + getId()
				+ ", getTodoItem()=" + getTodoItem() + ", getCompleted()=" + getCompleted() + ", getShortdescription()="
				+ getShortdescription() + ", getDate()=" + getDate() + ", getPriority()=" + getPriority()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}


	
	
}