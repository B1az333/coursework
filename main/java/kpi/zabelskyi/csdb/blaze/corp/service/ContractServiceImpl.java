package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Contract;
import kpi.zabelskyi.csdb.blaze.corp.repository.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ContractServiceImpl implements ContractService{
    private final ContractRepository contractRepository;
    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository){
        this.contractRepository=contractRepository;
    }

    @Override
    public List<Contract> contractList() { return contractRepository.findAll(); }

    @Override
    public Contract saveContract(Contract newContract) {
        return contractRepository.save(newContract);
    }

    @Override
    public Contract getContract(long sid) {
        return contractRepository.findById(sid)
                .orElseThrow();
    }


    @Override
    public  String deleteContract(Contract delContract){
        contractRepository.delete(delContract);
        return "deleted";
    }

    @Override
    public String deleteContract(@PathVariable long sid){
        Contract s = contractRepository.getOne(sid);
        contractRepository.delete(s);
        return "deleted";
    }



}