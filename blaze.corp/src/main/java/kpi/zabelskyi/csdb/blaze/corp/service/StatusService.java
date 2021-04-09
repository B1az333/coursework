package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Status;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface StatusService {
    List<Status> statusList();

    Status saveStatus(Status newStatus);
    Status getStatus(@PathVariable long sid);
    String deleteStatus(Status delStatus);
    String deleteStatus(@PathVariable long id);
}