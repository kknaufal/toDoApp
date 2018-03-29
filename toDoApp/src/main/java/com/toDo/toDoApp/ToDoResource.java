package com.toDo.toDoApp;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ToDoResource {

	@Autowired
	private ToDoRepository doRepository;

	@GetMapping("/toDos")
	public List<ToDoEntity> retrieveAllToDos() {
		return doRepository.findAll();
	}

	@PostMapping("/toDos")
	public ResponseEntity<Object> createTodo(@RequestBody ToDoEntity toDoEntity) {
		ToDoEntity savedtoDoEntity = doRepository.save(toDoEntity);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedtoDoEntity.getId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping("/toDos/{id}")
	public ToDoEntity retrieveTodo(@PathVariable long id) throws Exception {
		Optional<ToDoEntity> toDoEntity = doRepository.findById(id);

		 if (!toDoEntity.isPresent())
			 throw new Exception("id-" + id);
		return toDoEntity.get();
	}
	
	@DeleteMapping("/toDos/{id}")
	public void deleteToDo(@PathVariable long id) {
		doRepository.deleteById(id);
	}
	
	@PutMapping("/toDos/{id}")
	public ResponseEntity<Object> updateToDo(@RequestBody ToDoEntity toDoEntity, @PathVariable long id) {

		Optional<ToDoEntity> toDoOptional = doRepository.findById(id);

		if (!toDoOptional.isPresent())
			return ResponseEntity.notFound().build();

		toDoEntity.setId(id);
		doRepository.save(toDoEntity);

		return ResponseEntity.noContent().build();
	}

}
