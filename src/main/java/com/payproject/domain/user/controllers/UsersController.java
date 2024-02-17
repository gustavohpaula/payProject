package com.payproject.domain.user.controllers;

import com.payproject.domain.user.dtos.UserDTO;
import com.payproject.domain.user.entities.UserEntity;
import com.payproject.domain.user.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController
{

	@Autowired
	private UserService userService;

	@PostMapping("/create")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserDTO userDTO){
		UserEntity user = userService.createUser(userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		List<UserEntity> users = this.userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/getUser")
	public ResponseEntity<UserEntity> getUser(@RequestParam Long id) throws Exception
	{
		UserEntity user = this.userService.findUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<UserEntity> updateUder(@RequestParam Long id, @RequestBody UserDTO userDTO)
		throws Exception
	{
		UserEntity user = this.userService.updateUser(id, userDTO);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> removeUser(@RequestParam Long id) throws Exception
	{
		String returnMessage = this.userService.deleteUser(id);
		return new ResponseEntity<>(returnMessage, HttpStatus.NO_CONTENT);
	}
}
