package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Roles")
public class RolesEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private Boolean c, r, u, d;

  public RolesEntity() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getCreate() {
    return c;
  }

  public void setCreate(Boolean create) {
    this.c = create;
  }

  public Boolean getDelete() {
    return d;
  }

  public void setDelete(Boolean delete) {
    this.d = delete;
  }

  public Boolean getRead() {
    return r;
  }

  public void setRead(Boolean read) {
    this.r = read;
  }

  public Boolean getUpdate() {
    return u;
  }

  public void setUpdate(Boolean update) {
    this.u = update;
  }

}
