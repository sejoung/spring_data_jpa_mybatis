package com.github.sejoung.test.sample.mapper;

import com.github.sejoung.test.sample.dto.SampleDTO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SampleMapper {

  List<SampleDTO> selectSampleList();
}
