package com.pluralsight.sneakerdropsapi.data;

import com.pluralsight.sneakerdropsapi.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand, Long> {
}
