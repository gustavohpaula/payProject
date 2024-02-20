package com.payproject.domain.user.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO
{
	@NonNull
	private String fullName;
	@NonNull
	private String email;
	@NonNull
	private String document;

}
