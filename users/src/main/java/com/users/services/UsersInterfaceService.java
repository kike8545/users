/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.services;

import com.users.entities.Users;
import java.util.List;

/**
 *
 * @author JEREMY
 */
public interface UsersInterfaceService {

  List<Users> findAll();

  void edit(Users user);

  Users findByMail(String mail);

  Users findByIdentification(Integer numDoc);

  void create(Users user);
}
