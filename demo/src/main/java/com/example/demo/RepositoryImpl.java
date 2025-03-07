package com.example.demo;

import org.springframework.stereotype.Repository;

@RepositoryImpl
public class RepositoryImpl implements Repository {	

    public RepositoryImpl(Configuracion config){
    }

    @Override
    public void save() {
        System.out.println("RepositoryImpl.save()");
    }

}
