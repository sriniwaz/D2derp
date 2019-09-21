package com.d2derp.oep.controller.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.entity.User;
import com.d2derp.oep.service.client.ClientService;

@RestController
public class ClientController {

	@Autowired
	private ClientService clientService;

	

	public ClientService getClientService() {
		return clientService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}



	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public void saveClient(@RequestBody User user) {
		clientService.save(user);
		
	}

}
