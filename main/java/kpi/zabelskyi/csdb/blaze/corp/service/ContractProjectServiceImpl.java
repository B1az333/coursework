package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Client;
import kpi.zabelskyi.csdb.blaze.corp.model.ContractProject;
import kpi.zabelskyi.csdb.blaze.corp.repository.ContractProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ContractProjectServiceImpl implements ContractProjectService{
    private final ContractProjectRepository contractProjectRepository;
    @Autowired
    public ContractProjectServiceImpl(ContractProjectRepository contractProjectRepository){
        this.contractProjectRepository=contractProjectRepository;
    }

    @Override
    public List<ContractProject> contractProjectList() { return contractProjectRepository.findAll(); }

    @Override
    public ContractProject saveContractProject(ContractProject newContractProject) {
        return contractProjectRepository.save(newContractProject);
    }

    @Override
    public ContractProject getContractProject(long sid) {
        return contractProjectRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteContractProject(ContractProject delContractProject){
        contractProjectRepository.delete(delContractProject);
        return "deleted";
    }

    @Override
    public String deleteContractProject(@PathVariable long sid){
        ContractProject s = contractProjectRepository.getOne(sid);
        contractProjectRepository.delete(s);
        return "deleted";
    }

    @Override
    public String updateContractProject(long sid, ContractProject contractProject) {
        contractProjectRepository.getOne(sid).setIdProject(contractProject.getIdProject());
        contractProjectRepository.getOne(sid).setIdContract(contractProject.getIdContract());
        contractProjectRepository.getOne(sid).setIdStatusProject(contractProject.getIdStatusProject());

        contractProjectRepository.save(contractProjectRepository.getOne(sid));
        return "Client updated";

    }

}
