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
 * (build: 2015-08-03 17:34:38 UTC)
 * on 2015-08-30 at 12:36:05 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.withdrawalmessageendpoint;

/**
 * Service definition for Withdrawalmessageendpoint (v1).
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
 * This service uses {@link WithdrawalmessageendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Withdrawalmessageendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the withdrawalmessageendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "withdrawalmessageendpoint/v1/";

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
  public Withdrawalmessageendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Withdrawalmessageendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getWithdrawalMessage".
   *
   * This request holds the parameters needed by the withdrawalmessageendpoint server.  After setting
   * any optional parameters, call the {@link GetWithdrawalMessage#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public GetWithdrawalMessage getWithdrawalMessage(java.lang.Long id) throws java.io.IOException {
    GetWithdrawalMessage result = new GetWithdrawalMessage(id);
    initialize(result);
    return result;
  }

  public class GetWithdrawalMessage extends WithdrawalmessageendpointRequest<com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage> {

    private static final String REST_PATH = "withdrawalmessage/{id}";

    /**
     * Create a request for the method "getWithdrawalMessage".
     *
     * This request holds the parameters needed by the the withdrawalmessageendpoint server.  After
     * setting any optional parameters, call the {@link GetWithdrawalMessage#execute()} method to
     * invoke the remote operation. <p> {@link GetWithdrawalMessage#initialize(com.google.api.client.g
     * oogleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetWithdrawalMessage(java.lang.Long id) {
      super(Withdrawalmessageendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage.class);
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
    public GetWithdrawalMessage setAlt(java.lang.String alt) {
      return (GetWithdrawalMessage) super.setAlt(alt);
    }

    @Override
    public GetWithdrawalMessage setFields(java.lang.String fields) {
      return (GetWithdrawalMessage) super.setFields(fields);
    }

    @Override
    public GetWithdrawalMessage setKey(java.lang.String key) {
      return (GetWithdrawalMessage) super.setKey(key);
    }

    @Override
    public GetWithdrawalMessage setOauthToken(java.lang.String oauthToken) {
      return (GetWithdrawalMessage) super.setOauthToken(oauthToken);
    }

    @Override
    public GetWithdrawalMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetWithdrawalMessage) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetWithdrawalMessage setQuotaUser(java.lang.String quotaUser) {
      return (GetWithdrawalMessage) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetWithdrawalMessage setUserIp(java.lang.String userIp) {
      return (GetWithdrawalMessage) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetWithdrawalMessage setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetWithdrawalMessage set(String parameterName, Object value) {
      return (GetWithdrawalMessage) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertWithdrawalMessage".
   *
   * This request holds the parameters needed by the withdrawalmessageendpoint server.  After setting
   * any optional parameters, call the {@link InsertWithdrawalMessage#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage}
   * @return the request
   */
  public InsertWithdrawalMessage insertWithdrawalMessage(com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage content) throws java.io.IOException {
    InsertWithdrawalMessage result = new InsertWithdrawalMessage(content);
    initialize(result);
    return result;
  }

  public class InsertWithdrawalMessage extends WithdrawalmessageendpointRequest<com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage> {

    private static final String REST_PATH = "withdrawalmessage";

    /**
     * Create a request for the method "insertWithdrawalMessage".
     *
     * This request holds the parameters needed by the the withdrawalmessageendpoint server.  After
     * setting any optional parameters, call the {@link InsertWithdrawalMessage#execute()} method to
     * invoke the remote operation. <p> {@link InsertWithdrawalMessage#initialize(com.google.api.clien
     * t.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage}
     * @since 1.13
     */
    protected InsertWithdrawalMessage(com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage content) {
      super(Withdrawalmessageendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage.class);
    }

    @Override
    public InsertWithdrawalMessage setAlt(java.lang.String alt) {
      return (InsertWithdrawalMessage) super.setAlt(alt);
    }

    @Override
    public InsertWithdrawalMessage setFields(java.lang.String fields) {
      return (InsertWithdrawalMessage) super.setFields(fields);
    }

    @Override
    public InsertWithdrawalMessage setKey(java.lang.String key) {
      return (InsertWithdrawalMessage) super.setKey(key);
    }

    @Override
    public InsertWithdrawalMessage setOauthToken(java.lang.String oauthToken) {
      return (InsertWithdrawalMessage) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertWithdrawalMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertWithdrawalMessage) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertWithdrawalMessage setQuotaUser(java.lang.String quotaUser) {
      return (InsertWithdrawalMessage) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertWithdrawalMessage setUserIp(java.lang.String userIp) {
      return (InsertWithdrawalMessage) super.setUserIp(userIp);
    }

    @Override
    public InsertWithdrawalMessage set(String parameterName, Object value) {
      return (InsertWithdrawalMessage) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listWithdrawalMessage".
   *
   * This request holds the parameters needed by the withdrawalmessageendpoint server.  After setting
   * any optional parameters, call the {@link ListWithdrawalMessage#execute()} method to invoke the
   * remote operation.
   *
   * @return the request
   */
  public ListWithdrawalMessage listWithdrawalMessage() throws java.io.IOException {
    ListWithdrawalMessage result = new ListWithdrawalMessage();
    initialize(result);
    return result;
  }

  public class ListWithdrawalMessage extends WithdrawalmessageendpointRequest<com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.CollectionResponseWithdrawalMessage> {

    private static final String REST_PATH = "withdrawalmessage";

    /**
     * Create a request for the method "listWithdrawalMessage".
     *
     * This request holds the parameters needed by the the withdrawalmessageendpoint server.  After
     * setting any optional parameters, call the {@link ListWithdrawalMessage#execute()} method to
     * invoke the remote operation. <p> {@link ListWithdrawalMessage#initialize(com.google.api.client.
     * googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListWithdrawalMessage() {
      super(Withdrawalmessageendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.CollectionResponseWithdrawalMessage.class);
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
    public ListWithdrawalMessage setAlt(java.lang.String alt) {
      return (ListWithdrawalMessage) super.setAlt(alt);
    }

    @Override
    public ListWithdrawalMessage setFields(java.lang.String fields) {
      return (ListWithdrawalMessage) super.setFields(fields);
    }

    @Override
    public ListWithdrawalMessage setKey(java.lang.String key) {
      return (ListWithdrawalMessage) super.setKey(key);
    }

    @Override
    public ListWithdrawalMessage setOauthToken(java.lang.String oauthToken) {
      return (ListWithdrawalMessage) super.setOauthToken(oauthToken);
    }

    @Override
    public ListWithdrawalMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListWithdrawalMessage) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListWithdrawalMessage setQuotaUser(java.lang.String quotaUser) {
      return (ListWithdrawalMessage) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListWithdrawalMessage setUserIp(java.lang.String userIp) {
      return (ListWithdrawalMessage) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListWithdrawalMessage setCount(java.lang.Integer count) {
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

    public ListWithdrawalMessage setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListWithdrawalMessage set(String parameterName, Object value) {
      return (ListWithdrawalMessage) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeWithdrawalMessage".
   *
   * This request holds the parameters needed by the withdrawalmessageendpoint server.  After setting
   * any optional parameters, call the {@link RemoveWithdrawalMessage#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveWithdrawalMessage removeWithdrawalMessage(java.lang.Long id) throws java.io.IOException {
    RemoveWithdrawalMessage result = new RemoveWithdrawalMessage(id);
    initialize(result);
    return result;
  }

  public class RemoveWithdrawalMessage extends WithdrawalmessageendpointRequest<com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.RequestResult> {

    private static final String REST_PATH = "withdrawalmessage/{id}";

    /**
     * Create a request for the method "removeWithdrawalMessage".
     *
     * This request holds the parameters needed by the the withdrawalmessageendpoint server.  After
     * setting any optional parameters, call the {@link RemoveWithdrawalMessage#execute()} method to
     * invoke the remote operation. <p> {@link RemoveWithdrawalMessage#initialize(com.google.api.clien
     * t.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveWithdrawalMessage(java.lang.Long id) {
      super(Withdrawalmessageendpoint.this, "DELETE", REST_PATH, null, com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.RequestResult.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveWithdrawalMessage setAlt(java.lang.String alt) {
      return (RemoveWithdrawalMessage) super.setAlt(alt);
    }

    @Override
    public RemoveWithdrawalMessage setFields(java.lang.String fields) {
      return (RemoveWithdrawalMessage) super.setFields(fields);
    }

    @Override
    public RemoveWithdrawalMessage setKey(java.lang.String key) {
      return (RemoveWithdrawalMessage) super.setKey(key);
    }

    @Override
    public RemoveWithdrawalMessage setOauthToken(java.lang.String oauthToken) {
      return (RemoveWithdrawalMessage) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveWithdrawalMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveWithdrawalMessage) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveWithdrawalMessage setQuotaUser(java.lang.String quotaUser) {
      return (RemoveWithdrawalMessage) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveWithdrawalMessage setUserIp(java.lang.String userIp) {
      return (RemoveWithdrawalMessage) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveWithdrawalMessage setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveWithdrawalMessage set(String parameterName, Object value) {
      return (RemoveWithdrawalMessage) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "retrieveWithdrawalMessage".
   *
   * This request holds the parameters needed by the withdrawalmessageendpoint server.  After setting
   * any optional parameters, call the {@link RetrieveWithdrawalMessage#execute()} method to invoke
   * the remote operation.
   *
   * @param id
   * @return the request
   */
  public RetrieveWithdrawalMessage retrieveWithdrawalMessage(java.lang.Long id) throws java.io.IOException {
    RetrieveWithdrawalMessage result = new RetrieveWithdrawalMessage(id);
    initialize(result);
    return result;
  }

  public class RetrieveWithdrawalMessage extends WithdrawalmessageendpointRequest<com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.RequestResult> {

    private static final String REST_PATH = "retrieveWithdrawalMessage/{id}";

    /**
     * Create a request for the method "retrieveWithdrawalMessage".
     *
     * This request holds the parameters needed by the the withdrawalmessageendpoint server.  After
     * setting any optional parameters, call the {@link RetrieveWithdrawalMessage#execute()} method to
     * invoke the remote operation. <p> {@link RetrieveWithdrawalMessage#initialize(com.google.api.cli
     * ent.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this
     * instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RetrieveWithdrawalMessage(java.lang.Long id) {
      super(Withdrawalmessageendpoint.this, "POST", REST_PATH, null, com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.RequestResult.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RetrieveWithdrawalMessage setAlt(java.lang.String alt) {
      return (RetrieveWithdrawalMessage) super.setAlt(alt);
    }

    @Override
    public RetrieveWithdrawalMessage setFields(java.lang.String fields) {
      return (RetrieveWithdrawalMessage) super.setFields(fields);
    }

    @Override
    public RetrieveWithdrawalMessage setKey(java.lang.String key) {
      return (RetrieveWithdrawalMessage) super.setKey(key);
    }

    @Override
    public RetrieveWithdrawalMessage setOauthToken(java.lang.String oauthToken) {
      return (RetrieveWithdrawalMessage) super.setOauthToken(oauthToken);
    }

    @Override
    public RetrieveWithdrawalMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RetrieveWithdrawalMessage) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RetrieveWithdrawalMessage setQuotaUser(java.lang.String quotaUser) {
      return (RetrieveWithdrawalMessage) super.setQuotaUser(quotaUser);
    }

    @Override
    public RetrieveWithdrawalMessage setUserIp(java.lang.String userIp) {
      return (RetrieveWithdrawalMessage) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RetrieveWithdrawalMessage setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RetrieveWithdrawalMessage set(String parameterName, Object value) {
      return (RetrieveWithdrawalMessage) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateWithdrawalMessage".
   *
   * This request holds the parameters needed by the withdrawalmessageendpoint server.  After setting
   * any optional parameters, call the {@link UpdateWithdrawalMessage#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage}
   * @return the request
   */
  public UpdateWithdrawalMessage updateWithdrawalMessage(com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage content) throws java.io.IOException {
    UpdateWithdrawalMessage result = new UpdateWithdrawalMessage(content);
    initialize(result);
    return result;
  }

  public class UpdateWithdrawalMessage extends WithdrawalmessageendpointRequest<com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.RequestResult> {

    private static final String REST_PATH = "requestresult";

    /**
     * Create a request for the method "updateWithdrawalMessage".
     *
     * This request holds the parameters needed by the the withdrawalmessageendpoint server.  After
     * setting any optional parameters, call the {@link UpdateWithdrawalMessage#execute()} method to
     * invoke the remote operation. <p> {@link UpdateWithdrawalMessage#initialize(com.google.api.clien
     * t.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage}
     * @since 1.13
     */
    protected UpdateWithdrawalMessage(com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.WithdrawalMessage content) {
      super(Withdrawalmessageendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.withdrawalmessageendpoint.model.RequestResult.class);
    }

    @Override
    public UpdateWithdrawalMessage setAlt(java.lang.String alt) {
      return (UpdateWithdrawalMessage) super.setAlt(alt);
    }

    @Override
    public UpdateWithdrawalMessage setFields(java.lang.String fields) {
      return (UpdateWithdrawalMessage) super.setFields(fields);
    }

    @Override
    public UpdateWithdrawalMessage setKey(java.lang.String key) {
      return (UpdateWithdrawalMessage) super.setKey(key);
    }

    @Override
    public UpdateWithdrawalMessage setOauthToken(java.lang.String oauthToken) {
      return (UpdateWithdrawalMessage) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateWithdrawalMessage setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateWithdrawalMessage) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateWithdrawalMessage setQuotaUser(java.lang.String quotaUser) {
      return (UpdateWithdrawalMessage) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateWithdrawalMessage setUserIp(java.lang.String userIp) {
      return (UpdateWithdrawalMessage) super.setUserIp(userIp);
    }

    @Override
    public UpdateWithdrawalMessage set(String parameterName, Object value) {
      return (UpdateWithdrawalMessage) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Withdrawalmessageendpoint}.
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

    /** Builds a new instance of {@link Withdrawalmessageendpoint}. */
    @Override
    public Withdrawalmessageendpoint build() {
      return new Withdrawalmessageendpoint(this);
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
     * Set the {@link WithdrawalmessageendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setWithdrawalmessageendpointRequestInitializer(
        WithdrawalmessageendpointRequestInitializer withdrawalmessageendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(withdrawalmessageendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
