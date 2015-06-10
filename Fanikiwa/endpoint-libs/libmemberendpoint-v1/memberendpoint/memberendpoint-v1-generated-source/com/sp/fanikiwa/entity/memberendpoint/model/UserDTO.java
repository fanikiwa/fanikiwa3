/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-03-26 20:30:19 UTC)
 * on 2015-05-30 at 05:37:58 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.memberendpoint.model;

/**
 * Model definition for UserDTO.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the memberendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class UserDTO extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime dateActivated;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime dateJoined;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String email;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String informBy;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String nationalID;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String pwd;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String status;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String surname;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String telephone;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String userType;

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getDateActivated() {
    return dateActivated;
  }

  /**
   * @param dateActivated dateActivated or {@code null} for none
   */
  public UserDTO setDateActivated(com.google.api.client.util.DateTime dateActivated) {
    this.dateActivated = dateActivated;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getDateJoined() {
    return dateJoined;
  }

  /**
   * @param dateJoined dateJoined or {@code null} for none
   */
  public UserDTO setDateJoined(com.google.api.client.util.DateTime dateJoined) {
    this.dateJoined = dateJoined;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getEmail() {
    return email;
  }

  /**
   * @param email email or {@code null} for none
   */
  public UserDTO setEmail(java.lang.String email) {
    this.email = email;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getInformBy() {
    return informBy;
  }

  /**
   * @param informBy informBy or {@code null} for none
   */
  public UserDTO setInformBy(java.lang.String informBy) {
    this.informBy = informBy;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getNationalID() {
    return nationalID;
  }

  /**
   * @param nationalID nationalID or {@code null} for none
   */
  public UserDTO setNationalID(java.lang.String nationalID) {
    this.nationalID = nationalID;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getPwd() {
    return pwd;
  }

  /**
   * @param pwd pwd or {@code null} for none
   */
  public UserDTO setPwd(java.lang.String pwd) {
    this.pwd = pwd;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getStatus() {
    return status;
  }

  /**
   * @param status status or {@code null} for none
   */
  public UserDTO setStatus(java.lang.String status) {
    this.status = status;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSurname() {
    return surname;
  }

  /**
   * @param surname surname or {@code null} for none
   */
  public UserDTO setSurname(java.lang.String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getTelephone() {
    return telephone;
  }

  /**
   * @param telephone telephone or {@code null} for none
   */
  public UserDTO setTelephone(java.lang.String telephone) {
    this.telephone = telephone;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getUserType() {
    return userType;
  }

  /**
   * @param userType userType or {@code null} for none
   */
  public UserDTO setUserType(java.lang.String userType) {
    this.userType = userType;
    return this;
  }

  @Override
  public UserDTO set(String fieldName, Object value) {
    return (UserDTO) super.set(fieldName, value);
  }

  @Override
  public UserDTO clone() {
    return (UserDTO) super.clone();
  }

}
