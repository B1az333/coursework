package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.model.Project;
import kpi.zabelskyi.csdb.blaze.corp.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;
    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }

    @Override
    public List<Project> projectList() { return projectRepository.findAll(); }

    @Override
    public Project saveProject(Project newProject) {
        return projectRepository.save(newProject);
    }

    @Override
    public Project getProject(long sid) {
        return projectRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteProject(Project delProject){
        projectRepository.delete(delProject);
        return "deleted";
    }

    @Override
    public String deleteProject(@PathVariable long sid){
        Project s = projectRepository.getOne(sid);
        projectRepository.delete(s);
        return "deleted";
    }

    @Override
    public String updateProject(long sid, Project project) {
        projectRepository.getOne(sid).setProjectName(project.getProjectName());//setName(client.getName());
        projectRepository.getOne(sid).setProjectCost(project.getProjectCost());
        projectRepository.getOne(sid).setDescription(project.getDescription());
        projectRepository.save(projectRepository.getOne(sid));
        return "Project updated";
    }
}