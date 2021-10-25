package com.example.demo.controller;

import com.example.demo.entity.RolesEntity;
import com.example.demo.exceptions.RoleAlreadyExistException;
import com.example.demo.exceptions.RoleNotFoundException;
import com.example.demo.service.RolesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roles")
public class RolesController {

  @Autowired
  private RolesService rolesService;

  @PostMapping
  public ResponseEntity createRole(@RequestBody RolesEntity role) {
    try {
      rolesService.create(role);
      return ResponseEntity.ok("Success create role!");
    } catch (RoleAlreadyExistException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error create role");
    }
  }

  @GetMapping
  public ResponseEntity getOne(@RequestParam Long id) {
    try {
      return ResponseEntity.ok(rolesService.getOne(id));
    } catch (RoleNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("role not faund");
    }
  }

  @PatchMapping
  public ResponseEntity update(@RequestParam Long id, @RequestBody RolesEntity role) {
    try {
      rolesService.update(id, role);
      return ResponseEntity.ok("Update Succsesful");
    } catch (RoleNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error update");
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable Long id) {
    try {
      rolesService.delete(id);
      return ResponseEntity.ok("delete Succsesful");
    } catch (RoleNotFoundException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.badRequest().body("Error delete");
    }
  }
}
