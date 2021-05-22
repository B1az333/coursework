package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.UserType;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserTypeService {
    List<UserType> userTypeList();

    UserType saveUserType(UserType newUserType);
    UserType getUserType(@PathVariable long sid);
    String deleteUserType(UserType delUserType);
    String deleteUserType(@PathVariable long id);
}