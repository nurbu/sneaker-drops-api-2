package com.pluralsight.sneakerdropsapi.data;

import com.pluralsight.sneakerdropsapi.models.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository extends JpaRepository<Sneaker, Long> {
}