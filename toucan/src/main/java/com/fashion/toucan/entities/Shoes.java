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
public class Shoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int shoeNumber;
    @Column(nullable = false, unique = true, length = 40)
    String shoeName;
    @Column(nullable = false, length = 40)
    String shoeQuantity;
    @Column(nullable = false, length = 40)
    String shoeUnitPrice;
    @Column(nullable = false, length = 40)
    String shoeDetails;
    @Column(nullable = false, length = 40)
    String shoeGender;
}
