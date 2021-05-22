package kpi.zabelskyi.csdb.blaze.corp.repository;

import kpi.zabelskyi.csdb.blaze.corp.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}