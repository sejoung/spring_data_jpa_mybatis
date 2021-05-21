package com.github.sejoung.test.sample.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.sejoung.test.sample.domain.Parent;

public interface ParentRepository extends CrudRepository<Parent, Long> {

}
