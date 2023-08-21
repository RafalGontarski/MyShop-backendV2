package com.codeMaker.MyShop.App.carouselImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/carousel")
public class CarouselImageController {


    private final CarouselImageRepository carouselImageRepository;

    @Autowired
    public CarouselImageController(CarouselImageRepository carouselImageRepository) {
        this.carouselImageRepository = carouselImageRepository;
    }

    @GetMapping
    public List<CarouselImage> getAllImages() {
        return carouselImageRepository.findAll();
    }

    @PostMapping
    public CarouselImage addImage(@RequestParam("image") MultipartFile file) throws IOException {
        CarouselImage carouselImage = new CarouselImage();
        carouselImage.setImage(file.getBytes());
        return carouselImageRepository.save(carouselImage);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        carouselImageRepository.deleteById(id);
    }
}
