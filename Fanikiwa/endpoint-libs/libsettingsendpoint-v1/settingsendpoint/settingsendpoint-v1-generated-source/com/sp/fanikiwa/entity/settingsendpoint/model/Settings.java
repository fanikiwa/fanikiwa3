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
 * on 2015-04-13 at 06:51:22 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.settingsendpoint.model;

/**
 * Model definition for Settings.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the settingsendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Settings extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String groupName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long parent;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String property;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String value;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getGroupName() {
    return groupName;
  }

  /**
   * @param groupName groupName or {@code null} for none
   */
  public Settings setGroupName(java.lang.String groupName) {
    this.groupName = groupName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getParent() {
    return parent;
  }

  /**
   * @param parent parent or {@code null} for none
   */
  public Settings setParent(java.lang.Long parent) {
    this.parent = parent;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getProperty() {
    return property;
  }

  /**
   * @param property property or {@code null} for none
   */
  public Settings setProperty(java.lang.String property) {
    this.property = property;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getValue() {
    return value;
  }

  /**
   * @param value value or {@code null} for none
   */
  public Settings setValue(java.lang.String value) {
    this.value = value;
    return this;
  }

  @Override
  public Settings set(String fieldName, Object value) {
    return (Settings) super.set(fieldName, value);
  }

  @Override
  public Settings clone() {
    return (Settings) super.clone();
  }

}
