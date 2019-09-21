package com.d2derp.oep.controller.user;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.d2derp.oep.entity.User;
import com.d2derp.oep.pojo.UserModel;
import com.d2derp.oep.service.user.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {

		this.userService = userService;
	}

	@PostMapping(value = "/save")
	public void saveUser( @RequestBody UserModel userModel) {	
		
		System.out.println(userModel.getCpass());
		System.out.println(userModel.getClient());
		userService.save(userModel);
	}

	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<Optional<User>> getUser(@PathVariable(value = "id") int id) {
		return ResponseEntity.ok(userService.findById(id)); 

	}

	@GetMapping(value = "/list")
	public ResponseEntity<List<User>> listUser() {
		return ResponseEntity.ok(userService.listUser());
	}

	@PutMapping(value = "/edit")
	public ResponseEntity<User> updateUser(@RequestBody User user) {

		if (!userService.findById(user.getId()).isPresent()) {
            ResponseEntity.badRequest().build();
        }
		System.out.println(user.getMobileNumber());

	        return ResponseEntity.ok(userService.editUser(user));
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity deleteUser(@PathVariable(value ="id") int id) {
        if (!userService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        userService.deleteUser(id);

        return ResponseEntity.ok().build();
 
	}

}
