package com.example.firstWebBE.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private Long id;

    @Column(name = "category_name")
    private String category_name;

    @Column(name = "category_description")
    private String category_description;

    @Column(name = "category_img")
    private String category_img;
}
