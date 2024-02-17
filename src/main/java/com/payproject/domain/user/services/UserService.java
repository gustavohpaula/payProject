package com.payproject.domain.user.services;

import com.payproject.domain.user.dto.UserDTO;
import com.payproject.domain.user.entities.UserEntity;
import com.payproject.domain.user.repositories.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService
{

	@Autowired
	private UserRepository repository;

	public UserEntity createUser(UserDTO data){
		UserEntity newUser = new UserEntity(data);
		this.saveUser(newUser);
		return newUser;
	}

	public List<UserEntity> getAllUsers(){
		return this.repository.findAll();
	}

	public UserEntity findUserById(Long id) throws Exception
	{
		return this.repository.findUserEntityById(id).orElseThrow(() -> new Exception("Usuário não encontrado"));
	}

	public UserEntity updateUser(Long id, UserDTO data) throws Exception
	{
		UserEntity user = this.findUserById(id);
		user.changeUserData(data);
		this.saveUser(user);
		return user;
	}

	public String deleteUser(Long id) throws Exception
	{
		UserEntity user = this.findUserById(id);
		this.removeUser(user);
		return "Usuário removido com sucesso";
	}

	public void saveUser(UserEntity user){
		this.repository.save(user);
	}

	public void removeUser(UserEntity user){
		this.repository.delete(user);
	}

}
