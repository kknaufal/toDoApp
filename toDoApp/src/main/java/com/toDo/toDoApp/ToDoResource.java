package com.toDo.toDoApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoResource {
	
	@Autowired
	private ToDoRepository doRepository;
	
	@GetMapping("/toDos")
	public List<ToDoEntity> retrieveAllToDos(){
		System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
		return doRepository.findAll();
	}
	

}
