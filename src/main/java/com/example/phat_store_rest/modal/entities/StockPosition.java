package com.example.phat_store_rest.modal.entities;

import com.example.phat_store_rest.modal.entities.enumAttributes.Color;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Builder
@Entity
@Table(name = "stock_position_t")
@AllArgsConstructor
@NoArgsConstructor
public class StockPosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "size")
    private String size;
    @Column(name = "color")
    @Enumerated(EnumType.STRING)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
