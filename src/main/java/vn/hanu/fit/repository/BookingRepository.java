package vn.hanu.fit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.hanu.fit.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    Booking getBookingByCode(String code);
}
