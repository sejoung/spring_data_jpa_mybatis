package com.github.sejoung.test.sample.repository;

import com.github.sejoung.test.sample.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

}
