package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.model.ContractProject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ContractProjectService {
    List<ContractProject> contractProjectList();

    ContractProject saveContractProject(ContractProject newContractProject);
    ContractProject getContractProject(@PathVariable long sid);
    String deleteContractProject(ContractProject delContractProject);
    String deleteContractProject(@PathVariable long id);
    String updateContractProject(@PathVariable long sid,  @RequestBody ContractProject contractProject);
}