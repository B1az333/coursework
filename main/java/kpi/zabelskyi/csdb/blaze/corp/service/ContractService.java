package kpi.zabelskyi.csdb.blaze.corp.service;

import kpi.zabelskyi.csdb.blaze.corp.model.Contract;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ContractService {
    List<Contract> contractList();

    Contract saveContract(Contract newContract);
    Contract getContract(@PathVariable long sid);
    String deleteContract(Contract delContract);
    String deleteContract(@PathVariable long id);
}