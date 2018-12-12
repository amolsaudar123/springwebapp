package com.springframework.springwebapp.repositories;

import com.springframework.springwebapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository  extends CrudRepository<Publisher, Long> {
}
