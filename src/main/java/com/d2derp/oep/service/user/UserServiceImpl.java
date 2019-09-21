package com.d2derp.oep.service.user;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.d2derp.oep.dao.client.ClientRepository;
import com.d2derp.oep.dao.user.UserRepository;
import com.d2derp.oep.dao.user.UserTypeRepository;
import com.d2derp.oep.entity.Client;
import com.d2derp.oep.entity.User;
import com.d2derp.oep.entity.UserType;
import com.d2derp.oep.pojo.UserModel;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserTypeRepository userTypeRepository;

	@Autowired
	private ClientRepository clientRepo;

	public UserTypeRepository getUserTypeDao() {
		return userTypeRepository;
	}

	public void setUserTypeDao(UserTypeRepository userTypeRepository) {
		this.userTypeRepository = userTypeRepository;
	}

	public UserRepository getUserDao() {
		return userRepository;
	}

	public void setUserDao(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(UserModel userModel) {

		User user = new User();
		Client client = null;
		UserType userType = null;

		if (userModel.getcId() == 0) {
			userModel.setcId(1);
			client = clientRepo.getOne(1);

		} else {
			client = clientRepo.getOne(userModel.getcId());

		}
		if (userModel.getUserTypeId() == 0) {
			userModel.setUserTypeId(1);
			userType = userTypeRepository.getOne(1);
		}
		else {
			userType = userTypeRepository.getOne(userModel.getUserTypeId());

		}


		user.setCpass(userModel.getCpass());
		user.setCreatedDate(userModel.getCreatedDate());
		user.setEmail(userModel.getEmail());
		user.setFirstName(userModel.getFirstName());
		user.setId(userModel.getId());
		user.setIpAddress(userModel.getIpAddress());
		user.setLastModifiedDate(userModel.getLastModifiedDate());
		user.setLastName(userModel.getLastName());
		user.setMobileNumber(userModel.getMobileNumber());
		user.setPass(userModel.getPass());
		user.setSno(userModel.getSno());
		user.setStatus(userModel.getStatus());

//		userType.setId(dataModel.getId());
//		userType.setUserType(dataModel.getUserType());
		System.out.println(user.getCpass());

		user.setUserType(userType);
		user.setClient(client);
		userRepository.save(user);

	}

	public List<User> listUser() {
		return userRepository.findAll();
	}

	public Optional<User> findById(int id) {

		return userRepository.findById(id);
	}

	@Override
	public void deleteUser(int id) {

		userRepository.deleteById(id);

	}

	public User editUser( User userPojo) {
		// TODO Auto-generated method stub
//		UserType data = userTypeRepository.getOne(id);
//		
//		System.out.println(user.getMobileNumber());
//
//		userTypeRepository.save(data);
		Optional<User> user=userRepository.findById(userPojo.getId());
		user.get().setFirstName(userPojo.getFirstName());
		
		return user.get();
	}

}
