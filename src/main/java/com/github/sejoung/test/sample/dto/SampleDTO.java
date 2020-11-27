package com.github.sejoung.test.sample.dto;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@ToString
public class SampleDTO {

  private Long key;

  private String name;

  private LocalDateTime registerDateTime;

}
