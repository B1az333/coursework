package kpi.zabelskyi.csdb.blaze.corp.repository;

import kpi.zabelskyi.csdb.blaze.corp.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

}