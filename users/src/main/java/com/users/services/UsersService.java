/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.services;

import com.users.entities.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.users.dao.UsersDAO;

/**
 *
 * @author JEREMY
 */
@Service
public class UsersService implements UsersInterfaceService {

  @Autowired
  private UsersDAO dataUsersDAO;

  @Override
  public List<Users> findAll() {

    return dataUsersDAO.findAll();

  }

  @Override
  @Transactional
  public void create(Users user) {
    dataUsersDAO.create(user);
  }

  @Override
  public Users findByMail(String mail) {
    return dataUsersDAO.findByMail(mail);
  }

  @Override
  public Users findByIdentification(Integer numDoc) {
    return dataUsersDAO.findByIdentification(numDoc);
  }

  @Override
  public void edit(Users user) {
    dataUsersDAO.edit(user);
  }

}
