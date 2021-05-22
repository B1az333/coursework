package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.ProjectStaff;
import kpi.zabelskyi.csdb.blaze.corp.repository.ProjectStaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ProjectStaffServiceImpl implements ProjectStaffService{
    private final ProjectStaffRepository projectStaffRepository;
    @Autowired
    public ProjectStaffServiceImpl(ProjectStaffRepository projectStaffRepository){
        this.projectStaffRepository=projectStaffRepository;
    }

    @Override
    public List<ProjectStaff> projectStaffList() { return projectStaffRepository.findAll(); }

    @Override
    public ProjectStaff saveProjectStaff(ProjectStaff newProjectStaff) {
        return projectStaffRepository.save(newProjectStaff);
    }

    @Override
    public ProjectStaff getProjectStaff(long sid) {
        return projectStaffRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteProjectStaff(ProjectStaff delProjectStaff){
        projectStaffRepository.delete(delProjectStaff);
        return "deleted";
    }

    @Override
    public String deleteProjectStaff(@PathVariable long sid){
        ProjectStaff s = projectStaffRepository.getOne(sid);
        projectStaffRepository.delete(s);
        return "deleted";
    }



}
