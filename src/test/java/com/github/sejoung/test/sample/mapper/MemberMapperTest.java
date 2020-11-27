package com.github.sejoung.test.sample.mapper;

import com.github.sejoung.test.sample.domain.Member;
import com.github.sejoung.test.sample.domain.MemberDetail;
import com.github.sejoung.test.sample.dto.MemberDTO;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureMybatis
class MemberMapperTest {

  @Autowired
  private MemberMapper memberMapper;

  @Autowired
  private TestEntityManager entityManager;

  @Transactional
  @DisplayName("XML 설정")
  @Test
  void selectMemberListXML() {

    saveData();

    List<MemberDTO> memberList = memberMapper.selectMemberListXML();
    log.debug("memberList {}", memberList);
    Assertions.assertThat(memberList.size()).isOne();
    Assertions.assertThat(memberList.get(0).getDetails().size()).isEqualTo(2);
  }

  @Transactional
  @DisplayName("어너테이션 설정")
  @Test
  void selectMemberList() {

    saveData();
    List<MemberDTO> memberList = memberMapper.selectMemberList();
    log.debug("memberList {}", memberList);
    Assertions.assertThat(memberList.size()).isOne();
    Assertions.assertThat(memberList.get(0).getDetails().size()).isEqualTo(2);
  }

  @Transactional
  @DisplayName("XML 설정 조인 쿼리")
  @Test
  void selectMemberListJoinXML() {
    saveData();
    List<MemberDTO> memberList = memberMapper.selectMemberListJoinXML();
    log.debug("memberList {}", memberList);
    Assertions.assertThat(memberList.size()).isOne();
    Assertions.assertThat(memberList.get(0).getDetails().size()).isEqualTo(2);
  }

  private void saveData() {

    var member = Member.builder().name("완구").createDate(LocalDateTime.now()).build();

    entityManager.persist(member);
    entityManager
      .persist(MemberDetail.builder().description("레고").type("장난감").member(member).build());
    entityManager
      .persist(
        MemberDetail.builder().description("플레이모빌").type("장난감").member(member).build());
    entityManager.flush();
  }
}