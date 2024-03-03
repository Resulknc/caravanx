package com.project.caryatch.domain.message;

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
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @ManyToOne
    @JoinColumn(name = "sender_user_id", referencedColumnName = "id", nullable = false)
    private User sender_user_id;

    @ManyToOne
    @JoinColumn(name = "recipient_user_id", referencedColumnName = "id", nullable = false)
    private User recipient_user_id;

    @Column(name = "content")
    private String content;

    @Column(name = "timestamp")
    private Date time;

    @Column(name = "read_status")
    private boolean read_status;
}
