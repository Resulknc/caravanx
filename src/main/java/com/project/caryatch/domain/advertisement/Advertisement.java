package com.project.caryatch.domain.advertisement;


import com.project.caryatch.domain.booking.Booking;
import com.project.caryatch.domain.category.Category;
import com.project.caryatch.domain.location.Location;
import com.project.caryatch.domain.review.Review;
import com.project.caryatch.domain.user.User;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "advertisements")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @ManyToOne
    @JoinColumn(name ="user_id", referencedColumnName = "id", nullable = false)
    private User userId;


    @Column(name = "amenity")
    private long amenity;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name ="location_id", referencedColumnName = "id", nullable = false)
    private Location location;

    @Column(name = "pricePerDay")
    private long pricePerDay;

    @Column(name = "pricePerHour")
    private long pricePerHour;

    @Column(name = "priceType")
    private String priceType;

    @Column(name = "availability_start_date")
    private Date availability_start_date;

    @Column(name = "availability_end_date")
    private Date availability_end_date;

    @Column(name = "CreatedAt")
    private Date CreatedAt;

    @Column(name = "UpdatedAt")
    private Date UpdatedAt;

    @OneToMany(mappedBy = "advertisementId")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "advertisementId")
    private List<Review> reviews;


    @ManyToMany
    @JoinTable(
            name = "advertisement_categories", // Ortak tablo adı
            joinColumns = @JoinColumn(name = "advertisement_id"), // Advertisement tablosundan referans alan sütun adı
            inverseJoinColumns = @JoinColumn(name = "category_id") // Category tablosundan referans alan sütun adı
    )
    private Set<Category> categories;

}
