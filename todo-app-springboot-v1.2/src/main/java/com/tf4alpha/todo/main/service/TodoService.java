package com.tf4alpha.todo.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tf4alpha.todo.main.dao.TodoDAO;
import com.tf4alpha.todo.main.entities.Todo;

@Service
@Transactional
public class TodoService {
	
	@Autowired
	private TodoDAO tododao;
	
	public List<Todo> findAll() {
		return tododao.findAll();
	}

	public Todo findById(Long id) {
		return tododao.findById(id);
	}
	
	public void save(Todo todo){
		// validate business
		tododao.save(todo);
	}

	public void update(Todo todo){
		// validate business
		tododao.update(todo);
	}
	
	public void delete(Long id){
		// validate business
		tododao.delete(id);
	}

}
