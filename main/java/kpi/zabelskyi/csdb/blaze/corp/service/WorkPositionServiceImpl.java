package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.WorkPosition;
import kpi.zabelskyi.csdb.blaze.corp.repository.WorkPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class WorkPositionServiceImpl implements WorkPositionService{
    private final WorkPositionRepository workPositionRepository;
    @Autowired
    public WorkPositionServiceImpl(WorkPositionRepository workPositionRepository){
        this.workPositionRepository=workPositionRepository;
    }

    @Override
    public List<WorkPosition> workPositionList() { return workPositionRepository.findAll(); }

    @Override
    public WorkPosition saveWorkPosition(WorkPosition newWorkPosition) {
        return workPositionRepository.save(newWorkPosition);
    }

    @Override
    public WorkPosition getWorkPosition(long sid) {
        return workPositionRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteWorkPosition(WorkPosition delWorkPosition){
        workPositionRepository.delete(delWorkPosition);
        return "deleted";
    }

    @Override
    public String deleteWorkPosition(@PathVariable long sid){
        WorkPosition s = workPositionRepository.getOne(sid);
        workPositionRepository.delete(s);
        return "deleted";
    }



}
