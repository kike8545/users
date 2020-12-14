/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.controllers;

import com.users.services.UsersInterfaceService;
import com.users.entities.Users;
import com.users.exception.UsersBadMailException;
import com.users.exception.UsersBadNumberException;
import com.users.exception.UsersMailOrIdExistingException;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.validator.routines.IntegerValidator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author JEREMY
 */
@RestController
@RequestMapping("/users")
public class UsersRestController {

  @Autowired
  private UsersInterfaceService usersInterfaceService;
  private Users user;
  public static final Pattern VALID_EMAIL_ADDRESS_REGEX
          = Pattern.compile("^(.+)@(.+)$", Pattern.CASE_INSENSITIVE);

  public static final Pattern VALID_NUMBER_REGEX
          = Pattern.compile(".*[^0-9].*");

  @RequestMapping(method = RequestMethod.GET, produces = "application/json")
  @ResponseBody
  public List<Users> list() {
    List<Users> res = new ArrayList<>(usersInterfaceService.findAll());

    return res;
  }

  @GetMapping("/{id}")
  public Object get(@PathVariable String id) {
    return null;
  }

  @PutMapping
  public ResponseEntity<Users> put(@RequestBody Users user) {
    usersInterfaceService.edit(user);

    return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<Users> post(@RequestBody Users user) throws UsersBadMailException,
          UsersBadNumberException, UsersMailOrIdExistingException {

//    Matcher matcherMail = VALID_EMAIL_ADDRESS_REGEX.matcher(user.getMail());
    Matcher matcherNumber = VALID_NUMBER_REGEX.matcher(user.getIdentification().toString());
    boolean isValidEmail = EmailValidator.getInstance().isValid(user.getMail());
    boolean isValidNumber = IntegerValidator.getInstance().isValid(user.getIdentification().toString());
    if (!isValidEmail) {
      throw new UsersBadMailException("Ingrese un mail correcto");
    } else if (!isValidNumber) {
      throw new UsersBadNumberException("Ingrese un número correcto");
    } else if (usersInterfaceService.findByMail(user.getMail()) != null
            || usersInterfaceService.findByIdentification(user.getIdentification()) != null) {
      throw new UsersMailOrIdExistingException("Mail o número de identificación ya existen");
    } else {
      usersInterfaceService.create(user);
      return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
    }

  }

}
