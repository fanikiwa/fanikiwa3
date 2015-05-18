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
 * (build: 2015-05-05 20:00:12 UTC)
 * on 2015-05-16 at 12:35:39 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.offerendpoint.model;

/**
 * Model definition for OfferDTO.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the offerendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class OfferDTO extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double amount;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime createdDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String description;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String email;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime expiryDate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double interest;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String offerType;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String offerees;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean partialPay;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean privateOffer;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String status;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer term;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getAmount() {
    return amount;
  }

  /**
   * @param amount amount or {@code null} for none
   */
  public OfferDTO setAmount(java.lang.Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate createdDate or {@code null} for none
   */
  public OfferDTO setCreatedDate(com.google.api.client.util.DateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDescription() {
    return description;
  }

  /**
   * @param description description or {@code null} for none
   */
  public OfferDTO setDescription(java.lang.String description) {
    this.description = description;
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
  public OfferDTO setEmail(java.lang.String email) {
    this.email = email;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getExpiryDate() {
    return expiryDate;
  }

  /**
   * @param expiryDate expiryDate or {@code null} for none
   */
  public OfferDTO setExpiryDate(com.google.api.client.util.DateTime expiryDate) {
    this.expiryDate = expiryDate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getInterest() {
    return interest;
  }

  /**
   * @param interest interest or {@code null} for none
   */
  public OfferDTO setInterest(java.lang.Double interest) {
    this.interest = interest;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getOfferType() {
    return offerType;
  }

  /**
   * @param offerType offerType or {@code null} for none
   */
  public OfferDTO setOfferType(java.lang.String offerType) {
    this.offerType = offerType;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getOfferees() {
    return offerees;
  }

  /**
   * @param offerees offerees or {@code null} for none
   */
  public OfferDTO setOfferees(java.lang.String offerees) {
    this.offerees = offerees;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getPartialPay() {
    return partialPay;
  }

  /**
   * @param partialPay partialPay or {@code null} for none
   */
  public OfferDTO setPartialPay(java.lang.Boolean partialPay) {
    this.partialPay = partialPay;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getPrivateOffer() {
    return privateOffer;
  }

  /**
   * @param privateOffer privateOffer or {@code null} for none
   */
  public OfferDTO setPrivateOffer(java.lang.Boolean privateOffer) {
    this.privateOffer = privateOffer;
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
  public OfferDTO setStatus(java.lang.String status) {
    this.status = status;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getTerm() {
    return term;
  }

  /**
   * @param term term or {@code null} for none
   */
  public OfferDTO setTerm(java.lang.Integer term) {
    this.term = term;
    return this;
  }

  @Override
  public OfferDTO set(String fieldName, Object value) {
    return (OfferDTO) super.set(fieldName, value);
  }

  @Override
  public OfferDTO clone() {
    return (OfferDTO) super.clone();
  }

}
