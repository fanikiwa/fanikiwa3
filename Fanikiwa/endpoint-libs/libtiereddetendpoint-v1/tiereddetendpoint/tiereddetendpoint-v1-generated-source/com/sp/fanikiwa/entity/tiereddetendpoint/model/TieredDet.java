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
 * on 2015-04-13 at 07:04:46 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.tiereddetendpoint.model;

/**
 * Model definition for TieredDet.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the tiereddetendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class TieredDet extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer absolute;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double max;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double min;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Double rate;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long tieredID;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getAbsolute() {
    return absolute;
  }

  /**
   * @param absolute absolute or {@code null} for none
   */
  public TieredDet setAbsolute(java.lang.Integer absolute) {
    this.absolute = absolute;
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
  public TieredDet setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getMax() {
    return max;
  }

  /**
   * @param max max or {@code null} for none
   */
  public TieredDet setMax(java.lang.Double max) {
    this.max = max;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getMin() {
    return min;
  }

  /**
   * @param min min or {@code null} for none
   */
  public TieredDet setMin(java.lang.Double min) {
    this.min = min;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Double getRate() {
    return rate;
  }

  /**
   * @param rate rate or {@code null} for none
   */
  public TieredDet setRate(java.lang.Double rate) {
    this.rate = rate;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getTieredID() {
    return tieredID;
  }

  /**
   * @param tieredID tieredID or {@code null} for none
   */
  public TieredDet setTieredID(java.lang.Long tieredID) {
    this.tieredID = tieredID;
    return this;
  }

  @Override
  public TieredDet set(String fieldName, Object value) {
    return (TieredDet) super.set(fieldName, value);
  }

  @Override
  public TieredDet clone() {
    return (TieredDet) super.clone();
  }

}
