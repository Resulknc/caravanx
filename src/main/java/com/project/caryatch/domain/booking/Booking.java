package com.project.caryatch.domain.booking;

import com.project.caryatch.domain.advertisement.Advertisement;
import com.project.caryatch.domain.payment.Payment;
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
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "advertisement_id", referencedColumnName = "id", nullable = false)
    private Advertisement advertisementId;

    @OneToOne
    @JoinColumn(name = "payment_id", referencedColumnName = "id", nullable = false)
    private Payment paymentId;

    @Column(name = "booking_start_date")
    private Date bookingStartDate;

    @Column(name = "booking_end_date")
    private Date bookingEndDate;

    @Column(name = "total_cost")
    private String totalCost;

    @Column(name = "status")
    private String status;

    @Column(name = "notes")
    private String notes;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;
}
