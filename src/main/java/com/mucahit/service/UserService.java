package com.mucahit.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mucahit.dao.UserDAO;
import com.mucahit.entity.User;

//Persistence Layer

@Service
@Transactional
public class UserService {

	@Autowired
	private MailService mailService;

	@Autowired
	private UserDAO userDAO;

	public Long insert(User user) {
		String uuid = UUID.randomUUID().toString();
		user.setKeyreg(uuid);

		if (userDAO.insert(user) > 0) {
			mailService.registerMail(user.getEmail(), user.getKeyreg());
		}
		return 1l;

	}

	public void update(User user) {

		userDAO.update(user);

	}

	// READ
	public User getFindUsernameAndPass(User user) {

		return userDAO.getfindUsernameAndPass(user.getUsername(), user.getPassword());
	}

	public User getfindUsername(String username) {

		return userDAO.getfindUsername(username);
	}

	public boolean getFindByKey(String key) {
		User user = userDAO.getFindByKey(key);

		if (user != null) {
			user.setActive(true);
			update(user);
			return true;
		} else
			return false;

	}

}
