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
 * on 2015-05-16 at 12:17:02 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.accountendpoint.model;

/**
 * Model definition for DoubleEntry.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the accountendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class DoubleEntry extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Transaction cr;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Transaction dr;

  /**
   * @return value or {@code null} for none
   */
  public Transaction getCr() {
    return cr;
  }

  /**
   * @param cr cr or {@code null} for none
   */
  public DoubleEntry setCr(Transaction cr) {
    this.cr = cr;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Transaction getDr() {
    return dr;
  }

  /**
   * @param dr dr or {@code null} for none
   */
  public DoubleEntry setDr(Transaction dr) {
    this.dr = dr;
    return this;
  }

  @Override
  public DoubleEntry set(String fieldName, Object value) {
    return (DoubleEntry) super.set(fieldName, value);
  }

  @Override
  public DoubleEntry clone() {
    return (DoubleEntry) super.clone();
  }

}
