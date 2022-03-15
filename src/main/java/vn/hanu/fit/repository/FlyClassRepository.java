package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.hanu.fit.entity.FlightClass;

public interface FlyClassRepository extends JpaRepository<FlightClass, Long> {
}
