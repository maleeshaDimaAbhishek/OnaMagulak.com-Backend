package edu.MDA.onaMagulak.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;

@Entity
@Table(name = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int rating;
    @Column(nullable = false)
    private String comment;
    @CreationTimestamp
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
