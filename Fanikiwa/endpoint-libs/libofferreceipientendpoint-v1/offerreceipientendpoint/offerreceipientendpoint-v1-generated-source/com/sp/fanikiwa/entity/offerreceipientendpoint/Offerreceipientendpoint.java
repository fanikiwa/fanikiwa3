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
 * on 2015-04-26 at 13:12:10 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.offerreceipientendpoint;

/**
 * Service definition for Offerreceipientendpoint (v1).
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
 * This service uses {@link OfferreceipientendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Offerreceipientendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the offerreceipientendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "offerreceipientendpoint/v1/";

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
  public Offerreceipientendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Offerreceipientendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getOfferReceipient".
   *
   * This request holds the parameters needed by the offerreceipientendpoint server.  After setting
   * any optional parameters, call the {@link GetOfferReceipient#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public GetOfferReceipient getOfferReceipient(java.lang.Long id) throws java.io.IOException {
    GetOfferReceipient result = new GetOfferReceipient(id);
    initialize(result);
    return result;
  }

  public class GetOfferReceipient extends OfferreceipientendpointRequest<com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient> {

    private static final String REST_PATH = "offerreceipient/{id}";

    /**
     * Create a request for the method "getOfferReceipient".
     *
     * This request holds the parameters needed by the the offerreceipientendpoint server.  After
     * setting any optional parameters, call the {@link GetOfferReceipient#execute()} method to invoke
     * the remote operation. <p> {@link GetOfferReceipient#initialize(com.google.api.client.googleapis
     * .services.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetOfferReceipient(java.lang.Long id) {
      super(Offerreceipientendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient.class);
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
    public GetOfferReceipient setAlt(java.lang.String alt) {
      return (GetOfferReceipient) super.setAlt(alt);
    }

    @Override
    public GetOfferReceipient setFields(java.lang.String fields) {
      return (GetOfferReceipient) super.setFields(fields);
    }

    @Override
    public GetOfferReceipient setKey(java.lang.String key) {
      return (GetOfferReceipient) super.setKey(key);
    }

    @Override
    public GetOfferReceipient setOauthToken(java.lang.String oauthToken) {
      return (GetOfferReceipient) super.setOauthToken(oauthToken);
    }

    @Override
    public GetOfferReceipient setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetOfferReceipient) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetOfferReceipient setQuotaUser(java.lang.String quotaUser) {
      return (GetOfferReceipient) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetOfferReceipient setUserIp(java.lang.String userIp) {
      return (GetOfferReceipient) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetOfferReceipient setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetOfferReceipient set(String parameterName, Object value) {
      return (GetOfferReceipient) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertOfferReceipient".
   *
   * This request holds the parameters needed by the offerreceipientendpoint server.  After setting
   * any optional parameters, call the {@link InsertOfferReceipient#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient}
   * @return the request
   */
  public InsertOfferReceipient insertOfferReceipient(com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient content) throws java.io.IOException {
    InsertOfferReceipient result = new InsertOfferReceipient(content);
    initialize(result);
    return result;
  }

  public class InsertOfferReceipient extends OfferreceipientendpointRequest<com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient> {

    private static final String REST_PATH = "offerreceipient";

    /**
     * Create a request for the method "insertOfferReceipient".
     *
     * This request holds the parameters needed by the the offerreceipientendpoint server.  After
     * setting any optional parameters, call the {@link InsertOfferReceipient#execute()} method to
     * invoke the remote operation. <p> {@link InsertOfferReceipient#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient}
     * @since 1.13
     */
    protected InsertOfferReceipient(com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient content) {
      super(Offerreceipientendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient.class);
    }

    @Override
    public InsertOfferReceipient setAlt(java.lang.String alt) {
      return (InsertOfferReceipient) super.setAlt(alt);
    }

    @Override
    public InsertOfferReceipient setFields(java.lang.String fields) {
      return (InsertOfferReceipient) super.setFields(fields);
    }

    @Override
    public InsertOfferReceipient setKey(java.lang.String key) {
      return (InsertOfferReceipient) super.setKey(key);
    }

    @Override
    public InsertOfferReceipient setOauthToken(java.lang.String oauthToken) {
      return (InsertOfferReceipient) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertOfferReceipient setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertOfferReceipient) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertOfferReceipient setQuotaUser(java.lang.String quotaUser) {
      return (InsertOfferReceipient) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertOfferReceipient setUserIp(java.lang.String userIp) {
      return (InsertOfferReceipient) super.setUserIp(userIp);
    }

    @Override
    public InsertOfferReceipient set(String parameterName, Object value) {
      return (InsertOfferReceipient) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "isOfferAvaiable".
   *
   * This request holds the parameters needed by the offerreceipientendpoint server.  After setting
   * any optional parameters, call the {@link IsOfferAvaiable#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient}
   * @return the request
   */
  public IsOfferAvaiable isOfferAvaiable(com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient content) throws java.io.IOException {
    IsOfferAvaiable result = new IsOfferAvaiable(content);
    initialize(result);
    return result;
  }

  public class IsOfferAvaiable extends OfferreceipientendpointRequest<com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient> {

    private static final String REST_PATH = "isOfferAvaiable";

    /**
     * Create a request for the method "isOfferAvaiable".
     *
     * This request holds the parameters needed by the the offerreceipientendpoint server.  After
     * setting any optional parameters, call the {@link IsOfferAvaiable#execute()} method to invoke
     * the remote operation. <p> {@link IsOfferAvaiable#initialize(com.google.api.client.googleapis.se
     * rvices.AbstractGoogleClientRequest)} must be called to initialize this instance immediately
     * after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient}
     * @since 1.13
     */
    protected IsOfferAvaiable(com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient content) {
      super(Offerreceipientendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient.class);
    }

    @Override
    public IsOfferAvaiable setAlt(java.lang.String alt) {
      return (IsOfferAvaiable) super.setAlt(alt);
    }

    @Override
    public IsOfferAvaiable setFields(java.lang.String fields) {
      return (IsOfferAvaiable) super.setFields(fields);
    }

    @Override
    public IsOfferAvaiable setKey(java.lang.String key) {
      return (IsOfferAvaiable) super.setKey(key);
    }

    @Override
    public IsOfferAvaiable setOauthToken(java.lang.String oauthToken) {
      return (IsOfferAvaiable) super.setOauthToken(oauthToken);
    }

    @Override
    public IsOfferAvaiable setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (IsOfferAvaiable) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public IsOfferAvaiable setQuotaUser(java.lang.String quotaUser) {
      return (IsOfferAvaiable) super.setQuotaUser(quotaUser);
    }

    @Override
    public IsOfferAvaiable setUserIp(java.lang.String userIp) {
      return (IsOfferAvaiable) super.setUserIp(userIp);
    }

    @Override
    public IsOfferAvaiable set(String parameterName, Object value) {
      return (IsOfferAvaiable) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listOfferReceipient".
   *
   * This request holds the parameters needed by the offerreceipientendpoint server.  After setting
   * any optional parameters, call the {@link ListOfferReceipient#execute()} method to invoke the
   * remote operation.
   *
   * @return the request
   */
  public ListOfferReceipient listOfferReceipient() throws java.io.IOException {
    ListOfferReceipient result = new ListOfferReceipient();
    initialize(result);
    return result;
  }

  public class ListOfferReceipient extends OfferreceipientendpointRequest<com.sp.fanikiwa.entity.offerreceipientendpoint.model.CollectionResponseOfferReceipient> {

    private static final String REST_PATH = "offerreceipient";

    /**
     * Create a request for the method "listOfferReceipient".
     *
     * This request holds the parameters needed by the the offerreceipientendpoint server.  After
     * setting any optional parameters, call the {@link ListOfferReceipient#execute()} method to
     * invoke the remote operation. <p> {@link ListOfferReceipient#initialize(com.google.api.client.go
     * ogleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListOfferReceipient() {
      super(Offerreceipientendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.offerreceipientendpoint.model.CollectionResponseOfferReceipient.class);
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
    public ListOfferReceipient setAlt(java.lang.String alt) {
      return (ListOfferReceipient) super.setAlt(alt);
    }

    @Override
    public ListOfferReceipient setFields(java.lang.String fields) {
      return (ListOfferReceipient) super.setFields(fields);
    }

    @Override
    public ListOfferReceipient setKey(java.lang.String key) {
      return (ListOfferReceipient) super.setKey(key);
    }

    @Override
    public ListOfferReceipient setOauthToken(java.lang.String oauthToken) {
      return (ListOfferReceipient) super.setOauthToken(oauthToken);
    }

    @Override
    public ListOfferReceipient setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListOfferReceipient) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListOfferReceipient setQuotaUser(java.lang.String quotaUser) {
      return (ListOfferReceipient) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListOfferReceipient setUserIp(java.lang.String userIp) {
      return (ListOfferReceipient) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListOfferReceipient setCount(java.lang.Integer count) {
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

    public ListOfferReceipient setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListOfferReceipient set(String parameterName, Object value) {
      return (ListOfferReceipient) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeOfferReceipient".
   *
   * This request holds the parameters needed by the offerreceipientendpoint server.  After setting
   * any optional parameters, call the {@link RemoveOfferReceipient#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveOfferReceipient removeOfferReceipient(java.lang.Long id) throws java.io.IOException {
    RemoveOfferReceipient result = new RemoveOfferReceipient(id);
    initialize(result);
    return result;
  }

  public class RemoveOfferReceipient extends OfferreceipientendpointRequest<Void> {

    private static final String REST_PATH = "offerreceipient/{id}";

    /**
     * Create a request for the method "removeOfferReceipient".
     *
     * This request holds the parameters needed by the the offerreceipientendpoint server.  After
     * setting any optional parameters, call the {@link RemoveOfferReceipient#execute()} method to
     * invoke the remote operation. <p> {@link RemoveOfferReceipient#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveOfferReceipient(java.lang.Long id) {
      super(Offerreceipientendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveOfferReceipient setAlt(java.lang.String alt) {
      return (RemoveOfferReceipient) super.setAlt(alt);
    }

    @Override
    public RemoveOfferReceipient setFields(java.lang.String fields) {
      return (RemoveOfferReceipient) super.setFields(fields);
    }

    @Override
    public RemoveOfferReceipient setKey(java.lang.String key) {
      return (RemoveOfferReceipient) super.setKey(key);
    }

    @Override
    public RemoveOfferReceipient setOauthToken(java.lang.String oauthToken) {
      return (RemoveOfferReceipient) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveOfferReceipient setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveOfferReceipient) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveOfferReceipient setQuotaUser(java.lang.String quotaUser) {
      return (RemoveOfferReceipient) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveOfferReceipient setUserIp(java.lang.String userIp) {
      return (RemoveOfferReceipient) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveOfferReceipient setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveOfferReceipient set(String parameterName, Object value) {
      return (RemoveOfferReceipient) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateOfferReceipient".
   *
   * This request holds the parameters needed by the offerreceipientendpoint server.  After setting
   * any optional parameters, call the {@link UpdateOfferReceipient#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient}
   * @return the request
   */
  public UpdateOfferReceipient updateOfferReceipient(com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient content) throws java.io.IOException {
    UpdateOfferReceipient result = new UpdateOfferReceipient(content);
    initialize(result);
    return result;
  }

  public class UpdateOfferReceipient extends OfferreceipientendpointRequest<com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient> {

    private static final String REST_PATH = "offerreceipient";

    /**
     * Create a request for the method "updateOfferReceipient".
     *
     * This request holds the parameters needed by the the offerreceipientendpoint server.  After
     * setting any optional parameters, call the {@link UpdateOfferReceipient#execute()} method to
     * invoke the remote operation. <p> {@link UpdateOfferReceipient#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient}
     * @since 1.13
     */
    protected UpdateOfferReceipient(com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient content) {
      super(Offerreceipientendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.offerreceipientendpoint.model.OfferReceipient.class);
    }

    @Override
    public UpdateOfferReceipient setAlt(java.lang.String alt) {
      return (UpdateOfferReceipient) super.setAlt(alt);
    }

    @Override
    public UpdateOfferReceipient setFields(java.lang.String fields) {
      return (UpdateOfferReceipient) super.setFields(fields);
    }

    @Override
    public UpdateOfferReceipient setKey(java.lang.String key) {
      return (UpdateOfferReceipient) super.setKey(key);
    }

    @Override
    public UpdateOfferReceipient setOauthToken(java.lang.String oauthToken) {
      return (UpdateOfferReceipient) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateOfferReceipient setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateOfferReceipient) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateOfferReceipient setQuotaUser(java.lang.String quotaUser) {
      return (UpdateOfferReceipient) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateOfferReceipient setUserIp(java.lang.String userIp) {
      return (UpdateOfferReceipient) super.setUserIp(userIp);
    }

    @Override
    public UpdateOfferReceipient set(String parameterName, Object value) {
      return (UpdateOfferReceipient) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Offerreceipientendpoint}.
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

    /** Builds a new instance of {@link Offerreceipientendpoint}. */
    @Override
    public Offerreceipientendpoint build() {
      return new Offerreceipientendpoint(this);
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
     * Set the {@link OfferreceipientendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setOfferreceipientendpointRequestInitializer(
        OfferreceipientendpointRequestInitializer offerreceipientendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(offerreceipientendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}