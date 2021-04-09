package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.User;
import kpi.zabelskyi.csdb.blaze.corp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;

    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long uid) {
        return userRepository.findById(uid)
                .orElseThrow();
    }

    @Override
    public User saveUser(User newUser) {
        //  if (userRepository.findOne(newUser))
        return userRepository.save(newUser);
    }

    @Override
    public String deleteUser(long uid) {
        userRepository.delete(userRepository.getOne(uid));
        return "User deleted";
    }
}
