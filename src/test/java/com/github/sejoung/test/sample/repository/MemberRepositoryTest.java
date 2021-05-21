package com.github.sejoung.test.sample.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@AutoConfigureMybatis
@DataJpaTest
class MemberRepositoryTest {

  @Autowired
  private MemberRepository repository;

  @Test
  void name() {
    repository.findAll().forEach(member -> log.debug("{}", member));
  }
}