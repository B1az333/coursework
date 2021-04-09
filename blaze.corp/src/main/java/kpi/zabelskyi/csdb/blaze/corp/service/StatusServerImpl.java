package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Status;
import kpi.zabelskyi.csdb.blaze.corp.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class StatusServerImpl implements StatusService{
    private final StatusRepository statusRepository;
    @Autowired
    public StatusServerImpl(StatusRepository statusRepository){
        this.statusRepository=statusRepository;
    }

    @Override
    public List<Status> statusList() { return statusRepository.findAll(); }

    @Override
    public Status saveStatus(Status newStatus) {
        return statusRepository.save(newStatus);
    }

    @Override
    public Status getStatus(long sid) {
        return statusRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteStatus(Status delStatus){
        statusRepository.delete(delStatus);
        return "deleted";
    }

    @Override
    public String deleteStatus(@PathVariable long sid){
        Status s = statusRepository.getOne(sid);
        statusRepository.delete(s);
        return "deleted";
    }



}
