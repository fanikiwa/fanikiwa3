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
 * on 2015-04-13 at 07:06:25 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.lendinggroupmemberendpoint.model;

/**
 * Model definition for Lendinggroup.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the lendinggroupmemberendpoint. For a detailed
 * explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Lendinggroup extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime createdOn;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Member creator;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String groupName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private com.google.api.client.util.DateTime lastModified;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Lendinggroup parentGroup;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Lendinggroup parentGroupId;

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getCreatedOn() {
    return createdOn;
  }

  /**
   * @param createdOn createdOn or {@code null} for none
   */
  public Lendinggroup setCreatedOn(com.google.api.client.util.DateTime createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Member getCreator() {
    return creator;
  }

  /**
   * @param creator creator or {@code null} for none
   */
  public Lendinggroup setCreator(Member creator) {
    this.creator = creator;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getGroupName() {
    return groupName;
  }

  /**
   * @param groupName groupName or {@code null} for none
   */
  public Lendinggroup setGroupName(java.lang.String groupName) {
    this.groupName = groupName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public com.google.api.client.util.DateTime getLastModified() {
    return lastModified;
  }

  /**
   * @param lastModified lastModified or {@code null} for none
   */
  public Lendinggroup setLastModified(com.google.api.client.util.DateTime lastModified) {
    this.lastModified = lastModified;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Lendinggroup getParentGroup() {
    return parentGroup;
  }

  /**
   * @param parentGroup parentGroup or {@code null} for none
   */
  public Lendinggroup setParentGroup(Lendinggroup parentGroup) {
    this.parentGroup = parentGroup;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Lendinggroup getParentGroupId() {
    return parentGroupId;
  }

  /**
   * @param parentGroupId parentGroupId or {@code null} for none
   */
  public Lendinggroup setParentGroupId(Lendinggroup parentGroupId) {
    this.parentGroupId = parentGroupId;
    return this;
  }

  @Override
  public Lendinggroup set(String fieldName, Object value) {
    return (Lendinggroup) super.set(fieldName, value);
  }

  @Override
  public Lendinggroup clone() {
    return (Lendinggroup) super.clone();
  }

}
