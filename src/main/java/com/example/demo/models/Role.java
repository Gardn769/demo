package com.example.demo.models;

import com.example.demo.entity.RolesEntity;

public class Role {
  private String name;
  private Boolean Create;
  private Boolean Read;
  private Boolean _update;
  private Boolean _delete;

  public static Role toModel(RolesEntity entity) {
    Role model = new Role();
    model.setName(entity.getName());
    model.setCreate(entity.getCreate());
    model.set_delete(entity.getDelete());
    model.setRead(entity.getRead());
    model.set_update(entity.getUpdate());
    return model;
  }

  public Role() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getCreate() {
    return Create;
  }

  public void setCreate(Boolean Create) {
    this.Create = Create;
  }

  public Boolean get_delete() {
    return _delete;
  }

  public void set_delete(Boolean _delete) {
    this._delete = _delete;
  }

  public Boolean getRead() {
    return Read;
  }

  public void setRead(Boolean _read) {
    this.Read = _read;
  }

  public Boolean get_update() {
    return _update;
  }

  public void set_update(Boolean _update) {
    this._update = _update;
  }
}
