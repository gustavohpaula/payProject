package com.payproject.domain.user.entities;

import com.payproject.domain.user.dtos.UserDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class UserEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fullName;
	@Column(unique = true)
	private String email;
	@Column(unique = true)
	private String document;

	public UserEntity(UserDTO user){
		this.fullName = user.getFullName();
		this.email = user.getEmail();
		this.document = user.getDocument();
	}

	public void changeUserData(UserDTO user){
		this.fullName = user.getFullName();
		this.email = user.getEmail();
		this.document = user.getDocument();
	}
}
