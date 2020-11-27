package com.github.sejoung.test.sample.repository;

import com.github.sejoung.test.sample.domain.Sample;
import com.github.sejoung.test.sample.mapper.SampleMapper;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureMybatis
class SampleRepositoryTest {

    @Autowired
    private SampleRepository sampleRepository;

    @Autowired
    private SampleMapper sampleMapper;


    @Test
    void 정상() {
        var sample = Sample.builder().sampleName("메롱").registerDateTime(LocalDateTime.now())
            .build();

        sampleRepository.save(sample);

        sampleMapper.selectSampleList().forEach(
            sampleDTO -> {
                log.debug("{}", sampleDTO);
                Assertions.assertEquals(sample.getSampleKey(), sampleDTO.getKey(), "잘못된 키입니다.");
            }
        );

        sampleRepository.findAll().forEach(s -> log.debug("{}", s));


    }
}