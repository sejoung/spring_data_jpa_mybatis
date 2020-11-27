package com.github.sejoung.test.sample.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER")
@Entity
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long memberId;

    private String name;

    @Column(name = "create_dt")
    private LocalDateTime createDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<MemberDetail> details = new ArrayList<>();

    @Builder
    private Member(String name, LocalDateTime createDate,
        List<MemberDetail> details) {
        this.name = name;
        this.createDate = createDate;
        this.details = details;
    }
}
