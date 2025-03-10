package com.example.demo;

// import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements Services {
    private RepositoryImpl repository;

    public void Service(RepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public void guardar() {
        repository.guardar();
    }
}
