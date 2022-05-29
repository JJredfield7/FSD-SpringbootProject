package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.RestaurantInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Long> {
}