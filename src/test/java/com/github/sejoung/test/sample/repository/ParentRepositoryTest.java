package com.github.sejoung.test.sample.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.github.sejoung.test.sample.domain.Child;
import com.github.sejoung.test.sample.domain.Parent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@DataJpaTest
@AutoConfigureMybatis
class ParentRepositoryTest {

  @Autowired
  private ParentRepository repository;

  @Test
  void child() {
    var parent = new Parent("sejoung");
    parent.addChildren(new Child("123"));
    repository.save(parent);

    repository.findAll().forEach(parent1 -> log.debug("{}", parent1));
  }
}