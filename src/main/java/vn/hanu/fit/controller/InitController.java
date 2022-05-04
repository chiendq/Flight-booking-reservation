package vn.hanu.fit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.hanu.fit.entity.*;
import vn.hanu.fit.repository.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RestController
@RequestMapping("/init")
public class InitController {
    @Autowired
    AirplaneRepository airplaneRepository;

    @Autowired
    AirlineRepository airlineRepository;

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    FlightClassRepository flightClassRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    static List<Airplane> airplaneList = new ArrayList<>();

    static {
        airplaneList.add(new Airplane(1l, "Airbus A320"));
        airplaneList.add(new Airplane(2l, "Airbus A320"));
        airplaneList.add(new Airplane(3l, "Airbus A350"));
        airplaneList.add(new Airplane(4l, "Boeing 787"));
        airplaneList.add(new Airplane(5l, "VN262"));
        airplaneList.add(new Airplane(6l, "VN260"));
        airplaneList.add(new Airplane(7l, "VN321"));
        airplaneList.add(new Airplane(8l, "QH280"));
    }

    @GetMapping("/airplanes")
    public void initAirplanes() {
        if (airplaneRepository.findAll().size() > 0) {
            log.info("NOT NEED INIT");
            return;
        }
        for (Airplane a : airplaneList
        ) {
            airplaneRepository.save(a);
        }
        log.info("initialized AIR PLANES");
    }

    @GetMapping("/airlines")
    public void initAirlines() {
        if (airlineRepository.findAll().size() > 0) {
            log.info("NOT NEED INIT");
            return;
        }
        List<Airline> airlines = new ArrayList<>();

        airlines.add(new Airline(1l, "Vietjet Air", airplaneList.subList(0, 1), "https://storage.googleapis.com/tripi-flights/agenticons/Vietjet_Air_logo_transparent.png"));
        airlines.add(new Airline(2l, "Vietname Arilines", airplaneList.subList(2, 3), "https://storage.googleapis.com/tripi-flights/agenticons/VietnamAirlines_logo_transparent.png"));
        airlines.add(new Airline(3l, "Bamboo Airway", airplaneList.subList(4, 5), "https://storage.googleapis.com/tripi-flights/agenticons/bamboo_airway.png', 'Bamboo Airway"));
        airlines.add(new Airline(4l, "Pacific Airlines", airplaneList.subList(6, 7), "https://storage.googleapis.com/tripi-flights/agenticons/Pacific%20Airlines.png"));

        airlines.forEach(airline -> {
            airlineRepository.save(airline);
        });
        log.info("INITIALIZED airlines");
    }

    @GetMapping("/airports")
    public void initAirports() {
        if (airportRepository.findAll().size() > 0) {
            log.info("NOT NEED INIT");
            return;
        }
        List<Airport> airports = new ArrayList<>();
        airports.add(new Airport(1l, "HAN", "Sân bay Nội Bài", "Hà Nội"));
        airports.add(new Airport(2l, "SGN", "Sân bay Tân Sơn Nhất", "Sài Gòn"));
        airports.add(new Airport(3l, "DAD", "Sân bay Quốc Tế Đà Nẵng", "Đà Nẵng"));
        airports.add(new Airport(4l, "CXR", "Sân bay Cam Ranh", "Nha Trang"));
        airports.add(new Airport(5l, "PQC", "Sân bay Quốc tế Phú Quốc", "Phú Quốc"));
        airports.add(new Airport(6l, "HUI", "Sân bay Quốc tế Phú Bài", "Huế"));
        airports.add(new Airport(7l, "HPH", "Sân bay Quốc Tế Cát Bi", "Hải Phòng"));
        airports.forEach(airport -> {
            airportRepository.save(airport);
        });
        log.info("INITIALIZED airports");
    }

