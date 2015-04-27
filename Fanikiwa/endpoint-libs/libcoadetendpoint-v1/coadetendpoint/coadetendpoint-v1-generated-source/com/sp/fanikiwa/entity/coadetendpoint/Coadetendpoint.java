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
 * on 2015-04-26 at 13:02:13 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.coadetendpoint;

/**
 * Service definition for Coadetendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link CoadetendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Coadetendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the coadetendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://fanikiwaweb.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "coadetendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Coadetendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Coadetendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getCoadetByID".
   *
   * This request holds the parameters needed by the coadetendpoint server.  After setting any
   * optional parameters, call the {@link GetCoadetByID#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetCoadetByID getCoadetByID(java.lang.Long id) throws java.io.IOException {
    GetCoadetByID result = new GetCoadetByID(id);
    initialize(result);
    return result;
  }

  public class GetCoadetByID extends CoadetendpointRequest<com.sp.fanikiwa.entity.coadetendpoint.model.Coadet> {

    private static final String REST_PATH = "coadet/{id}";

    /**
     * Create a request for the method "getCoadetByID".
     *
     * This request holds the parameters needed by the the coadetendpoint server.  After setting any
     * optional parameters, call the {@link GetCoadetByID#execute()} method to invoke the remote
     * operation. <p> {@link GetCoadetByID#initialize(com.google.api.client.googleapis.services.Abstra
     * ctGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetCoadetByID(java.lang.Long id) {
      super(Coadetendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.coadetendpoint.model.Coadet.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetCoadetByID setAlt(java.lang.String alt) {
      return (GetCoadetByID) super.setAlt(alt);
    }

    @Override
    public GetCoadetByID setFields(java.lang.String fields) {
      return (GetCoadetByID) super.setFields(fields);
    }

    @Override
    public GetCoadetByID setKey(java.lang.String key) {
      return (GetCoadetByID) super.setKey(key);
    }

    @Override
    public GetCoadetByID setOauthToken(java.lang.String oauthToken) {
      return (GetCoadetByID) super.setOauthToken(oauthToken);
    }

    @Override
    public GetCoadetByID setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetCoadetByID) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetCoadetByID setQuotaUser(java.lang.String quotaUser) {
      return (GetCoadetByID) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetCoadetByID setUserIp(java.lang.String userIp) {
      return (GetCoadetByID) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetCoadetByID setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetCoadetByID set(String parameterName, Object value) {
      return (GetCoadetByID) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertCoadet".
   *
   * This request holds the parameters needed by the coadetendpoint server.  After setting any
   * optional parameters, call the {@link InsertCoadet#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.coadetendpoint.model.Coadet}
   * @return the request
   */
  public InsertCoadet insertCoadet(com.sp.fanikiwa.entity.coadetendpoint.model.Coadet content) throws java.io.IOException {
    InsertCoadet result = new InsertCoadet(content);
    initialize(result);
    return result;
  }

  public class InsertCoadet extends CoadetendpointRequest<com.sp.fanikiwa.entity.coadetendpoint.model.Coadet> {

    private static final String REST_PATH = "coadet";

    /**
     * Create a request for the method "insertCoadet".
     *
     * This request holds the parameters needed by the the coadetendpoint server.  After setting any
     * optional parameters, call the {@link InsertCoadet#execute()} method to invoke the remote
     * operation. <p> {@link
     * InsertCoadet#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.coadetendpoint.model.Coadet}
     * @since 1.13
     */
    protected InsertCoadet(com.sp.fanikiwa.entity.coadetendpoint.model.Coadet content) {
      super(Coadetendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.coadetendpoint.model.Coadet.class);
    }

    @Override
    public InsertCoadet setAlt(java.lang.String alt) {
      return (InsertCoadet) super.setAlt(alt);
    }

    @Override
    public InsertCoadet setFields(java.lang.String fields) {
      return (InsertCoadet) super.setFields(fields);
    }

    @Override
    public InsertCoadet setKey(java.lang.String key) {
      return (InsertCoadet) super.setKey(key);
    }

    @Override
    public InsertCoadet setOauthToken(java.lang.String oauthToken) {
      return (InsertCoadet) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertCoadet setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertCoadet) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertCoadet setQuotaUser(java.lang.String quotaUser) {
      return (InsertCoadet) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertCoadet setUserIp(java.lang.String userIp) {
      return (InsertCoadet) super.setUserIp(userIp);
    }

    @Override
    public InsertCoadet set(String parameterName, Object value) {
      return (InsertCoadet) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listCoadet".
   *
   * This request holds the parameters needed by the coadetendpoint server.  After setting any
   * optional parameters, call the {@link ListCoadet#execute()} method to invoke the remote operation.
   *
   * @return the request
   */
  public ListCoadet listCoadet() throws java.io.IOException {
    ListCoadet result = new ListCoadet();
    initialize(result);
    return result;
  }

  public class ListCoadet extends CoadetendpointRequest<com.sp.fanikiwa.entity.coadetendpoint.model.CollectionResponseCoadet> {

    private static final String REST_PATH = "coadet";

    /**
     * Create a request for the method "listCoadet".
     *
     * This request holds the parameters needed by the the coadetendpoint server.  After setting any
     * optional parameters, call the {@link ListCoadet#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListCoadet#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListCoadet() {
      super(Coadetendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.coadetendpoint.model.CollectionResponseCoadet.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListCoadet setAlt(java.lang.String alt) {
      return (ListCoadet) super.setAlt(alt);
    }

    @Override
    public ListCoadet setFields(java.lang.String fields) {
      return (ListCoadet) super.setFields(fields);
    }

    @Override
    public ListCoadet setKey(java.lang.String key) {
      return (ListCoadet) super.setKey(key);
    }

    @Override
    public ListCoadet setOauthToken(java.lang.String oauthToken) {
      return (ListCoadet) super.setOauthToken(oauthToken);
    }

    @Override
    public ListCoadet setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListCoadet) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListCoadet setQuotaUser(java.lang.String quotaUser) {
      return (ListCoadet) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListCoadet setUserIp(java.lang.String userIp) {
      return (ListCoadet) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListCoadet setCount(java.lang.Integer count) {
      this.count = count;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListCoadet setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListCoadet set(String parameterName, Object value) {
      return (ListCoadet) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeCoadet".
   *
   * This request holds the parameters needed by the coadetendpoint server.  After setting any
   * optional parameters, call the {@link RemoveCoadet#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveCoadet removeCoadet(java.lang.Long id) throws java.io.IOException {
    RemoveCoadet result = new RemoveCoadet(id);
    initialize(result);
    return result;
  }

  public class RemoveCoadet extends CoadetendpointRequest<Void> {

    private static final String REST_PATH = "coadet/{id}";

    /**
     * Create a request for the method "removeCoadet".
     *
     * This request holds the parameters needed by the the coadetendpoint server.  After setting any
     * optional parameters, call the {@link RemoveCoadet#execute()} method to invoke the remote
     * operation. <p> {@link
     * RemoveCoadet#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveCoadet(java.lang.Long id) {
      super(Coadetendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveCoadet setAlt(java.lang.String alt) {
      return (RemoveCoadet) super.setAlt(alt);
    }

    @Override
    public RemoveCoadet setFields(java.lang.String fields) {
      return (RemoveCoadet) super.setFields(fields);
    }

    @Override
    public RemoveCoadet setKey(java.lang.String key) {
      return (RemoveCoadet) super.setKey(key);
    }

    @Override
    public RemoveCoadet setOauthToken(java.lang.String oauthToken) {
      return (RemoveCoadet) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveCoadet setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveCoadet) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveCoadet setQuotaUser(java.lang.String quotaUser) {
      return (RemoveCoadet) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveCoadet setUserIp(java.lang.String userIp) {
      return (RemoveCoadet) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveCoadet setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveCoadet set(String parameterName, Object value) {
      return (RemoveCoadet) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateCoadet".
   *
   * This request holds the parameters needed by the coadetendpoint server.  After setting any
   * optional parameters, call the {@link UpdateCoadet#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.coadetendpoint.model.Coadet}
   * @return the request
   */
  public UpdateCoadet updateCoadet(com.sp.fanikiwa.entity.coadetendpoint.model.Coadet content) throws java.io.IOException {
    UpdateCoadet result = new UpdateCoadet(content);
    initialize(result);
    return result;
  }

  public class UpdateCoadet extends CoadetendpointRequest<com.sp.fanikiwa.entity.coadetendpoint.model.Coadet> {

    private static final String REST_PATH = "coadet";

    /**
     * Create a request for the method "updateCoadet".
     *
     * This request holds the parameters needed by the the coadetendpoint server.  After setting any
     * optional parameters, call the {@link UpdateCoadet#execute()} method to invoke the remote
     * operation. <p> {@link
     * UpdateCoadet#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.coadetendpoint.model.Coadet}
     * @since 1.13
     */
    protected UpdateCoadet(com.sp.fanikiwa.entity.coadetendpoint.model.Coadet content) {
      super(Coadetendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.coadetendpoint.model.Coadet.class);
    }

    @Override
    public UpdateCoadet setAlt(java.lang.String alt) {
      return (UpdateCoadet) super.setAlt(alt);
    }

    @Override
    public UpdateCoadet setFields(java.lang.String fields) {
      return (UpdateCoadet) super.setFields(fields);
    }

    @Override
    public UpdateCoadet setKey(java.lang.String key) {
      return (UpdateCoadet) super.setKey(key);
    }

    @Override
    public UpdateCoadet setOauthToken(java.lang.String oauthToken) {
      return (UpdateCoadet) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateCoadet setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateCoadet) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateCoadet setQuotaUser(java.lang.String quotaUser) {
      return (UpdateCoadet) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateCoadet setUserIp(java.lang.String userIp) {
      return (UpdateCoadet) super.setUserIp(userIp);
    }

    @Override
    public UpdateCoadet set(String parameterName, Object value) {
      return (UpdateCoadet) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Coadetendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Coadetendpoint}. */
    @Override
    public Coadetendpoint build() {
      return new Coadetendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link CoadetendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setCoadetendpointRequestInitializer(
        CoadetendpointRequestInitializer coadetendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(coadetendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
