package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.UserType;
import kpi.zabelskyi.csdb.blaze.corp.repository.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class UserTypeServiceImpl implements UserTypeService{
    private final UserTypeRepository userTypeRepository;
    @Autowired
    public UserTypeServiceImpl(UserTypeRepository userTypeRepository){
        this.userTypeRepository=userTypeRepository;
    }

    @Override
    public List<UserType> userTypeList() { return userTypeRepository.findAll(); }

    @Override
    public UserType saveUserType(UserType newUserType) {
        return userTypeRepository.save(newUserType);
    }

    @Override
    public UserType getUserType(long sid) {
        return userTypeRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteUserType(UserType delUserType){
        userTypeRepository.delete(delUserType);
        return "deleted";
    }

    @Override
    public String deleteUserType(@PathVariable long sid){
        UserType s = userTypeRepository.getOne(sid);
        userTypeRepository.delete(s);
        return "deleted";
    }



}