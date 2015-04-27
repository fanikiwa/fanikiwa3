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
 * on 2015-04-26 at 12:50:52 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.accountendpoint.model;

/**
 * Model definition for StackTraceElement.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the accountendpoint. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class StackTraceElement extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String className;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String fileName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Integer lineNumber;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String methodName;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean nativeMethod;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getClassName() {
    return className;
  }

  /**
   * @param className className or {@code null} for none
   */
  public StackTraceElement setClassName(java.lang.String className) {
    this.className = className;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getFileName() {
    return fileName;
  }

  /**
   * @param fileName fileName or {@code null} for none
   */
  public StackTraceElement setFileName(java.lang.String fileName) {
    this.fileName = fileName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Integer getLineNumber() {
    return lineNumber;
  }

  /**
   * @param lineNumber lineNumber or {@code null} for none
   */
  public StackTraceElement setLineNumber(java.lang.Integer lineNumber) {
    this.lineNumber = lineNumber;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getMethodName() {
    return methodName;
  }

  /**
   * @param methodName methodName or {@code null} for none
   */
  public StackTraceElement setMethodName(java.lang.String methodName) {
    this.methodName = methodName;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getNativeMethod() {
    return nativeMethod;
  }

  /**
   * @param nativeMethod nativeMethod or {@code null} for none
   */
  public StackTraceElement setNativeMethod(java.lang.Boolean nativeMethod) {
    this.nativeMethod = nativeMethod;
    return this;
  }

  @Override
  public StackTraceElement set(String fieldName, Object value) {
    return (StackTraceElement) super.set(fieldName, value);
  }

  @Override
  public StackTraceElement clone() {
    return (StackTraceElement) super.clone();
  }

}
