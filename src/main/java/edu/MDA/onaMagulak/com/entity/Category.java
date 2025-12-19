package edu.MDA.onaMagulak.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String categoryName;
    @OneToMany(mappedBy = "id",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductCategoryEntity> productCategoryEntities=new ArrayList<>();
}
