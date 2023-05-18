package com.ntnt.democinema.controller;

import com.ntnt.democinema.entity.ResponseObject;
import com.ntnt.democinema.entity.Role;
import com.ntnt.democinema.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("")
    private ResponseEntity<ResponseObject> getAllRole()
    {
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("false","Get all role successfully", roleService.getAllRole())
        );
    }

    @PostMapping("/add")
    private ResponseEntity<ResponseObject> addRole(@ModelAttribute Role role)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseObject("false","insert successfully", roleService.addRole(role))
        );
    }
}
