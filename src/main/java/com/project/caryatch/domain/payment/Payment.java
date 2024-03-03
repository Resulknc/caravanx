package com.project.caryatch.domain.payment;

import com.project.caryatch.domain.booking.Booking;
import com.project.caryatch.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @ManyToOne
    @JoinColumn(name = "booking_id", referencedColumnName = "id", nullable = false)
    private Booking booking_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user_id;

    @Column(name = "content")
    private long amount;

    @Column(name = "payment_method")
    private String payment_method;

    @Column(name = "transaction_status")
    private String transaction_status;

    @Column(name = "timestamp")
    private Date timestamp;
}
