package com.example.provaAv1.repository;

import com.example.provaAv1.model.ReleaseEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReleaseRepository extends MongoRepository<ReleaseEntity, String> {
}
