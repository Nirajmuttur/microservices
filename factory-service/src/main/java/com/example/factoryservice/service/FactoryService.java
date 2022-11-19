package com.example.factoryservice.service;

import com.example.factoryservice.model.Factory;

import java.util.List;
import java.util.Optional;

public interface FactoryService {
    Factory addFactory(Factory factory);
    Factory updateFactory(Factory factory);
    void deleteFactory(Long id);

    List<Factory> getAllFactory();
}
