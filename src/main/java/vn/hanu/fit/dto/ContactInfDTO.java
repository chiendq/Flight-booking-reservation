package vn.hanu.fit.dto;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfDTO extends TicketSearchDTO{
    private Long ticketId;

    private String fullName;

    private boolean gender;

    private String phoneNumber;

    private String email;

    private Date dateOfBirth;

    private String identityNumber;

    private String paymentType;

    private boolean bankTransfer;
    private boolean qrpay;
    private boolean atmBankAccount;
    private boolean visaMasterCard;
    private boolean caretaker;

    private int adultNum;
    private int babyNum;
    private int childNum;

    @Override
    public String toString() {
        return "ContactInfDTO{" +
                "ticketId=" + ticketId +
                ", fullName='" + fullName + '\'' +
                ", gender=" + gender +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", identityNumber='" + identityNumber + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", bankTransfer=" + bankTransfer +
                ", qrpay=" + qrpay +
                ", atmBankAccount=" + atmBankAccount +
                ", visaMasterCard=" + visaMasterCard +
                ", caretaker=" + caretaker +
                ", adultNum=" + adultNum +
                ", babyNum=" + babyNum +
                ", childNum=" + childNum +
                '}';
    }
}
