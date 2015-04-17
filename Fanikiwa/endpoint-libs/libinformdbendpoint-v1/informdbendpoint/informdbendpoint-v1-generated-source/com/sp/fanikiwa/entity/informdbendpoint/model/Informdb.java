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
 * on 2015-04-13 at 07:08:13 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.informdbendpoint.model;

/**
 * Model definition for Informdb.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the informdbendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Informdb extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String addressFrom;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String addressTo;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String body;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime messageDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String messageType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String status;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String subject;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAddressFrom() {
    return addressFrom;
  }

  /**
   * @param addressFrom addressFrom or {@code null} for none
   */
  public Informdb setAddressFrom(java.lang.String addressFrom) {
    this.addressFrom = addressFrom;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getAddressTo() {
    return addressTo;
  }

  /**
   * @param addressTo addressTo or {@code null} for none
   */
  public Informdb setAddressTo(java.lang.String addressTo) {
    this.addressTo = addressTo;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getBody() {
    return body;
  }

  /**
   * @param body body or {@code null} for none
   */
  public Informdb setBody(java.lang.String body) {
    this.body = body;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getId() {
    return id;
  }

  /**
   * @param id id or {@code null} for none
   */
  public Informdb setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getMessageDate() {
    return messageDate;
  }

  /**
   * @param messageDate messageDate or {@code null} for none
   */
  public Informdb setMessageDate(com.google.api.client.util.DateTime messageDate) {
    this.messageDate = messageDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMessageType() {
    return messageType;
  }

  /**
   * @param messageType messageType or {@code null} for none
   */
  public Informdb setMessageType(java.lang.String messageType) {
    this.messageType = messageType;
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
  public Informdb setStatus(java.lang.String status) {
    this.status = status;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getSubject() {
    return subject;
  }

  /**
   * @param subject subject or {@code null} for none
   */
  public Informdb setSubject(java.lang.String subject) {
    this.subject = subject;
    return this;
  }

  @Override
  public Informdb set(String fieldName, Object value) {
    return (Informdb) super.set(fieldName, value);
  }

  @Override
  public Informdb clone() {
    return (Informdb) super.clone();
  }

}
