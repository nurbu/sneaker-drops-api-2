package com.pluralsight.sneakerdropsapi.service;

import com.pluralsight.sneakerdropsapi.data.BrandRepository;
import com.pluralsight.sneakerdropsapi.data.SneakerRepository;
import com.pluralsight.sneakerdropsapi.models.Brand;
import com.pluralsight.sneakerdropsapi.models.Sneaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SneakerService {

    private final SneakerRepository sneakerRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public SneakerService(SneakerRepository sneakerRepository, BrandRepository brandRepository) {
        this.sneakerRepository = sneakerRepository;
        this.brandRepository = brandRepository;
    }

    public List<Sneaker> allSneakers() {
        return sneakerRepository.findAll();
    }

    public Sneaker findById(Long id) {
        return sneakerRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public List<Sneaker> findByYear(int year) {
        return sneakerRepository.findByReleaseYear(year);
    }

    public List<Sneaker> findByPrice(double price) {
        return sneakerRepository.findByPriceLessThan(price);
    }

    public List<Sneaker> findByModel(String model) {
        return sneakerRepository.findByModelContaining(model);
    }

    public Sneaker add(String model, double price, int releaseYear, Long brandId) {
        Brand brand = brandRepository.findById(brandId)
                .orElseThrow(() -> new RuntimeException("No brand found with id " + brandId));
        return sneakerRepository.save(new Sneaker(model, price, releaseYear, brand));
    }

    public Sneaker updatePrice(Long id, double newPrice) {
        Sneaker sneaker = findById(id);
        sneaker.setPrice(newPrice);
        return sneakerRepository.save(sneaker);
    }

    public void delete(Long id) {
        if (!sneakerRepository.existsById(id)) {
            throw new NotFoundException(id);
        }
        sneakerRepository.deleteById(id);
    }

    public List<Sneaker> findByBrand(String brandName) {
        return sneakerRepository.findByBrandName(brandName);
    }

    public List<Sneaker> search(double maxPrice, int minReleaseYear) {
        return sneakerRepository.search(maxPrice, minReleaseYear);
    }
}