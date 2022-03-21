package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.FlightClass;

@Repository
public interface FlightClassRepository extends JpaRepository<FlightClass, Long> {
}
