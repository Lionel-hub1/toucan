package com.fashion.toucan.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClothesDeliveries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer clothDeliveryId;
    @Column(unique = true,nullable = false,length = 40)
    String customerName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cloth_name")
    Clothes clothes;
    @Column(nullable = false, length = 40)
    Integer clothPurchaseQuantity;
    @Column(nullable = false, length = 40)
    String customerLocation;
}
