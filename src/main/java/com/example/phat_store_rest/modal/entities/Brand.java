package com.example.phat_store_rest.modal.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@Builder
@Entity
@Table(name = "brand_t")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @OneToMany
    private Set<Item> catalogue;
    public Brand(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
