package com.tf4alpha.todo.main.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tf4alpha.todo.main.entities.Todo;
import com.tf4alpha.todo.main.rowmapper.TodoMapper;

@Repository
@Transactional
public class TodoDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void save(Todo todo) {
		String sql = "INSERT INTO todo (completed, todo_item,shortdescription,date,priority) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sql, todo.getCompleted(),todo.getTodoItem(),todo.getShortdescription(),todo.getDate(),todo.getPriority());
	}

	public void delete(Long id) {
		String sql = "DELETE FROM todo WHERE id = " + id;
		jdbcTemplate.update(sql);
	}
	
	public void update(Todo todo) {
		String sql = "UPDATE todo SET completed = ?, todo_item = ?, shortdescription = ?, date = ?, priority = ? WHERE id = ? ";
		jdbcTemplate.update(sql, todo.getCompleted(), todo.getTodoItem(),todo.getShortdescription(),todo.getDate(),todo.getPriority(), todo.getId());
	}

	public Todo findById(Long id) {
		String sql = "SELECT * FROM todo WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new TodoMapper(), id);
	}

	public List<Todo> findAll() {
		String sql = "SELECT * FROM todo";
		return jdbcTemplate.query(sql, new TodoMapper());
	}

}
