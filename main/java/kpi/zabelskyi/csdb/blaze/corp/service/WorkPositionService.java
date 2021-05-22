package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.WorkPosition;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface WorkPositionService {
    List<WorkPosition> workPositionList();

    WorkPosition saveWorkPosition(WorkPosition newWorkPosition);
    WorkPosition getWorkPosition(@PathVariable long sid);
    String deleteWorkPosition(WorkPosition delWorkPosition);
    String deleteWorkPosition(@PathVariable long id);
}