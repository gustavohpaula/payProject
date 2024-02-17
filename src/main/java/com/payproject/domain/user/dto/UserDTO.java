package com.payproject.domain.user.dto;

import lombok.*;

@Getter
@Setter
public class UserDTO
{
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	private String email;
	@NonNull
	private String document;

	public UserDTO(@NonNull String firstName, @NonNull String lastName, @NonNull String email,
		@NonNull String document)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.document = document;
	}

	public UserDTO()
	{
	}
}
