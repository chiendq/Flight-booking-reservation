package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
