package com.d2derp.oep.service.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.client.ClientRepository;
import com.d2derp.oep.dao.user.UserRepository;
import com.d2derp.oep.entity.Client;
import com.d2derp.oep.entity.User;


@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	ClientRepository clientRepo;

	public UserRepository getUserDao() {
		return userRepository;
	}

	public void setUserDao(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public ClientRepository getClientRepo() {
		return clientRepo;
	}

	public void setClientRepo(ClientRepository clientRepo) {
		this.clientRepo = clientRepo;
	}

	@Override
	public void save(User user) {
		Client data = clientRepo.getOne(1);
		user.setClient(data);
		System.out.println(data.getId());
		userRepository.save(user);
	}


	
}
