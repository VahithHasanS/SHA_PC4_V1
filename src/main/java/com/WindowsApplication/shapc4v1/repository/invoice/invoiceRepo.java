package com.WindowsApplication.shapc4v1.repository.invoice;

import com.WindowsApplication.shapc4v1.entity.invoice.invoiceEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface invoiceRepo extends MongoRepository<invoiceEntity, String> {
    @Query("{ 'Name': ?0 }")
    Optional<List<invoiceEntity>> findByName(String Name);
}
