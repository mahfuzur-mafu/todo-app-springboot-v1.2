package com.tf4alpha.todo.main.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.tf4alpha.todo.main.entities.Todo;

public class TodoMapper implements RowMapper<Todo> {

	public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
		Todo todo = new Todo();
		todo.setId(rs.getInt("id"));
		todo.setCompleted(rs.getString("completed"));
		todo.setTodoItem(rs.getString("todo_item"));
		todo.setShortdescription(rs.getString("shortdescription"));
		todo.setDate(rs.getString("date"));
		todo.setPriority(rs.getString("priority"));
		
		return todo;
	}

}
