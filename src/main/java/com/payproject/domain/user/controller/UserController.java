package com.payproject.domain.user.controller;

import com.payproject.domain.user.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController
{

	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user){
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<String> getAllUsers(){
		return new ResponseEntity<>("teeeee", HttpStatus.ACCEPTED);
	}

	@GetMapping
	public ResponseEntity<String> getUserById(@RequestParam Long id){
		return new ResponseEntity<>("teeeee", HttpStatus.ACCEPTED);
	}

	@PutMapping
	public ResponseEntity<String> updateUder(@RequestParam Long id, @RequestBody UserDTO user){
		return new ResponseEntity<>("teeeee", HttpStatus.ACCEPTED);
	}

	@DeleteMapping
	public ResponseEntity<String> removeUser(@RequestParam Long id){
		return new ResponseEntity<>("teeeee", HttpStatus.ACCEPTED);
	}
}
