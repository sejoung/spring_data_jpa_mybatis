package com.github.sejoung.test.sample.repository;

import com.github.sejoung.test.sample.domain.Sample;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<Sample, Long> {

}
