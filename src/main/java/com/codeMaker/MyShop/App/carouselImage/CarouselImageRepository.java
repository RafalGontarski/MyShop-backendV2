package com.codeMaker.MyShop.App.carouselImage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarouselImageRepository extends JpaRepository<CarouselImage, Long> {
}
