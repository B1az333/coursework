package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.ProjectStaff;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ProjectStaffService {
    List<ProjectStaff> projectStaffList();

    ProjectStaff saveProjectStaff(ProjectStaff newProjectStaff);
    ProjectStaff getProjectStaff(@PathVariable long sid);
    String deleteProjectStaff(ProjectStaff delProjectStaff);
    String deleteProjectStaff(@PathVariable long id);
}
