package com.fashion.toucan.repositories;

import com.fashion.toucan.entities.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes,Integer> {
}
