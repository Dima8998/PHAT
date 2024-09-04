package com.example.phat_store_rest.modal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@Builder
@Entity
@Table(name = "category_t")
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany
    private Set<Item> catalogue;

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
