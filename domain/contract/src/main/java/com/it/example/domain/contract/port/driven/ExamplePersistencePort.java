package com.it.example.domain.contract.port.driven;

import com.it.example.domain.contract.model.entity.ExampleEntity;

public interface ExamplePersistencePort {
    void save(ExampleEntity entity);

    ExampleEntity findById(String id);
}
