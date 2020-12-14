/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author JEREMY
 */
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Ingrese un número correcto")
public class UsersBadNumberException extends Exception {

  private static final long serialVersionUID = 1L;

  public UsersBadNumberException(String errorMessage) {
    super(errorMessage);

  }
}
