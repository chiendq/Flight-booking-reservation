package vn.hanu.fit.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.hanu.fit.entity.Payment;
import vn.hanu.fit.repository.PaymentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepo;

    @GetMapping("")
    public List<Payment> getPaymentList(){
        return paymentRepo.findAll();
    }

    @GetMapping(value = {"/{id}"})
    public Payment getPaymentById(@PathVariable(value = "id") Long id){
        return paymentRepo.findById(id).get();
    }

    @PostMapping("")
    public Payment addPayment(@RequestBody Payment payment){
        return paymentRepo.save(payment);
    }

    @PutMapping(value = "/{id}")
    public void updatePayment(
            @PathVariable(value = "id") Long id,
            @RequestBody Payment payment) {
        if (paymentRepo.existsById(id)) {
            payment.setId(id);
            paymentRepo.save(payment);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletePayment(
            @PathVariable(value = "id") Long id) {
        if (paymentRepo.existsById(id)) {
            Payment payment = paymentRepo.getById(id);
            paymentRepo.delete(payment);
        }
    }

}
