package kpi.zabelskyi.csdb.blaze.corp.repository;

import kpi.zabelskyi.csdb.blaze.corp.model.WorkPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPositionRepository extends JpaRepository<WorkPosition, Long> {

}