package com.github.sejoung.test.sample.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "SAMPLE")
@Entity
@ToString
public class Sample {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sample_key")
  private Long sampleKey;

  @Column(name = "sampleName")
  private String sampleName;

  @Column(name = "registerDateTime")
  private LocalDateTime registerDateTime;

  @Builder
  private Sample(String sampleName, LocalDateTime registerDateTime) {
    this.sampleName = sampleName;
    this.registerDateTime = registerDateTime;
  }
}
