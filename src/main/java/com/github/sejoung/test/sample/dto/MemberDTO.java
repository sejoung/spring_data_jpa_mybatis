package com.github.sejoung.test.sample.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class MemberDTO {

  private Long memberId;
  private String name;
  private LocalDateTime createDate;
  private List<MemberDetailDTO> details;
}
