package am.sfl.cafeShushan.service;

import am.sfl.cafeShushan.entity.User;
import am.sfl.cafeShushan.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * Created by Shushi on 1/9/2018.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRole(user.getRole());
		userRepository.save(user);
	}

}
