package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
}
