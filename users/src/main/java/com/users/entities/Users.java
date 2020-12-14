/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.users.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JEREMY
 */
@Entity
@Table(name = "data_users", catalog = "data", schema = "")
@XmlRootElement
@NamedQueries({
  @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
  @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
  @NamedQuery(name = "Users.findByIdIdentityDocumentType", query = "SELECT u FROM Users u WHERE u.idIdentityDocumentType = :idIdentityDocumentType"),
  @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
  @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
  @NamedQuery(name = "Users.findByMail", query = "SELECT u FROM Users u WHERE u.mail = :mail"),
  @NamedQuery(name = "Users.findByIdentification", query = "SELECT u FROM Users u WHERE u.identification = :identification"),
  @NamedQuery(name = "Users.findByPhone", query = "SELECT u FROM Users u WHERE u.phone = :phone")})
public class Users implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Basic(optional = false)
  @Column(name = "id")
  private Integer id;
  @Column(name = "id_identity_document_type")
  private Integer idIdentityDocumentType;
  @Size(max = 50)
  @Column(name = "first_name")
  private String firstName;
  @Size(max = 50)
  @Column(name = "last_name")
  private String lastName;
  @Size(max = 150)
  @Column(name = "mail")
  private String mail;
  @Column(name = "identification")
  private Integer identification;
  @Column(name = "phone")
  private BigInteger phone;

  public Users() {
  }

  public Users(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getIdIdentityDocumentType() {
    return idIdentityDocumentType;
  }

  public void setIdIdentityDocumentType(Integer idIdentityDocumentType) {
    this.idIdentityDocumentType = idIdentityDocumentType;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

  public Integer getIdentification() {
    return identification;
  }

  public void setIdentification(Integer identification) {
    this.identification = identification;
  }

  public BigInteger getPhone() {
    return phone;
  }

  public void setPhone(BigInteger phone) {
    this.phone = phone;
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
    if (!(object instanceof Users)) {
      return false;
    }
    Users other = (Users) object;
    if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "com.users.entities.Users[ id=" + id + " ]";
  }
  
}
