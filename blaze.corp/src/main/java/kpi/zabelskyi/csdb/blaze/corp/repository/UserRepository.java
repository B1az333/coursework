package kpi.zabelskyi.csdb.blaze.corp.repository;


import kpi.zabelskyi.csdb.blaze.corp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
