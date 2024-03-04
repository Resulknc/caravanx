package com.project.caryatch.domain.review;


import com.project.caryatch.domain.advertisement.Advertisement;
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
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "advertisement_id", referencedColumnName = "id", nullable = false)
    private Advertisement advertisementId;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;

    @Column(name = "submitted_at")
    private Date submittedAt;

    @Column(name = "visibility_status")
    private boolean visibilityStatus;
}
