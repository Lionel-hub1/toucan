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
public class Clothes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int clothNumber;
    @Column(nullable = false, unique = true, length = 40)
    String clothName;
    @Column(nullable = false, length = 40)
    String clothQuantity;
    @Column(nullable = false, length = 40)
    String clothUnitPrice;
    @Column(nullable = false, length = 40)
    String clothDetails;
    @Column(nullable = false, length = 40)
    String clothGender;
}
