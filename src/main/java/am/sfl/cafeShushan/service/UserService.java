package am.sfl.cafeShushan.service;


import am.sfl.cafeShushan.entity.User;

/**
 * Created by Shushi on 1/9/2018.
 */
public interface UserService {
	public User findUserByUsername(String username);
	public void saveUser(User user);
}
