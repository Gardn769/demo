package com.example.demo.service;

import com.example.demo.entity.RolesEntity;
import com.example.demo.exceptions.RoleAlreadyExistException;
import com.example.demo.exceptions.RoleNotFoundException;
import com.example.demo.models.Role;
import com.example.demo.repository.RolesRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesService {

  @Autowired
  private RolesRep rolesRep;

  public RolesEntity create(RolesEntity entity) throws RoleAlreadyExistException {
    if (rolesRep.findByName(entity.getName()) != null) {
      throw new RoleAlreadyExistException("message");
    }
    return rolesRep.save(entity);
  }

  public Role getOne(Long id) throws RoleNotFoundException {
    RolesEntity entity = rolesRep.findById(id).get();
    if (entity == null) {
      throw new RoleNotFoundException("message");
    }
    return Role.toModel(entity);
  }

  public RolesEntity update(Long id, RolesEntity role) throws RoleNotFoundException {
    RolesEntity entity = rolesRep.findById(id).get();
    if (entity == null) {
      throw new RoleNotFoundException("message");
    }

    if (role.getName() != null)
      entity.setName(role.getName());
    if (role.getCreate() != null)
      entity.setCreate(role.getCreate());
    if (role.getDelete() != null)
      entity.setDelete(role.getDelete());
    if (role.getRead() != null)
      entity.setRead(role.getRead());
    if (role.getUpdate() != null)
      entity.setUpdate(role.getUpdate());

    return rolesRep.save(entity);
  }

  public void delete(Long id) throws RoleNotFoundException {
    if (!rolesRep.existsById(id)) {
      throw new RoleNotFoundException("message");
    }
    rolesRep.deleteById(id);
  }

}
