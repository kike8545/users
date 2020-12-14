/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.dao;

import com.users.entities.IdenDocType;
import java.util.List;

/**
 *
 * @author JEREMY
 */
public interface IdenDocTypeDAO {

  List<IdenDocType> findAll();
}
