package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.User;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {
    List<User> userList();
    User getUser(@PathVariable long uid);
    User saveUser(User newUser);
    String deleteUser(@PathVariable long uid);
}