package com.example.hibernate_01.Services.Interfaces;

import com.example.hibernate_01.Model.Image;

import java.util.List;
import java.util.Optional;

public interface ImageService {
    Image save(Image image);
    boolean existsById(String id);
    void delete(String id);
    Image getById(String id);
}
