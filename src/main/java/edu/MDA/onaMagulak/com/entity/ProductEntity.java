package edu.MDA.onaMagulak.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double price;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private boolean isAvailable;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime creationDate;
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductCategoryEntity> productCategories=new ArrayList<>();
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    private List<ReviewEntity> reviews=new ArrayList<>();
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL)
    private List<CartItemEntity> cartItems=new ArrayList<>();

}
