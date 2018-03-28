package com.toDo.toDoApp;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ToDoResource {
	
	@Autowired
	private ToDoRepository doRepository;
	
	@GetMapping("/toDos")
	public List<ToDoEntity> retrieveAllToDos(){
		return doRepository.findAll();
	}
	
	@PostMapping("/toDos")
	public ResponseEntity<Object> createTodo(@RequestBody ToDoEntity toDoEntity) {
		ToDoEntity savedtoDoEntity = doRepository.save(toDoEntity);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedtoDoEntity.getId()).toUri();
System.out.println("SSSSSSSSSSSSSSSSSSSSSS "+ savedtoDoEntity.getId());
		return ResponseEntity.created(location).build();

	}
	
	@GetMapping("/toDos/{id}")
	public ToDoEntity retrieveStudent(@PathVariable long id) {
		Optional<ToDoEntity> toDoEntity = doRepository.findById(id);

		//if (!student.isPresent())
			//throw new StudentNotFoundException("id-" + id);
System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA "+id);
		return toDoEntity.get();
	}
	

}
