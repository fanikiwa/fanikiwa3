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
 * on 2015-07-04 at 07:54:03 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.contactendpoint.model;

/**
 * Model definition for RequestResult.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the contactendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class RequestResult extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Object clientToken;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long id;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String resultMessage;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean success;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Object getClientToken() {
    return clientToken;
  }

  /**
   * @param clientToken clientToken or {@code null} for none
   */
  public RequestResult setClientToken(java.lang.Object clientToken) {
    this.clientToken = clientToken;
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
  public RequestResult setId(java.lang.Long id) {
    this.id = id;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getResultMessage() {
    return resultMessage;
  }

  /**
   * @param resultMessage resultMessage or {@code null} for none
   */
  public RequestResult setResultMessage(java.lang.String resultMessage) {
    this.resultMessage = resultMessage;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getSuccess() {
    return success;
  }

  /**
   * @param success success or {@code null} for none
   */
  public RequestResult setSuccess(java.lang.Boolean success) {
    this.success = success;
    return this;
  }

  @Override
  public RequestResult set(String fieldName, Object value) {
    return (RequestResult) super.set(fieldName, value);
  }

  @Override
  public RequestResult clone() {
    return (RequestResult) super.clone();
  }

}
