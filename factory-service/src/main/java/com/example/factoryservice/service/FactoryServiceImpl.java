package com.example.factoryservice.service;

import com.example.factoryservice.exception.FactoryNotFoundException;
import com.example.factoryservice.model.Factory;
import com.example.factoryservice.repository.FactoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FactoryServiceImpl implements FactoryService{
    @Autowired
    private FactoryRepository factoryRepository;

    @Override
    public Factory addFactory(Factory factory) {
        return factoryRepository.save(factory);
    }

    @Override
    public Factory updateFactory(Factory factory) {
        return factoryRepository.save(factory);
    }

    @Override
    public void deleteFactory(Long id) {
        Optional<Factory> factory=factoryRepository.findFactoryById(id);
        if(factory.isEmpty()){
            throw new FactoryNotFoundException();
        }
        factoryRepository.deleteById(id);
    }

    @Override
    public List<Factory> getAllFactory() {
        return factoryRepository.findAll();
    }


}
