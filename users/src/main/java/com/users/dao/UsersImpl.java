/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.dao;

import com.users.entities.Users;
import java.util.List;
import javax.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JEREMY
 */
@Repository
@Transactional
public class UsersImpl implements UsersDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<Users> findAll() {
    try {
      return (List<Users>) sessionFactory.getCurrentSession()
              .createNamedQuery("Users.findAll")
              .getResultList();
    } catch (HibernateException e) {
      System.err.println("com.users.dao.DataUsersImpl.findAll() " + e);
    }
    return null;
  }

  @Override
  public void create(Users user) {
    try {
      sessionFactory.getCurrentSession().save(user);
    } catch (HibernateException e) {
      System.out.println("com.users.dao.DataUsersImpl.create() " + e);
    }
  }

  @Override
  public Users findByMail(String mail) {
    try {
      return (Users) sessionFactory.getCurrentSession()
              .createNamedQuery("Users.findByMail")
              .setParameter("mail", mail)
              .getSingleResult();
    } catch (HibernateException e) {
      System.out.println("com.users.dao.DataUsersImpl.findByMail() " + e);
    } catch (NoResultException e) {

      return null;
    }
    return null;
  }

  @Override
  public Users findByIdentification(Integer numDoc) {
    try {
      return (Users) sessionFactory.getCurrentSession()
              .createNamedQuery("Users.findByIdentification")
              .setParameter("identification", numDoc)
              .getSingleResult();
    } catch (HibernateException e) {
      System.out.println("com.users.dao.DataUsersImpl.findByIdentification() " + e);
    } catch (NoResultException e) {
      return null;
    }
    return null;
  }

  @Override
  public void edit(Users user) {
    try {
      sessionFactory.getCurrentSession().update(user);
    } catch (HibernateException e) {
      System.out.println("com.users.dao.DataUsersImpl.edit() " + e);
    }
  }

}
