package com.github.sejoung.test.sample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "MEMBER_DETAIL")
@Entity
@ToString
public class MemberDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_detail_id")
    private Long memberDetailId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String type;

    private String description;

    @Builder
    private MemberDetail(Member member, String type, String description) {
        this.member = member;
        this.type = type;
        this.description = description;
    }
}
