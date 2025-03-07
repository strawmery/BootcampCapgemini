package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements Service {
    private RepositoryImpl repository;

    public Service(RepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public void guardar() {
        repository.guardar();
    }


}
