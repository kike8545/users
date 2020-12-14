/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JEREMY
 */
@Entity
@Table(name = "identity_document_type", catalog = "data", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "IdenDocType.findAll", query = "SELECT i FROM IdenDocType i"),
  @NamedQuery(name = "IdenDocType.findById", query = "SELECT i FROM IdenDocType i WHERE i.id = :id"),
  @NamedQuery(name = "IdenDocType.findByName", query = "SELECT i FROM IdenDocType i WHERE i.name = :name"),
  @NamedQuery(name = "IdenDocType.findByDescription", query = "SELECT i FROM IdenDocType i WHERE i.description = :description"),
  @NamedQuery(name = "IdenDocType.findByCode", query = "SELECT i FROM IdenDocType i WHERE i.code = :code")})
public class IdenDocType implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "code")
  private String code;

  public IdenDocType() {
  }

  public IdenDocType(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (id != null ? id.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof IdenDocType)) {
      return false;
    }
    IdenDocType other = (IdenDocType) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.users.entities.IdentityDocumentType[ id=" + id + " ]";
  }
  
}
