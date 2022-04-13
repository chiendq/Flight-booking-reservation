package vn.hanu.fit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.hanu.fit.dto.ContactInfDTO;
import vn.hanu.fit.dto.TicketSearchDTO;
import vn.hanu.fit.entity.*;
import vn.hanu.fit.repository.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingController.class);

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    BookingRepository bookingRepository;

    List<FlightClass> flightClassList;

    @Autowired
    public void setFlightClasss(FlightClassRepository flightClassRepository) {
        this.flightClassList = flightClassRepository.findAll();
    }


    @Autowired
    AirportRepository airportRepository;

    @RequestMapping("/seat")
    public String seat(Model model) {
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        model.addAttribute("flightClass", flightClassList);
        return "seat";
    }

    @RequestMapping("/booking")
    public String book(Model model) {
        model.addAttribute("airports", airportRepository.findAll());
        model.addAttribute("ticketSearchDTO", new TicketSearchDTO());
        model.addAttribute("flightClass", flightClassList);
        return "booking";
    }

    @RequestMapping("/search")
    public String search(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO, Model model) {
        model.addAttribute("airports", airportRepository.findAll());
        String from = ticketSearchDTO.getDepartureAirportCode();
        String to = ticketSearchDTO.getArrivalAirportCode();
        String code = "";
        List<Ticket> tickets = new ArrayList<>();
        if (ticketSearchDTO.isEconomyClass()) {
            code = flightClassList.get(0).getCode();
            tickets.addAll(ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Code(from, to, code));
        }
         if (ticketSearchDTO.isSpecialEconomyClass()) {
             code = flightClassList.get(1).getCode();
             tickets.addAll(ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Code(from, to, code));
         }
         if (ticketSearchDTO.isBusinessClass()) {
             code = flightClassList.get(2).getCode();
             tickets.addAll(ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Code(from, to, code));
         }
         if (ticketSearchDTO.isFirstClass()) {
             code = flightClassList.get(3).getCode();
             tickets.addAll(ticketRepository.findAllByDepartureAirport_CodeAndArrivalAirport_CodeAndFlightClass_Code(from, to, code));
         }

        LOGGER.info(String.valueOf(tickets));
        model.addAttribute("tickets", tickets);
        return "searchTicket";
    }

    @RequestMapping("/booking/{id}")
    public String booking(@ModelAttribute("ticketSearchDTO") TicketSearchDTO ticketSearchDTO,
                          @PathVariable("id") Long id,
                          Model model) {
        ContactInfDTO contactInfDTO = new ContactInfDTO();
        contactInfDTO.setTicketId(id);
//        Ticket ticket = ticketRepository.getById(id);
        contactInfDTO.setTicketId(id);
        mappingTicketSearchDTOToContactInfDTO(ticketSearchDTO, contactInfDTO);
        contactInfDTO.setAdultNum(ticketSearchDTO.getAdultPassengerNumber());
        contactInfDTO.setChildNum(ticketSearchDTO.getChildPassengerNumber());
        contactInfDTO.setBabyNum(ticketSearchDTO.getBabyPassengerNumber());
        LOGGER.info("/booking/" + id + " : " + contactInfDTO);
        model.addAttribute("contactInfDTO", contactInfDTO);

        return "payment";
    }

    @RequestMapping("/booking/paymentMethods")
    public String showPaymentMethod(@ModelAttribute("contactInfDTO") ContactInfDTO contactInfDTO,
                                    Model model) {
        LOGGER.info("/booking/paymentMethods " + contactInfDTO.toString());
        model.addAttribute("contactInfDTO", contactInfDTO);
        return "payment_methods";
    }

    @RequestMapping("/booking/paymentType")
    public String showPaymentType(@ModelAttribute("contactInfDTO") ContactInfDTO contactInfDTO,
                                  Model model) {
        if (contactInfDTO.isBankTransfer()) {
            contactInfDTO.setPaymentType("Bank Transfer");
        } else if (contactInfDTO.isQrpay()) {
            contactInfDTO.setPaymentType("QR-PAY");
        } else if (contactInfDTO.isAtmBankAccount()) {
            contactInfDTO.setPaymentType("ATM/Bank account");
        } else if (contactInfDTO.isVisaMasterCard()) {
            contactInfDTO.setPaymentType("Visa/Master card");
        }
        contactInfDTO.setPaymentType("Caretaker");
        model.addAttribute("contactInfDTO", contactInfDTO);
        LOGGER.info("paymenttype : " + contactInfDTO);
        return "booking_success";
    }

    @RequestMapping("/booking/success")
    public String bookingSuccess(@ModelAttribute("contactInfDTO") ContactInfDTO contactInfDTO,
                                 Model model) {
        LOGGER.info("Booking success : " + contactInfDTO.toString());

        Long ticketId = contactInfDTO.getTicketId();
        Passenger passenger = new Passenger(
                contactInfDTO.getFullName(),
                contactInfDTO.getPhoneNumber(),
                contactInfDTO.getEmail(),
                contactInfDTO.getDateOfBirth(),
                contactInfDTO.getIdentityNumber(),
                contactInfDTO.isGender()
        );
        int adultNum = contactInfDTO.getAdultNum();
        int babyNum = contactInfDTO.getBabyNum();
        int childNum = contactInfDTO.getChildNum();
        String paymentType = "";
        if (contactInfDTO.isBankTransfer()) {
            paymentType = "Bank transfer";
        } else if (contactInfDTO.isQrpay()) {
            paymentType = "QR-Pay";
        } else if (contactInfDTO.isAtmBankAccount()) {
            paymentType = "ATM/Bank Account";
        } else if (contactInfDTO.isVisaMasterCard()) {
            paymentType = "Visa/Master card";
        } else {
            paymentType = "Caretaker";
        }
        Timestamp currentTime = new Timestamp(new Date().getTime());
        Payment payment = new Payment(
                "Pending",
                currentTime,
                paymentType,
                adultNum,
                childNum,
                babyNum,
                0);
        passengerRepository.save(passenger);
        paymentRepository.save(payment);

        String bookingCode = String.valueOf(currentTime).replace('-','1').replace(' ','2').replace(':','3').replace('.','4');
        Booking booking = new Booking(
                passenger,
                payment,
                ticketRepository.getById(ticketId),
                bookingCode,
                "Pending",currentTime );
        bookingRepository.save(booking);
        model.addAttribute("contactInfDTO", contactInfDTO);
        model.addAttribute("bookingCode",bookingCode);
        model.addAttribute("ticket", ticketRepository.findById(contactInfDTO.getTicketId()).get());
        return "booking_success";
    }

    private void mappingTicketSearchDTOToContactInfDTO(TicketSearchDTO ticketSearchDTO, ContactInfDTO contactInfDTO) {
        contactInfDTO.setDepartureAirportCode(ticketSearchDTO.getDepartureAirportCode());
        contactInfDTO.setArrivalAirportCode(ticketSearchDTO.getArrivalAirportCode());
        contactInfDTO.setDepartureTime(ticketSearchDTO.getDepartureTime());
        contactInfDTO.setAdultPassengerNumber(ticketSearchDTO.getAdultPassengerNumber());
        contactInfDTO.setChildPassengerNumber(ticketSearchDTO.getChildPassengerNumber());
        contactInfDTO.setBabyPassengerNumber(ticketSearchDTO.getBabyPassengerNumber());
        contactInfDTO.setEconomyClass(ticketSearchDTO.isEconomyClass());
        contactInfDTO.setSpecialEconomyClass(ticketSearchDTO.isSpecialEconomyClass());
        contactInfDTO.setBusinessClass(ticketSearchDTO.isBusinessClass());
        contactInfDTO.setFirstClass(ticketSearchDTO.isFirstClass());
    }
}
