package com.payproject.domain.order.services;

import com.payproject.domain.order.dto.ItemDTO;
import com.payproject.domain.order.dto.OrderDTO;
import com.payproject.domain.order.entities.ItemEntity;
import com.payproject.domain.order.entities.OrderEntity;
import com.payproject.domain.order.repositories.ItemRepository;
import com.payproject.domain.user.entities.UserEntity;
import com.payproject.domain.user.services.UserService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService
{
	private final UserService userService;

	@Autowired
	ItemRepository repository;

	@Autowired
	public ItemService(UserService userService)
	{
		this.userService = userService;
	}

	public List<ItemEntity> createItems(List<ItemDTO> data) throws Exception
	{
		return data.stream().map(itemDTO -> {
			try
			{
				UserEntity user = Optional.ofNullable(userService.findUserById(itemDTO.getUserId()))
					.orElseThrow();
				ItemEntity newItem = new ItemEntity(itemDTO, user);
				this.saveItem(newItem);
				return newItem;
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}

		}).collect(Collectors.toList());
	}

	public void saveItem(ItemEntity item)
	{
		this.repository.save(item);
	}
}
