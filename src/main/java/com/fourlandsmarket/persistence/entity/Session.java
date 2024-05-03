package com.fourlandsmarket.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_session")
@Getter
@Setter
public class Session {
    @Id
    @Column(name = "id_session")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSession;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @Column(name = "start_date")
    private LocalDateTime dateStart;

    @Column(name = "end_date")
    private LocalDateTime dateEnd;
    @Column(name = "session_token")
    private String token;

}
