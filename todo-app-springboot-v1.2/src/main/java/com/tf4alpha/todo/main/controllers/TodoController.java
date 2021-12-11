package com.tf4alpha.todo.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tf4alpha.todo.main.entities.Todo;
import com.tf4alpha.todo.main.service.TodoService;


@Controller
public class TodoController {

	
	@Autowired
	TodoService todoService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/todos")
	public String todos(Model model) {
		
		model.addAttribute("todos", todoService.findAll());
		
		return "todos";
	}

	@PostMapping("/todoNew")
	public String add(@RequestParam String todoItem, @RequestParam String shortdescription,@RequestParam String status,@RequestParam String priority,@RequestParam String date, Model model) {
		
		Todo todo = new Todo();
		todo.setTodoItem(todoItem);
		todo.setShortdescription(shortdescription);
		todo.setCompleted(status);
		todo.setPriority(priority);
		todo.setDate(date);

		todoService.save(todo);
		
		model.addAttribute("todos", todoService.findAll());
		
		return "redirect:/todos";
	}
	
	@PostMapping("/todoEditSave")
	public String todoEditSave( @ModelAttribute("todo") Todo todo, Model model) {
		
		todoService.update(todo);
		
		model.addAttribute("todos", todoService.findAll());
		
		return "redirect:/todos";
	}
	
	@RequestMapping("/showTodoEdit/{id}")
	public String showFormForTodoUpdate(@PathVariable long id ,Model theModel) {
		Todo todo = todoService.findById(id);

		theModel.addAttribute("todo", todo);

		return "todoedit";
	}

	@PostMapping("/todoDelete/{id}")
	public String delete(@PathVariable long id, Model model) {
		
		todoService.delete(id);
		
		model.addAttribute("todos", todoService.findAll());
		
		return "redirect:/todos";
	}

	@PostMapping("/todoUpdate/{id}")
	public String update(@PathVariable long id, Model model) {
		
		Todo todo = todoService.findById(id);
		
		if ("yes".equals(todo.getCompleted())) {
			todo.setCompleted("no");
		} else {
			todo.setCompleted("yes");
		}
			
		todoService.update(todo);
		
		model.addAttribute("todos", todoService.findAll());
		
		return "redirect:/todos";
	}
}
