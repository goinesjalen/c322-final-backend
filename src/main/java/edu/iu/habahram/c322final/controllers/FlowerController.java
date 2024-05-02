package edu.iu.habahram.c322final.controllers;

import edu.iu.habahram.c322final.model.Flower;
import edu.iu.habahram.c322final.repository.FlowerFileRepository;
import edu.iu.habahram.c322final.repository.FlowerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/flowers")
public class FlowerController {

    private FlowerRepository flowerRepository;

    public FlowerController(FlowerRepository flowerRepository) {
        this.flowerRepository = flowerRepository;
    }

    @GetMapping("/{id}")
    public Flower find(@PathVariable("id") int id) {
        Optional<Flower> flower = flowerRepository.findById(String.valueOf(id));
        if(flower.isPresent()){
            return flower.get();
        }
        else{
            throw new RuntimeException("Unable to get flower");
        }
    }

    @GetMapping
    public List<Flower> findAll() {
        return (List<Flower>) flowerRepository.findAll();
    }

    @PostMapping
    public int add(@RequestBody Flower flower) {
        flowerRepository.save(flower);
        return flower.getId();
    }
}