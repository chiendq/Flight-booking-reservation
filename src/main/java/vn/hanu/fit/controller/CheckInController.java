package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.hanu.fit.entity.Booking;
import vn.hanu.fit.repository.BookingRepository;

@Controller
public class CheckInController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CheckInController.class);

    @Autowired
    BookingRepository bookingRepository;

    @RequestMapping("/checkinpage")
    public String showCheckin(){
        return "checkin";
    }

    @RequestMapping("/checkin{code}")
    public String getCheckin(@RequestParam(name = "code") String code,
                              Model model) {
        if(code == null){
            return "checkin";
        }
        Booking booking = bookingRepository.getBookingByCode(code);
        LOGGER.info("checkin : " + String.valueOf(booking));
        if(booking == null){
            model.addAttribute("exist", false);
            return "checkin";
        }
        model.addAttribute("booking", booking);
        model.addAttribute("exist", true);
        model.addAttribute("passenger", booking.getPassenger());
        model.addAttribute("payment", booking.getPayment());
        model.addAttribute("ticket", booking.getTicket());

        return "checkin";
    }
}
