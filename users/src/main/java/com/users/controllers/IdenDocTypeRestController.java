/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.controllers;

import com.users.entities.IdenDocType;
import com.users.services.IdenDocTypeInterfaceService;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author JEREMY
 */
@RestController
@RequestMapping("/idenDocType")
public class IdenDocTypeRestController {

  private static final Logger logger = LoggerFactory.getLogger(IdenDocTypeRestController.class);

  @Autowired
  private IdenDocTypeInterfaceService IdenDocTypeService;

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<IdenDocType> list() {
    List<IdenDocType> res = new ArrayList<>(IdenDocTypeService.findAll());

    return res;
  }

  @GetMapping("/{id}")
  public Object get(@PathVariable String id) {
    return null;
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
    return null;
  }

  @PostMapping
  public ResponseEntity<?> post(@RequestBody Object input) {
    return null;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable String id) {
    return null;
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error message")
  public Object handleError(HttpServletRequest req, Exception ex) {
    Object errorObject = new Object();
    return errorObject;
  }

}
