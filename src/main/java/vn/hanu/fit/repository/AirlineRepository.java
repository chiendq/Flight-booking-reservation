package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {

}
