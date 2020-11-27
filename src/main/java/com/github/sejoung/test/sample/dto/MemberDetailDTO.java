package com.github.sejoung.test.sample.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class MemberDetailDTO {

  private Long memberDetailId;
  private String type;
  private String description;
}
