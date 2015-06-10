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
 * on 2015-05-30 at 05:34:43 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.transactionmodelendpoint;

/**
 * Service definition for Transactionmodelendpoint (v1).
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
 * This service uses {@link TransactionmodelendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Transactionmodelendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the transactionmodelendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "transactionmodelendpoint/v1/";

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
  public Transactionmodelendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Transactionmodelendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getTransactionModel".
   *
   * This request holds the parameters needed by the transactionmodelendpoint server.  After setting
   * any optional parameters, call the {@link GetTransactionModel#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public GetTransactionModel getTransactionModel(java.lang.Long id) throws java.io.IOException {
    GetTransactionModel result = new GetTransactionModel(id);
    initialize(result);
    return result;
  }

  public class GetTransactionModel extends TransactionmodelendpointRequest<com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel> {

    private static final String REST_PATH = "statementmodel/{id}";

    /**
     * Create a request for the method "getTransactionModel".
     *
     * This request holds the parameters needed by the the transactionmodelendpoint server.  After
     * setting any optional parameters, call the {@link GetTransactionModel#execute()} method to
     * invoke the remote operation. <p> {@link GetTransactionModel#initialize(com.google.api.client.go
     * ogleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetTransactionModel(java.lang.Long id) {
      super(Transactionmodelendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel.class);
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
    public GetTransactionModel setAlt(java.lang.String alt) {
      return (GetTransactionModel) super.setAlt(alt);
    }

    @Override
    public GetTransactionModel setFields(java.lang.String fields) {
      return (GetTransactionModel) super.setFields(fields);
    }

    @Override
    public GetTransactionModel setKey(java.lang.String key) {
      return (GetTransactionModel) super.setKey(key);
    }

    @Override
    public GetTransactionModel setOauthToken(java.lang.String oauthToken) {
      return (GetTransactionModel) super.setOauthToken(oauthToken);
    }

    @Override
    public GetTransactionModel setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetTransactionModel) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetTransactionModel setQuotaUser(java.lang.String quotaUser) {
      return (GetTransactionModel) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetTransactionModel setUserIp(java.lang.String userIp) {
      return (GetTransactionModel) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetTransactionModel setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetTransactionModel set(String parameterName, Object value) {
      return (GetTransactionModel) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertTransactionModel".
   *
   * This request holds the parameters needed by the transactionmodelendpoint server.  After setting
   * any optional parameters, call the {@link InsertTransactionModel#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel}
   * @return the request
   */
  public InsertTransactionModel insertTransactionModel(com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel content) throws java.io.IOException {
    InsertTransactionModel result = new InsertTransactionModel(content);
    initialize(result);
    return result;
  }

  public class InsertTransactionModel extends TransactionmodelendpointRequest<com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel> {

    private static final String REST_PATH = "statementmodel";

    /**
     * Create a request for the method "insertTransactionModel".
     *
     * This request holds the parameters needed by the the transactionmodelendpoint server.  After
     * setting any optional parameters, call the {@link InsertTransactionModel#execute()} method to
     * invoke the remote operation. <p> {@link InsertTransactionModel#initialize(com.google.api.client
     * .googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel}
     * @since 1.13
     */
    protected InsertTransactionModel(com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel content) {
      super(Transactionmodelendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel.class);
    }

    @Override
    public InsertTransactionModel setAlt(java.lang.String alt) {
      return (InsertTransactionModel) super.setAlt(alt);
    }

    @Override
    public InsertTransactionModel setFields(java.lang.String fields) {
      return (InsertTransactionModel) super.setFields(fields);
    }

    @Override
    public InsertTransactionModel setKey(java.lang.String key) {
      return (InsertTransactionModel) super.setKey(key);
    }

    @Override
    public InsertTransactionModel setOauthToken(java.lang.String oauthToken) {
      return (InsertTransactionModel) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertTransactionModel setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertTransactionModel) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertTransactionModel setQuotaUser(java.lang.String quotaUser) {
      return (InsertTransactionModel) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertTransactionModel setUserIp(java.lang.String userIp) {
      return (InsertTransactionModel) super.setUserIp(userIp);
    }

    @Override
    public InsertTransactionModel set(String parameterName, Object value) {
      return (InsertTransactionModel) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listTransactionModel".
   *
   * This request holds the parameters needed by the transactionmodelendpoint server.  After setting
   * any optional parameters, call the {@link ListTransactionModel#execute()} method to invoke the
   * remote operation.
   *
   * @return the request
   */
  public ListTransactionModel listTransactionModel() throws java.io.IOException {
    ListTransactionModel result = new ListTransactionModel();
    initialize(result);
    return result;
  }

  public class ListTransactionModel extends TransactionmodelendpointRequest<com.sp.fanikiwa.entity.transactionmodelendpoint.model.CollectionResponseStatementModel> {

    private static final String REST_PATH = "statementmodel";

    /**
     * Create a request for the method "listTransactionModel".
     *
     * This request holds the parameters needed by the the transactionmodelendpoint server.  After
     * setting any optional parameters, call the {@link ListTransactionModel#execute()} method to
     * invoke the remote operation. <p> {@link ListTransactionModel#initialize(com.google.api.client.g
     * oogleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListTransactionModel() {
      super(Transactionmodelendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.transactionmodelendpoint.model.CollectionResponseStatementModel.class);
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
    public ListTransactionModel setAlt(java.lang.String alt) {
      return (ListTransactionModel) super.setAlt(alt);
    }

    @Override
    public ListTransactionModel setFields(java.lang.String fields) {
      return (ListTransactionModel) super.setFields(fields);
    }

    @Override
    public ListTransactionModel setKey(java.lang.String key) {
      return (ListTransactionModel) super.setKey(key);
    }

    @Override
    public ListTransactionModel setOauthToken(java.lang.String oauthToken) {
      return (ListTransactionModel) super.setOauthToken(oauthToken);
    }

    @Override
    public ListTransactionModel setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListTransactionModel) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListTransactionModel setQuotaUser(java.lang.String quotaUser) {
      return (ListTransactionModel) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListTransactionModel setUserIp(java.lang.String userIp) {
      return (ListTransactionModel) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListTransactionModel setCount(java.lang.Integer count) {
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

    public ListTransactionModel setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListTransactionModel set(String parameterName, Object value) {
      return (ListTransactionModel) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeTransactionModel".
   *
   * This request holds the parameters needed by the transactionmodelendpoint server.  After setting
   * any optional parameters, call the {@link RemoveTransactionModel#execute()} method to invoke the
   * remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveTransactionModel removeTransactionModel(java.lang.Long id) throws java.io.IOException {
    RemoveTransactionModel result = new RemoveTransactionModel(id);
    initialize(result);
    return result;
  }

  public class RemoveTransactionModel extends TransactionmodelendpointRequest<Void> {

    private static final String REST_PATH = "transactionmodel/{id}";

    /**
     * Create a request for the method "removeTransactionModel".
     *
     * This request holds the parameters needed by the the transactionmodelendpoint server.  After
     * setting any optional parameters, call the {@link RemoveTransactionModel#execute()} method to
     * invoke the remote operation. <p> {@link RemoveTransactionModel#initialize(com.google.api.client
     * .googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveTransactionModel(java.lang.Long id) {
      super(Transactionmodelendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveTransactionModel setAlt(java.lang.String alt) {
      return (RemoveTransactionModel) super.setAlt(alt);
    }

    @Override
    public RemoveTransactionModel setFields(java.lang.String fields) {
      return (RemoveTransactionModel) super.setFields(fields);
    }

    @Override
    public RemoveTransactionModel setKey(java.lang.String key) {
      return (RemoveTransactionModel) super.setKey(key);
    }

    @Override
    public RemoveTransactionModel setOauthToken(java.lang.String oauthToken) {
      return (RemoveTransactionModel) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveTransactionModel setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveTransactionModel) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveTransactionModel setQuotaUser(java.lang.String quotaUser) {
      return (RemoveTransactionModel) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveTransactionModel setUserIp(java.lang.String userIp) {
      return (RemoveTransactionModel) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveTransactionModel setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveTransactionModel set(String parameterName, Object value) {
      return (RemoveTransactionModel) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateTransactionModel".
   *
   * This request holds the parameters needed by the transactionmodelendpoint server.  After setting
   * any optional parameters, call the {@link UpdateTransactionModel#execute()} method to invoke the
   * remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel}
   * @return the request
   */
  public UpdateTransactionModel updateTransactionModel(com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel content) throws java.io.IOException {
    UpdateTransactionModel result = new UpdateTransactionModel(content);
    initialize(result);
    return result;
  }

  public class UpdateTransactionModel extends TransactionmodelendpointRequest<com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel> {

    private static final String REST_PATH = "statementmodel";

    /**
     * Create a request for the method "updateTransactionModel".
     *
     * This request holds the parameters needed by the the transactionmodelendpoint server.  After
     * setting any optional parameters, call the {@link UpdateTransactionModel#execute()} method to
     * invoke the remote operation. <p> {@link UpdateTransactionModel#initialize(com.google.api.client
     * .googleapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
     * immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel}
     * @since 1.13
     */
    protected UpdateTransactionModel(com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel content) {
      super(Transactionmodelendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.transactionmodelendpoint.model.StatementModel.class);
    }

    @Override
    public UpdateTransactionModel setAlt(java.lang.String alt) {
      return (UpdateTransactionModel) super.setAlt(alt);
    }

    @Override
    public UpdateTransactionModel setFields(java.lang.String fields) {
      return (UpdateTransactionModel) super.setFields(fields);
    }

    @Override
    public UpdateTransactionModel setKey(java.lang.String key) {
      return (UpdateTransactionModel) super.setKey(key);
    }

    @Override
    public UpdateTransactionModel setOauthToken(java.lang.String oauthToken) {
      return (UpdateTransactionModel) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateTransactionModel setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateTransactionModel) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateTransactionModel setQuotaUser(java.lang.String quotaUser) {
      return (UpdateTransactionModel) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateTransactionModel setUserIp(java.lang.String userIp) {
      return (UpdateTransactionModel) super.setUserIp(userIp);
    }

    @Override
    public UpdateTransactionModel set(String parameterName, Object value) {
      return (UpdateTransactionModel) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Transactionmodelendpoint}.
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

    /** Builds a new instance of {@link Transactionmodelendpoint}. */
    @Override
    public Transactionmodelendpoint build() {
      return new Transactionmodelendpoint(this);
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
     * Set the {@link TransactionmodelendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setTransactionmodelendpointRequestInitializer(
        TransactionmodelendpointRequestInitializer transactionmodelendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(transactionmodelendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
