package com.payproject.domain.user.repositories;

import com.payproject.domain.user.entities.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long>
{
	Optional<UserEntity> findUserEntityById(Long id);
}
