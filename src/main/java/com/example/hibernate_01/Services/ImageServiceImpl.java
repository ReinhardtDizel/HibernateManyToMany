package com.example.hibernate_01.Services;

import com.example.hibernate_01.Model.Image;
import com.example.hibernate_01.Repositories.ImageRepository;
import com.example.hibernate_01.Services.Interfaces.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image save(Image image) {
        return this.imageRepository.save(image);
    }

    @Override
    public boolean existsById(String id) {
        return this.imageRepository.existsById(id);
    }

    @Override
    public void delete(String id) {
        this.imageRepository.delete(this.getById(id));
    }

    @Override
    public Image getById(String id) {
        return this.imageRepository.getById(id);
    }
}
