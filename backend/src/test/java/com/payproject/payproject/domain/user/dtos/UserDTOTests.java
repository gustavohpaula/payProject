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
		UserDTO user = new UserDTO("full name", "name@exemple.com", "123456789");

		assertThat(user).isNotNull();
	}

	@Test
	void shouldNotCreateUserWithoutName()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new UserDTO(null,  "name@exemple.com", "123456789"));
		assertEquals("firstName is marked non-null but is null", exception.getMessage());
	}

	@Test
	void shouldNotCreateUserWithoutEmail()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new UserDTO("Full Name",  null, "123456789"));
		assertEquals("email is marked non-null but is null", exception.getMessage());
	}

	@Test
	void shouldNotCreateUserWithoutDocument()
	{
		Exception exception = assertThrows(NullPointerException.class,
			() -> new UserDTO("Full Name", "name@exemple.com", null));
		assertEquals("document is marked non-null but is null", exception.getMessage());
	}
}
