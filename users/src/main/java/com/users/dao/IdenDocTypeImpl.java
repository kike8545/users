/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.dao;

import com.users.entities.IdenDocType;
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
public class IdenDocTypeImpl implements IdenDocTypeDAO {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public List<IdenDocType> findAll() {
    try {
      javax.persistence.criteria.CriteriaQuery cq = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery();
      cq.select(cq.from(IdenDocType.class));

      List<IdenDocType> result = sessionFactory.getCurrentSession().createQuery(cq).getResultList();

      if (result.equals(null)) {
        throw new NoResultException(
                "No se encontraron Tipos de documentos");
      }
      return result;

    } catch (NoResultException | HibernateException e) {
      System.out.println("com.sogesac.core.dao.IdenDocTypeDAOImpl.save()" + e);
    }

    return null;
  }

}
