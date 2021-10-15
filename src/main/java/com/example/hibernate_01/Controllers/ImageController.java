package com.example.hibernate_01.Controllers;

import com.example.hibernate_01.Model.Image;
import com.example.hibernate_01.Services.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private ImageServiceImpl imageServiceImpl;

    @PostMapping
    Image postImage(@RequestBody Image image)  {
        System.out.println(image);
      return null;
    }
}
