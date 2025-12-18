package edu.MDA.onaMagulak.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private String id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @CreationTimestamp
    private Date creationDate;
    @UpdateTimestamp
    private Date updateDate;
    @Column(nullable = false)
    private String role;

    //add relations
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AddressEntity> addresses = new ArrayList<>();
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ReviewEntity> reviews = new ArrayList<>();
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<OrderEntity> orders = new ArrayList<>();
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart")
    private CartEntity cart;
}
