package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
