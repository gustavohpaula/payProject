package com.payproject.payproject.domain.user.dtos;

import com.payproject.domain.user.dtos.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class UserDTOTests
{

	@Test
	void shouldCreateUser()
	{
		UserDTO user = new UserDTO("first name", "last name", "name@exemple.com", "123456789");

		assertThat(user).isNotNull();
	}

	@Test
	void shouldNotCreateUserWithoutFirstName()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new UserDTO(null, "last name", "name@exemple.com", "123456789"));
		assertEquals("firstName is marked non-null but is null", exception.getMessage());
	}

	@Test
	void shouldNotCreateUserWithoutLastName()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new UserDTO("First Name", null, "name@exemple.com", "123456789"));
		assertEquals("lastName is marked non-null but is null", exception.getMessage());
	}

	@Test
	void shouldNotCreateUserWithoutEmail()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new UserDTO("First Name", "last name", null, "123456789"));
		assertEquals("email is marked non-null but is null", exception.getMessage());
	}

	@Test
	void shouldNotCreateUserWithoutDocument()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new UserDTO("First Name", "last name", "name@exemple.com", null));
		assertEquals("document is marked non-null but is null", exception.getMessage());
	}
}
