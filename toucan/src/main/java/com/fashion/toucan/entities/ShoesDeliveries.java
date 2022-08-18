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
public class ShoesDeliveries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer shoeDeliveryId;
    @Column(unique = true,nullable = false,length = 40)
    String customerName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_name")
    Shoes shoes;
    @Column(nullable = false,length = 40)
    Integer shoePurchaseQuantity;
    @Column(nullable = false,length = 40)
    String customerLocation;
}
