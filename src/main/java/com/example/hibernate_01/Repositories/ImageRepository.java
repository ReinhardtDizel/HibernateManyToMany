package com.example.hibernate_01.Repositories;

import com.example.hibernate_01.Model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, String> {
}
