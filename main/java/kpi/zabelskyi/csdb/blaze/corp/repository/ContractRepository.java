package kpi.zabelskyi.csdb.blaze.corp.repository;

import kpi.zabelskyi.csdb.blaze.corp.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {

}