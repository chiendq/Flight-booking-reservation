package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
