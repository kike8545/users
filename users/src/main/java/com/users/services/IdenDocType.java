/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.services;

import com.users.dao.IdenDocTypeDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JEREMY
 */
@Service
public class IdenDocType implements IdenDocTypeInterfaceService {

  @Autowired
  private IdenDocTypeDAO idenDocTypeDAO;

  @Override
  public List<com.users.entities.IdenDocType> findAll() {
    return idenDocTypeDAO.findAll();
  }

}
