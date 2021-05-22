package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.model.Project;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProjectService {
    List<Project> projectList();

    Project saveProject(Project newProject);
    Project getProject(@PathVariable long sid);
    String deleteProject(Project delProject);
    String deleteProject(@PathVariable long id);
    String updateProject(@PathVariable long sid,  @RequestBody Project project);
}