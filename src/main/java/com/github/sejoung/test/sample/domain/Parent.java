package com.github.sejoung.test.sample.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Parent {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "parent_id")
  private Long parentId;

  private String name;

  @OneToMany(mappedBy = "parent", cascade = CascadeType.PERSIST)
  private final List<Child> children = new ArrayList<>();

  public Parent(String name) {
    this.name = name;
  }

  public void addChildren(Child child) {
    child.setParent(this);
    children.add(child);
  }

}
