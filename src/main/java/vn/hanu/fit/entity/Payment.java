package vn.hanu.fit.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table
@Data
@NoArgsConstructor
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private Timestamp transactionDate;

    private String paymentType;

    private int adultNum;

    private int childNum;

    private int babyNum;

    private int amount;

    public Payment(String status, Timestamp transactionDate, String paymentType, int adultNum, int childNum, int babyNum, int amount) {
        this.status = status;
        this.transactionDate = transactionDate;
        this.paymentType = paymentType;
        this.adultNum = adultNum;
        this.childNum = childNum;
        this.babyNum = babyNum;
        this.amount = amount;
    }
}
