package maldace.daos;

import maldace.controllers.users.User;
import maldace.models.UserModel;

public interface UserDao {
	
	UserModel findByUserName(String username);
	
	void insert(User user);
	boolean checkExistEmail(String email);
	boolean checkExistUsername(String username);
	boolean checkExistPhone(String phone);

	

}
