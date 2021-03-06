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
 * Model definition for Userprofile.
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
public final class Userprofile extends com.google.api.client.json.GenericJson {

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
	private com.google.api.client.util.DateTime activationTokenExpiryDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime createDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime expiryDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private com.google.api.client.util.DateTime lastLoginDate;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String pwd;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String role;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String status;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String telephone;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String token;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String userId;

	/**
	 * The value may be {@code null}.
	 */
	@com.google.api.client.util.Key
	private java.lang.String userType;

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
	public Userprofile setActivatedDate(
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
	public Userprofile setActivationMethod(java.lang.String activationMethod) {
		this.activationMethod = activationMethod;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getActivationTokenExpiryDate() {
		return activationTokenExpiryDate;
	}

	/**
	 * @param activationTokenExpiryDate
	 *            activationTokenExpiryDate or {@code null} for none
	 */
	public Userprofile setActivationTokenExpiryDate(
			com.google.api.client.util.DateTime activationTokenExpiryDate) {
		this.activationTokenExpiryDate = activationTokenExpiryDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            createDate or {@code null} for none
	 */
	public Userprofile setCreateDate(
			com.google.api.client.util.DateTime createDate) {
		this.createDate = createDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getExpiryDate() {
		return expiryDate;
	}

	/**
	 * @param expiryDate
	 *            expiryDate or {@code null} for none
	 */
	public Userprofile setExpiryDate(
			com.google.api.client.util.DateTime expiryDate) {
		this.expiryDate = expiryDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public com.google.api.client.util.DateTime getLastLoginDate() {
		return lastLoginDate;
	}

	/**
	 * @param lastLoginDate
	 *            lastLoginDate or {@code null} for none
	 */
	public Userprofile setLastLoginDate(
			com.google.api.client.util.DateTime lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd
	 *            pwd or {@code null} for none
	 */
	public Userprofile setPwd(java.lang.String pwd) {
		this.pwd = pwd;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getRole() {
		return role;
	}

	/**
	 * @param role
	 *            role or {@code null} for none
	 */
	public Userprofile setRole(java.lang.String role) {
		this.role = role;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            status or {@code null} for none
	 */
	public Userprofile setStatus(java.lang.String status) {
		this.status = status;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            telephone or {@code null} for none
	 */
	public Userprofile setTelephone(java.lang.String telephone) {
		this.telephone = telephone;
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
	public Userprofile setToken(java.lang.String token) {
		this.token = token;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            userId or {@code null} for none
	 */
	public Userprofile setUserId(java.lang.String userId) {
		this.userId = userId;
		return this;
	}

	/**
	 * @return value or {@code null} for none
	 */
	public java.lang.String getUserType() {
		return userType;
	}

	/**
	 * @param userType
	 *            userType or {@code null} for none
	 */
	public Userprofile setUserType(java.lang.String userType) {
		this.userType = userType;
		return this;
	}

	@Override
	public Userprofile set(String fieldName, Object value) {
		return (Userprofile) super.set(fieldName, value);
	}

	@Override
	public Userprofile clone() {
		return (Userprofile) super.clone();
	}

}