    @GetMapping("/flightclasses")
    public void initFlightClasses() {
        if (flightClassRepository.findAll().size() > 0) {
            log.info("NOT NEED INIT");
            return;
        }
        List<FlightClass> flightClasses = new ArrayList<>();
        flightClasses.add(new FlightClass(1l, "ECL", "Economy Class", "Bay tiết kiệm, đáp ứng mọi nhu cầu cơ bản."));
        flightClasses.add(new FlightClass(2l, "SEC", "Special Economy Class", "Chi phí hợp lý với bữa ăn ngon và chỗ để chân rộng rãi."));
        flightClasses.add(new FlightClass(3l, "BCL", "Business Class", "Bay đẳng cấp, với quầy làm thủ tục và khu ghế ngồi riêng."));
        flightClasses.add(new FlightClass(4l, "FCL", "First Class", "Bay vippro, mọi thứ thuộc về bạn."));

        flightClasses.forEach(flightClass -> {
            flightClassRepository.save(flightClass);
        });
        log.info("INITIALIZED flightClasses");
    }

    @GetMapping("/tickets")
    public void initTickets() {
        for (int i = 0; i < 1000; i++) {
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            Ticket ticket = new Ticket();
            long airlineId = rand.nextInt(1, 4);
            long departureAirportId = rand.nextInt(1, 8);
            long arrivalAirportId = rand.nextInt(1, 8);
            long flightClassId = rand.nextInt(1, 5);
            long airplaneId = rand.nextInt(1, 8);
            int departureDate = rand.nextInt(1, 30);
            int arrivalDate = rand.nextInt(1, 30);
            if (departureDate > arrivalDate) {
                int temp = departureDate;
                departureDate = arrivalDate;
                arrivalDate = temp;
            }
            int hourDepature = rand.nextInt(1, 24);
            int hourArrival = rand.nextInt(1, 24);
            int cost = rand.nextInt(100, 999);
            int estimatedTime = rand.nextInt(1, 10);
            int handLuggage = rand.nextInt(1, 10);
            int registeredLuggage = rand.nextInt(1, 10);
            int serviceCharge = rand.nextInt(10, 50);
            int taxes = rand.nextInt(10, 50);
            int fees = rand.nextInt(10, 50);

            ticketRepository.save(new Ticket(
                    airlineRepository.getById(airlineId),
                    airportRepository.getById(departureAirportId),
                    airportRepository.getById(arrivalAirportId),
                    flightClassRepository.getById(flightClassId),
                    airplaneRepository.getById(airlineId),
                    new Timestamp(122, 04, departureDate, hourDepature, 0, 0, 0),
                    new Timestamp(122, 04, arrivalDate, hourArrival, 0, 0, 0),
                    cost,
                    estimatedTime,
                    handLuggage,
                    registeredLuggage,
                    serviceCharge,
                    taxes,
                    fees,
                    true));
        }
        log.info("Initialized 1000 random ticket");
    }

    @GetMapping("/roles")
    public void initRoles() {
        if (roleRepository.findAll().size() > 0) {
            log.info("NOT NEED INIT");
            return;
        }
        roleRepository.save(new Role(1, "", "USER"));
        roleRepository.save(new Role(1, "", "ADMIN"));
        log.info("INITIALIZED ROLES");
    }

    @GetMapping("/admin")
    public void initAdmin() {
        Role adminRole = roleRepository.getById(2);
        User admin = new User(
                adminRole,
                "ADMIN VIP PRO",
                "admin",
                "$2a$10$G9xgysnAa5Y6Mj9jWRfsa.iKXEchPGKbkeWGqBT0yR2jBxUcdOV6G",
                "0123456789",
                true,
                null,
                "admin@gmail.com",
                true,
                true,
                "0123456789"
        );
        log.info("INITIALIZED ADMIN");

    }

    @GetMapping("")
    public String initAll(){
        initAirplanes();
        initAirlines();
        initAirports();
        initFlightClasses();
        initTickets();
        initRoles();
        initAdmin();
        return "INITIALIZED DATA";
    }

}
