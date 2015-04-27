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
 * on 2015-04-26 at 13:15:28 UTC 
 * Modify at your own risk.
 */

package com.sp.fanikiwa.entity.valuedatedtransactionendpoint;

/**
 * Service definition for Valuedatedtransactionendpoint (v1).
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
 * This service uses {@link ValuedatedtransactionendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Valuedatedtransactionendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the valuedatedtransactionendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "valuedatedtransactionendpoint/v1/";

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
  public Valuedatedtransactionendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Valuedatedtransactionendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the ValueDatedTransactionEndpoint collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Valuedatedtransactionendpoint valuedatedtransactionendpoint = new Valuedatedtransactionendpoint(...);}
   *   {@code Valuedatedtransactionendpoint.ValueDatedTransactionEndpoint.List request = valuedatedtransactionendpoint.valueDatedTransactionEndpoint().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public ValueDatedTransactionEndpoint valueDatedTransactionEndpoint() {
    return new ValueDatedTransactionEndpoint();
  }

  /**
   * The "valueDatedTransactionEndpoint" collection of methods.
   */
  public class ValueDatedTransactionEndpoint {

    /**
     * Create a request for the method "valueDatedTransactionEndpoint.selectByValueDate".
     *
     * This request holds the parameters needed by the valuedatedtransactionendpoint server.  After
     * setting any optional parameters, call the {@link SelectByValueDate#execute()} method to invoke
     * the remote operation.
     *
     * @param date
     * @return the request
     */
    public SelectByValueDate selectByValueDate(com.google.api.client.util.DateTime date) throws java.io.IOException {
      SelectByValueDate result = new SelectByValueDate(date);
      initialize(result);
      return result;
    }

    public class SelectByValueDate extends ValuedatedtransactionendpointRequest<com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransactionCollection> {

      private static final String REST_PATH = "SelectByValueDate/{date}";

      /**
       * Create a request for the method "valueDatedTransactionEndpoint.selectByValueDate".
       *
       * This request holds the parameters needed by the the valuedatedtransactionendpoint server.
       * After setting any optional parameters, call the {@link SelectByValueDate#execute()} method to
       * invoke the remote operation. <p> {@link SelectByValueDate#initialize(com.google.api.client.goog
       * leapis.services.AbstractGoogleClientRequest)} must be called to initialize this instance
       * immediately after invoking the constructor. </p>
       *
       * @param date
       * @since 1.13
       */
      protected SelectByValueDate(com.google.api.client.util.DateTime date) {
        super(Valuedatedtransactionendpoint.this, "POST", REST_PATH, null, com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransactionCollection.class);
        this.date = com.google.api.client.util.Preconditions.checkNotNull(date, "Required parameter date must be specified.");
      }

      @Override
      public SelectByValueDate setAlt(java.lang.String alt) {
        return (SelectByValueDate) super.setAlt(alt);
      }

      @Override
      public SelectByValueDate setFields(java.lang.String fields) {
        return (SelectByValueDate) super.setFields(fields);
      }

      @Override
      public SelectByValueDate setKey(java.lang.String key) {
        return (SelectByValueDate) super.setKey(key);
      }

      @Override
      public SelectByValueDate setOauthToken(java.lang.String oauthToken) {
        return (SelectByValueDate) super.setOauthToken(oauthToken);
      }

      @Override
      public SelectByValueDate setPrettyPrint(java.lang.Boolean prettyPrint) {
        return (SelectByValueDate) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public SelectByValueDate setQuotaUser(java.lang.String quotaUser) {
        return (SelectByValueDate) super.setQuotaUser(quotaUser);
      }

      @Override
      public SelectByValueDate setUserIp(java.lang.String userIp) {
        return (SelectByValueDate) super.setUserIp(userIp);
      }

      @com.google.api.client.util.Key
      private com.google.api.client.util.DateTime date;

      /**

       */
      public com.google.api.client.util.DateTime getDate() {
        return date;
      }

      public SelectByValueDate setDate(com.google.api.client.util.DateTime date) {
        this.date = date;
        return this;
      }

      @Override
      public SelectByValueDate set(String parameterName, Object value) {
        return (SelectByValueDate) super.set(parameterName, value);
      }
    }

  }

  /**
   * Create a request for the method "getValueDatedTransaction".
   *
   * This request holds the parameters needed by the valuedatedtransactionendpoint server.  After
   * setting any optional parameters, call the {@link GetValueDatedTransaction#execute()} method to
   * invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public GetValueDatedTransaction getValueDatedTransaction(java.lang.Long id) throws java.io.IOException {
    GetValueDatedTransaction result = new GetValueDatedTransaction(id);
    initialize(result);
    return result;
  }

  public class GetValueDatedTransaction extends ValuedatedtransactionendpointRequest<com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction> {

    private static final String REST_PATH = "valuedatedtransaction/{id}";

    /**
     * Create a request for the method "getValueDatedTransaction".
     *
     * This request holds the parameters needed by the the valuedatedtransactionendpoint server.
     * After setting any optional parameters, call the {@link GetValueDatedTransaction#execute()}
     * method to invoke the remote operation. <p> {@link GetValueDatedTransaction#initialize(com.googl
     * e.api.client.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize
     * this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetValueDatedTransaction(java.lang.Long id) {
      super(Valuedatedtransactionendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction.class);
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
    public GetValueDatedTransaction setAlt(java.lang.String alt) {
      return (GetValueDatedTransaction) super.setAlt(alt);
    }

    @Override
    public GetValueDatedTransaction setFields(java.lang.String fields) {
      return (GetValueDatedTransaction) super.setFields(fields);
    }

    @Override
    public GetValueDatedTransaction setKey(java.lang.String key) {
      return (GetValueDatedTransaction) super.setKey(key);
    }

    @Override
    public GetValueDatedTransaction setOauthToken(java.lang.String oauthToken) {
      return (GetValueDatedTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public GetValueDatedTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetValueDatedTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetValueDatedTransaction setQuotaUser(java.lang.String quotaUser) {
      return (GetValueDatedTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetValueDatedTransaction setUserIp(java.lang.String userIp) {
      return (GetValueDatedTransaction) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetValueDatedTransaction setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetValueDatedTransaction set(String parameterName, Object value) {
      return (GetValueDatedTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertValueDatedTransaction".
   *
   * This request holds the parameters needed by the valuedatedtransactionendpoint server.  After
   * setting any optional parameters, call the {@link InsertValueDatedTransaction#execute()} method to
   * invoke the remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction}
   * @return the request
   */
  public InsertValueDatedTransaction insertValueDatedTransaction(com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction content) throws java.io.IOException {
    InsertValueDatedTransaction result = new InsertValueDatedTransaction(content);
    initialize(result);
    return result;
  }

  public class InsertValueDatedTransaction extends ValuedatedtransactionendpointRequest<com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction> {

    private static final String REST_PATH = "valuedatedtransaction";

    /**
     * Create a request for the method "insertValueDatedTransaction".
     *
     * This request holds the parameters needed by the the valuedatedtransactionendpoint server.
     * After setting any optional parameters, call the {@link InsertValueDatedTransaction#execute()}
     * method to invoke the remote operation. <p> {@link InsertValueDatedTransaction#initialize(com.go
     * ogle.api.client.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize
     * this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction}
     * @since 1.13
     */
    protected InsertValueDatedTransaction(com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction content) {
      super(Valuedatedtransactionendpoint.this, "POST", REST_PATH, content, com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction.class);
    }

    @Override
    public InsertValueDatedTransaction setAlt(java.lang.String alt) {
      return (InsertValueDatedTransaction) super.setAlt(alt);
    }

    @Override
    public InsertValueDatedTransaction setFields(java.lang.String fields) {
      return (InsertValueDatedTransaction) super.setFields(fields);
    }

    @Override
    public InsertValueDatedTransaction setKey(java.lang.String key) {
      return (InsertValueDatedTransaction) super.setKey(key);
    }

    @Override
    public InsertValueDatedTransaction setOauthToken(java.lang.String oauthToken) {
      return (InsertValueDatedTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertValueDatedTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertValueDatedTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertValueDatedTransaction setQuotaUser(java.lang.String quotaUser) {
      return (InsertValueDatedTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertValueDatedTransaction setUserIp(java.lang.String userIp) {
      return (InsertValueDatedTransaction) super.setUserIp(userIp);
    }

    @Override
    public InsertValueDatedTransaction set(String parameterName, Object value) {
      return (InsertValueDatedTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listValueDatedTransaction".
   *
   * This request holds the parameters needed by the valuedatedtransactionendpoint server.  After
   * setting any optional parameters, call the {@link ListValueDatedTransaction#execute()} method to
   * invoke the remote operation.
   *
   * @return the request
   */
  public ListValueDatedTransaction listValueDatedTransaction() throws java.io.IOException {
    ListValueDatedTransaction result = new ListValueDatedTransaction();
    initialize(result);
    return result;
  }

  public class ListValueDatedTransaction extends ValuedatedtransactionendpointRequest<com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.CollectionResponseValueDatedTransaction> {

    private static final String REST_PATH = "valuedatedtransaction";

    /**
     * Create a request for the method "listValueDatedTransaction".
     *
     * This request holds the parameters needed by the the valuedatedtransactionendpoint server.
     * After setting any optional parameters, call the {@link ListValueDatedTransaction#execute()}
     * method to invoke the remote operation. <p> {@link ListValueDatedTransaction#initialize(com.goog
     * le.api.client.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize
     * this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListValueDatedTransaction() {
      super(Valuedatedtransactionendpoint.this, "GET", REST_PATH, null, com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.CollectionResponseValueDatedTransaction.class);
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
    public ListValueDatedTransaction setAlt(java.lang.String alt) {
      return (ListValueDatedTransaction) super.setAlt(alt);
    }

    @Override
    public ListValueDatedTransaction setFields(java.lang.String fields) {
      return (ListValueDatedTransaction) super.setFields(fields);
    }

    @Override
    public ListValueDatedTransaction setKey(java.lang.String key) {
      return (ListValueDatedTransaction) super.setKey(key);
    }

    @Override
    public ListValueDatedTransaction setOauthToken(java.lang.String oauthToken) {
      return (ListValueDatedTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public ListValueDatedTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListValueDatedTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListValueDatedTransaction setQuotaUser(java.lang.String quotaUser) {
      return (ListValueDatedTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListValueDatedTransaction setUserIp(java.lang.String userIp) {
      return (ListValueDatedTransaction) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Integer count;

    /**

     */
    public java.lang.Integer getCount() {
      return count;
    }

    public ListValueDatedTransaction setCount(java.lang.Integer count) {
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

    public ListValueDatedTransaction setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @Override
    public ListValueDatedTransaction set(String parameterName, Object value) {
      return (ListValueDatedTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeValueDatedTransaction".
   *
   * This request holds the parameters needed by the valuedatedtransactionendpoint server.  After
   * setting any optional parameters, call the {@link RemoveValueDatedTransaction#execute()} method to
   * invoke the remote operation.
   *
   * @param id
   * @return the request
   */
  public RemoveValueDatedTransaction removeValueDatedTransaction(java.lang.Long id) throws java.io.IOException {
    RemoveValueDatedTransaction result = new RemoveValueDatedTransaction(id);
    initialize(result);
    return result;
  }

  public class RemoveValueDatedTransaction extends ValuedatedtransactionendpointRequest<Void> {

    private static final String REST_PATH = "valuedatedtransaction/{id}";

    /**
     * Create a request for the method "removeValueDatedTransaction".
     *
     * This request holds the parameters needed by the the valuedatedtransactionendpoint server.
     * After setting any optional parameters, call the {@link RemoveValueDatedTransaction#execute()}
     * method to invoke the remote operation. <p> {@link RemoveValueDatedTransaction#initialize(com.go
     * ogle.api.client.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize
     * this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveValueDatedTransaction(java.lang.Long id) {
      super(Valuedatedtransactionendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveValueDatedTransaction setAlt(java.lang.String alt) {
      return (RemoveValueDatedTransaction) super.setAlt(alt);
    }

    @Override
    public RemoveValueDatedTransaction setFields(java.lang.String fields) {
      return (RemoveValueDatedTransaction) super.setFields(fields);
    }

    @Override
    public RemoveValueDatedTransaction setKey(java.lang.String key) {
      return (RemoveValueDatedTransaction) super.setKey(key);
    }

    @Override
    public RemoveValueDatedTransaction setOauthToken(java.lang.String oauthToken) {
      return (RemoveValueDatedTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveValueDatedTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveValueDatedTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveValueDatedTransaction setQuotaUser(java.lang.String quotaUser) {
      return (RemoveValueDatedTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveValueDatedTransaction setUserIp(java.lang.String userIp) {
      return (RemoveValueDatedTransaction) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveValueDatedTransaction setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveValueDatedTransaction set(String parameterName, Object value) {
      return (RemoveValueDatedTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateValueDatedTransaction".
   *
   * This request holds the parameters needed by the valuedatedtransactionendpoint server.  After
   * setting any optional parameters, call the {@link UpdateValueDatedTransaction#execute()} method to
   * invoke the remote operation.
   *
   * @param content the {@link com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction}
   * @return the request
   */
  public UpdateValueDatedTransaction updateValueDatedTransaction(com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction content) throws java.io.IOException {
    UpdateValueDatedTransaction result = new UpdateValueDatedTransaction(content);
    initialize(result);
    return result;
  }

  public class UpdateValueDatedTransaction extends ValuedatedtransactionendpointRequest<com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction> {

    private static final String REST_PATH = "valuedatedtransaction";

    /**
     * Create a request for the method "updateValueDatedTransaction".
     *
     * This request holds the parameters needed by the the valuedatedtransactionendpoint server.
     * After setting any optional parameters, call the {@link UpdateValueDatedTransaction#execute()}
     * method to invoke the remote operation. <p> {@link UpdateValueDatedTransaction#initialize(com.go
     * ogle.api.client.googleapis.services.AbstractGoogleClientRequest)} must be called to initialize
     * this instance immediately after invoking the constructor. </p>
     *
     * @param content the {@link com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction}
     * @since 1.13
     */
    protected UpdateValueDatedTransaction(com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction content) {
      super(Valuedatedtransactionendpoint.this, "PUT", REST_PATH, content, com.sp.fanikiwa.entity.valuedatedtransactionendpoint.model.ValueDatedTransaction.class);
    }

    @Override
    public UpdateValueDatedTransaction setAlt(java.lang.String alt) {
      return (UpdateValueDatedTransaction) super.setAlt(alt);
    }

    @Override
    public UpdateValueDatedTransaction setFields(java.lang.String fields) {
      return (UpdateValueDatedTransaction) super.setFields(fields);
    }

    @Override
    public UpdateValueDatedTransaction setKey(java.lang.String key) {
      return (UpdateValueDatedTransaction) super.setKey(key);
    }

    @Override
    public UpdateValueDatedTransaction setOauthToken(java.lang.String oauthToken) {
      return (UpdateValueDatedTransaction) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateValueDatedTransaction setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateValueDatedTransaction) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateValueDatedTransaction setQuotaUser(java.lang.String quotaUser) {
      return (UpdateValueDatedTransaction) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateValueDatedTransaction setUserIp(java.lang.String userIp) {
      return (UpdateValueDatedTransaction) super.setUserIp(userIp);
    }

    @Override
    public UpdateValueDatedTransaction set(String parameterName, Object value) {
      return (UpdateValueDatedTransaction) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Valuedatedtransactionendpoint}.
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

    /** Builds a new instance of {@link Valuedatedtransactionendpoint}. */
    @Override
    public Valuedatedtransactionendpoint build() {
      return new Valuedatedtransactionendpoint(this);
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
     * Set the {@link ValuedatedtransactionendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setValuedatedtransactionendpointRequestInitializer(
        ValuedatedtransactionendpointRequestInitializer valuedatedtransactionendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(valuedatedtransactionendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
