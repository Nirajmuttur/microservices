package com.example.factoryservice.controller;

import com.example.factoryservice.model.Factory;
import com.example.factoryservice.service.FactoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/factory")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FactoryController {
    @Autowired
    private FactoryService factoryService;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @PostMapping(value = "/create")
    private ResponseEntity<Object> createFactory(@RequestBody Factory factory){
        Factory newFactory=factoryService.addFactory(factory);
        return new ResponseEntity<>(newFactory, HttpStatus.OK);
    }

    @PutMapping(value="/update")
    private ResponseEntity<Object> updateFactory(@RequestBody Factory factory){
        Factory factory1=factoryService.updateFactory(factory);
        return new ResponseEntity<>(factory1, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    private ResponseEntity<Object> deleteFactory(@PathVariable("id") Long id){
        String response=webClientBuilder.build()
                .get()
                .uri("http://product-service/api/product/factory/" + id)
                .retrieve()
                .bodyToMono(String.class)
                .block();

            factoryService.deleteFactory(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/")
    private ResponseEntity<Object> getFactory(){
        List<Factory> factory=factoryService.getAllFactory();
        return new ResponseEntity<>(factory,HttpStatus.OK);
    }


    @GetMapping(value = "/product")
    private ResponseEntity<Object> getdummy(){
        String dummy = webClientBuilder.build()
                .get()
                .uri("http://product-service/product/api/")
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return new ResponseEntity<>(dummy,HttpStatus.OK);
    }


}
