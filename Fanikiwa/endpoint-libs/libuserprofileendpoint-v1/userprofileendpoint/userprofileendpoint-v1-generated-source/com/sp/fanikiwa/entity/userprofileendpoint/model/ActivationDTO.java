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
 * on 2015-07-04 at 07:55:27 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.userprofileendpoint.model;

/**
 * Model definition for ActivationDTO.
 *
 * <p>
 * This is the Java data model class that specifies how to parse/serialize into
 * the JSON that is transmitted over HTTP when working with the
 * userprofileendpoint. For a detailed explanation see: <a
 * href="http://code.google.com/p/google-http-java-client/wiki/JSON"
 * >http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class ActivationDTO extends com.google.api.client.json.GenericJson {

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime activatedDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String activationMethod;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String email;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String telno;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String token;

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getActivatedDate() {
		return activatedDate;
	}

	/**
	 * @param activatedDate
	 *            activatedDate or {@code null} for none
	 */
	public ActivationDTO setActivatedDate(
			com.google.api.client.util.DateTime activatedDate) {
		this.activatedDate = activatedDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getActivationMethod() {
		return activationMethod;
	}

	/**
	 * @param activationMethod
	 *            activationMethod or {@code null} for none
	 */
	public ActivationDTO setActivationMethod(java.lang.String activationMethod) {
		this.activationMethod = activationMethod;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            email or {@code null} for none
	 */
	public ActivationDTO setEmail(java.lang.String email) {
		this.email = email;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getTelno() {
		return telno;
	}

	/**
	 * @param telno
	 *            telno or {@code null} for none
	 */
	public ActivationDTO setTelno(java.lang.String telno) {
		this.telno = telno;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            token or {@code null} for none
	 */
	public ActivationDTO setToken(java.lang.String token) {
		this.token = token;
		return this;
	}

	@Override
	public ActivationDTO set(String fieldName, Object value) {
		return (ActivationDTO) super.set(fieldName, value);
	}

	@Override
	public ActivationDTO clone() {
		return (ActivationDTO) super.clone();
	}

}
