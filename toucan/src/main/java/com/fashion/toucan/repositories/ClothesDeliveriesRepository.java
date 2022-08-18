package com.fashion.toucan.repositories;

import com.fashion.toucan.entities.ClothesDeliveries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothesDeliveriesRepository extends JpaRepository<ClothesDeliveries,Integer> {

}
