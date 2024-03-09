package com.project.caryatch.domain.user;

import com.project.caryatch.domain.advertisement.Advertisement;
import com.project.caryatch.domain.booking.Booking;
import com.project.caryatch.domain.message.Message;
import com.project.caryatch.domain.notification.Notification;
import com.project.caryatch.domain.review.Review;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "role")
    private String role;

    @Column(name = "createdAT")
    private Date createdAT;

    @Column(name = "updatedAt")
    private Date updatedAt;

    @OneToMany(mappedBy = "userId")
    private List<Advertisement> advertisements;

    @OneToMany(mappedBy = "userId")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "userId")
    private List<Review> reviews;

    @OneToMany(mappedBy = "senderUserId")
    private List<Message> sentmessages;

    @OneToMany(mappedBy = "recipientUserId")
    private List<Message> receivedmessages;

    @OneToMany(mappedBy = "userId")
    private List<Notification> notifications;
}
