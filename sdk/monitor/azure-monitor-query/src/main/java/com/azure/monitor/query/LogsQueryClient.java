// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.monitor.query;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.monitor.query.implementation.logs.models.LogsQueryHelper;
import com.azure.monitor.query.models.LogsBatchQuery;
import com.azure.monitor.query.models.LogsBatchQueryResultCollection;
import com.azure.monitor.query.models.LogsQueryOptions;
import com.azure.monitor.query.models.LogsQueryResult;
import com.azure.monitor.query.models.QueryTimeInterval;

import java.util.List;

/**
 * The synchronous client for querying Azure Monitor logs.
 *
 * <p><strong>Instantiating a synchronous Logs query Client</strong></p>
 *
 * <!-- src_embed com.azure.monitor.query.LogsQueryClient.instantiation -->
 * <pre>
 * LogsQueryClient logsQueryClient = new LogsQueryClientBuilder&#40;&#41;
 *         .credential&#40;tokenCredential&#41;
 *         .buildClient&#40;&#41;;
 * </pre>
 * <!-- end com.azure.monitor.query.LogsQueryClient.instantiation -->
 */
@ServiceClient(builder = LogsQueryClientBuilder.class)
public final class LogsQueryClient {

    private final LogsQueryAsyncClient asyncClient;

    /**
     * Constructor that has the async client to make sync over async service calls.
     * @param asyncClient The asynchronous client.
     */
    LogsQueryClient(LogsQueryAsyncClient asyncClient) {
        this.asyncClient = asyncClient;
    }

    /**
     * Returns all the Azure Monitor logs matching the given query in the specified workspaceId.
     *
     * <p><strong>Query logs from the last 24 hours</strong></p>
     *
     * <!-- src_embed com.azure.monitor.query.LogsQueryClient.query#String-String-QueryTimeInterval -->
     * <pre>
     * LogsQueryResult queryResult = logsQueryClient.queryWorkspace&#40;&quot;&#123;workspace-id&#125;&quot;, &quot;&#123;kusto-query&#125;&quot;,
     *         QueryTimeInterval.LAST_DAY&#41;;
     * for &#40;LogsTableRow row : queryResult.getTable&#40;&#41;.getRows&#40;&#41;&#41; &#123;
     *     System.out.println&#40;row.getRow&#40;&#41;
     *             .stream&#40;&#41;
     *             .map&#40;LogsTableCell::getValueAsString&#41;
     *             .collect&#40;Collectors.joining&#40;&quot;,&quot;&#41;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.monitor.query.LogsQueryClient.query#String-String-QueryTimeInterval -->
     * @param workspaceId The workspaceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @return The logs matching the query.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogsQueryResult queryWorkspace(String workspaceId, String query, QueryTimeInterval timeInterval) {
        return asyncClient.queryWorkspace(workspaceId, query, timeInterval).block();
    }

    /**
     * Returns all the Azure Monitor logs matching the given query in the specified workspaceId.
     * @param workspaceId The workspaceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param type The type the result of this query should be mapped to.
     * @param <T> The type the result of this query should be mapped to.
     * @return The logs matching the query as a list of objects of type T.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> List<T> queryWorkspace(String workspaceId, String query, QueryTimeInterval timeInterval, Class<T> type) {
        LogsQueryResult logsQueryResult = asyncClient.queryWorkspace(workspaceId, query, timeInterval).block();
        if (logsQueryResult != null) {
            return LogsQueryHelper.toObject(logsQueryResult.getTable(), type);
        }
        return null;
    }

    /**
     * Returns all the Azure Monitor logs matching the given query in the specified workspaceId.
     * @param workspaceId The workspaceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param type The type the result of this query should be mapped to.
     * @param options The log query options to configure server timeout, set additional workspaces or enable
     * statistics and rendering information in response.
     * @param <T> The type the result of this query should be mapped to.
     * @return The logs matching the query as a list of objects of type T.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> List<T> queryWorkspace(String workspaceId, String query, QueryTimeInterval timeInterval,
                                      Class<T> type, LogsQueryOptions options) {
        LogsQueryResult logsQueryResult = queryWorkspaceWithResponse(workspaceId, query, timeInterval, options, Context.NONE)
                .getValue();
        if (logsQueryResult != null) {
            return LogsQueryHelper.toObject(logsQueryResult.getTable(), type);
        }
        return null;
    }

    /**
     * Returns all the Azure Monitor logs matching the given query in the specified workspaceId.
     *
     * <p><strong>Query logs from the last 7 days and set the service timeout to 2 minutes</strong></p>
     *
     * <!-- src_embed com.azure.monitor.query.LogsQueryClient.queryWithResponse#String-String-QueryTimeInterval-LogsQueryOptions-Context -->
     * <pre>
     * Response&lt;LogsQueryResult&gt; queryResult = logsQueryClient.queryWorkspaceWithResponse&#40;&quot;&#123;workspace-id&#125;&quot;,
     *         &quot;&#123;kusto-query&#125;&quot;,
     *         QueryTimeInterval.LAST_7_DAYS,
     *         new LogsQueryOptions&#40;&#41;.setServerTimeout&#40;Duration.ofMinutes&#40;2&#41;&#41;,
     *         Context.NONE&#41;;
     *
     * for &#40;LogsTableRow row : queryResult.getValue&#40;&#41;.getTable&#40;&#41;.getRows&#40;&#41;&#41; &#123;
     *     System.out.println&#40;row.getRow&#40;&#41;
     *             .stream&#40;&#41;
     *             .map&#40;LogsTableCell::getValueAsString&#41;
     *             .collect&#40;Collectors.joining&#40;&quot;,&quot;&#41;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.monitor.query.LogsQueryClient.queryWithResponse#String-String-QueryTimeInterval-LogsQueryOptions-Context -->
     * @param workspaceId The workspaceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param options The log query options to configure server timeout, set additional workspaces or enable
     * statistics and rendering information in response.
     * @param context Additional context that is passed through the Http pipeline during the service call. If no
     * additional context is required, pass {@link Context#NONE} instead.
     * @return The logs matching the query including the HTTP response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LogsQueryResult> queryWorkspaceWithResponse(String workspaceId, String query, QueryTimeInterval timeInterval,
                                                                LogsQueryOptions options, Context context) {
        return asyncClient.queryWorkspaceWithResponse(workspaceId, query, timeInterval, options, context).block();
    }

    /**
     * Returns all the Azure Monitor logs matching the given query in the specified workspaceId.
     *
     * @param workspaceId The workspaceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param type The type the result of this query should be mapped to.
     * @param <T> The type the result of this query should be mapped to.
     * @param options The log query options to configure server timeout, set additional workspaces or enable
     * statistics and rendering information in response.
     * @param context Additional context that is passed through the Http pipeline during the service call. If no
     * additional context is required, pass {@link Context#NONE} instead.
     * @return The logs matching the query including the HTTP response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> Response<List<T>> queryWorkspaceWithResponse(String workspaceId, String query, QueryTimeInterval timeInterval,
                                                            Class<T> type, LogsQueryOptions options, Context context) {
        return asyncClient.queryWorkspaceWithResponse(workspaceId, query, timeInterval, options, context)
                .map(response -> new SimpleResponse<>(response.getRequest(),
                        response.getStatusCode(), response.getHeaders(),
                        LogsQueryHelper.toObject(response.getValue().getTable(), type)))
                .block();
    }

    /**
     * Returns all the Azure Monitor logs matching the given batch of queries in the specified workspaceId.
     * @param workspaceId The workspaceId where the batch of queries should be executed.
     * @param queries A batch of Kusto queries.
     * @param timeInterval The time period for which the logs should be looked up.
     * @return A collection of query results corresponding to the input batch of queries.
     */
    LogsBatchQueryResultCollection queryBatch(String workspaceId, List<String> queries, QueryTimeInterval timeInterval) {
        return asyncClient.queryBatch(workspaceId, queries, timeInterval).block();
    }

    /**
     * Returns all the Azure Monitor logs matching the given batch of queries.
     *
     * <p><strong>Execute a batch of logs queries</strong></p>
     *
     * <!-- src_embed com.azure.monitor.query.LogsQueryClient.queryBatch#LogsBatchQuery -->
     * <pre>
     * LogsBatchQuery batchQuery = new LogsBatchQuery&#40;&#41;;
     * String queryId1 = batchQuery.addWorkspaceQuery&#40;&quot;&#123;workspace-id-1&#125;&quot;, &quot;&#123;kusto-query-1&#125;&quot;, QueryTimeInterval.LAST_DAY&#41;;
     * String queryId2 = batchQuery.addWorkspaceQuery&#40;&quot;&#123;workspace-id-2&#125;&quot;, &quot;&#123;kusto-query-2&#125;&quot;,
     *         QueryTimeInterval.LAST_7_DAYS, new LogsQueryOptions&#40;&#41;.setServerTimeout&#40;Duration.ofMinutes&#40;2&#41;&#41;&#41;;
     *
     * LogsBatchQueryResultCollection batchQueryResponse = logsQueryClient.queryBatch&#40;batchQuery&#41;;
     *
     * for &#40;LogsBatchQueryResult queryResult : batchQueryResponse.getBatchResults&#40;&#41;&#41; &#123;
     *     System.out.println&#40;&quot;Logs query result for query id &quot; + queryResult.getId&#40;&#41;&#41;;
     *     for &#40;LogsTableRow row : queryResult.getTable&#40;&#41;.getRows&#40;&#41;&#41; &#123;
     *         System.out.println&#40;row.getRow&#40;&#41;
     *                 .stream&#40;&#41;
     *                 .map&#40;LogsTableCell::getValueAsString&#41;
     *                 .collect&#40;Collectors.joining&#40;&quot;,&quot;&#41;&#41;&#41;;
     *     &#125;
     * &#125;
     * </pre>
     * <!-- end com.azure.monitor.query.LogsQueryClient.queryBatch#LogsBatchQuery -->
     * @param logsBatchQuery {@link LogsBatchQuery} containing a batch of queries.
     * @return A collection of query results corresponding to the input batch of queries.@return
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogsBatchQueryResultCollection queryBatch(LogsBatchQuery logsBatchQuery) {
        return asyncClient.queryBatch(logsBatchQuery).block();
    }


    /**
     * Returns all the Azure Monitor logs matching the given batch of queries.
     *
     * @param logsBatchQuery {@link LogsBatchQuery} containing a batch of queries.
     * @param context Additional context that is passed through the Http pipeline during the service call. If no
     * additional context is required, pass {@link Context#NONE} instead.
     * @return A collection of query results corresponding to the input batch of queries.@return
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LogsBatchQueryResultCollection> queryBatchWithResponse(LogsBatchQuery logsBatchQuery, Context context) {
        return asyncClient.queryBatchWithResponse(logsBatchQuery, context).block();
    }

    /**
     * Returns all the Azure Monitor logs matching the given query for an Azure resource.
     *
     * <p><strong>Query logs from the last 24 hours</strong></p>
     *
     * <!-- src_embed com.azure.monitor.query.LogsQueryClient.queryResource#String-String-QueryTimeInterval -->
     * <pre>
     * LogsQueryResult queryResult = logsQueryClient.queryResource&#40;&quot;&#123;resource-id&#125;&quot;, &quot;&#123;kusto-query&#125;&quot;,
     *     QueryTimeInterval.LAST_DAY&#41;;
     * for &#40;LogsTableRow row : queryResult.getTable&#40;&#41;.getRows&#40;&#41;&#41; &#123;
     *     System.out.println&#40;row.getRow&#40;&#41;
     *         .stream&#40;&#41;
     *         .map&#40;LogsTableCell::getValueAsString&#41;
     *         .collect&#40;Collectors.joining&#40;&quot;,&quot;&#41;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.monitor.query.LogsQueryClient.queryResource#String-String-QueryTimeInterval -->
     * @param resourceId The resourceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @return The logs matching the query.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public LogsQueryResult queryResource(String resourceId, String query, QueryTimeInterval timeInterval) {
        return asyncClient.queryResource(resourceId, query, timeInterval).block();
    }

    /**
     * Returns all the Azure Monitor logs matching the given query for an Azure resource.
     * @param resourceId The resourceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param type The type the result of this query should be mapped to.
     * @param <T> The type the result of this query should be mapped to.
     * @return The logs matching the query as a list of objects of type T.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> List<T> queryResource(String resourceId, String query, QueryTimeInterval timeInterval, Class<T> type) {
        LogsQueryResult logsQueryResult = asyncClient.queryResource(resourceId, query, timeInterval).block();
        if (logsQueryResult != null) {
            return LogsQueryHelper.toObject(logsQueryResult.getTable(), type);
        }
        return null;
    }

    /**
     * Returns all the Azure Monitor logs matching the given query for an Azure resource.
     * @param resourceId The resourceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param type The type the result of this query should be mapped to.
     * @param options The log query options to configure server timeout, set additional workspaces or enable
     * statistics and rendering information in response.
     * @param <T> The type the result of this query should be mapped to.
     * @return The logs matching the query as a list of objects of type T.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> List<T> queryResource(String resourceId, String query, QueryTimeInterval timeInterval,
                                      Class<T> type, LogsQueryOptions options) {
        LogsQueryResult logsQueryResult = queryResourceWithResponse(resourceId, query, timeInterval, options, Context.NONE)
            .getValue();
        if (logsQueryResult != null) {
            return LogsQueryHelper.toObject(logsQueryResult.getTable(), type);
        }
        return null;
    }

    /**
     * Returns all the Azure Monitor logs matching the given query for an Azure resource.
     *
     * <p><strong>Query logs from the last 7 days and set the service timeout to 2 minutes</strong></p>
     *
     * <!-- src_embed com.azure.monitor.query.LogsQueryClient.queryResourceWithResponse#String-String-QueryTimeInterval-LogsQueryOptions-Context -->
     * <pre>
     * Response&lt;LogsQueryResult&gt; queryResult = logsQueryClient.queryResourceWithResponse&#40;&quot;&#123;resource-id&#125;&quot;,
     *     &quot;&#123;kusto-query&#125;&quot;,
     *     QueryTimeInterval.LAST_7_DAYS,
     *     new LogsQueryOptions&#40;&#41;.setServerTimeout&#40;Duration.ofMinutes&#40;2&#41;&#41;,
     *     Context.NONE&#41;;
     *
     * for &#40;LogsTableRow row : queryResult.getValue&#40;&#41;.getTable&#40;&#41;.getRows&#40;&#41;&#41; &#123;
     *     System.out.println&#40;row.getRow&#40;&#41;
     *         .stream&#40;&#41;
     *         .map&#40;LogsTableCell::getValueAsString&#41;
     *         .collect&#40;Collectors.joining&#40;&quot;,&quot;&#41;&#41;&#41;;
     * &#125;
     * </pre>
     * <!-- end com.azure.monitor.query.LogsQueryClient.queryResourceWithResponse#String-String-QueryTimeInterval-LogsQueryOptions-Context -->
     * @param resourceId The resourceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param options The log query options to configure server timeout, set additional workspaces or enable
     * statistics and rendering information in response.
     * @param context Additional context that is passed through the Http pipeline during the service call. If no
     * additional context is required, pass {@link Context#NONE} instead.
     * @return The logs matching the query including the HTTP response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Response<LogsQueryResult> queryResourceWithResponse(String resourceId, String query, QueryTimeInterval timeInterval,
                                                                LogsQueryOptions options, Context context) {
        return asyncClient.queryResourceWithResponse(resourceId, query, timeInterval, options, context).block();
    }

    /**
     * Returns all the Azure Monitor logs matching the given query for an Azure resource.
     *
     * @param resourceId The resourceId where the query should be executed.
     * @param query The Kusto query to fetch the logs.
     * @param timeInterval The time period for which the logs should be looked up.
     * @param type The type the result of this query should be mapped to.
     * @param <T> The type the result of this query should be mapped to.
     * @param options The log query options to configure server timeout, set additional workspaces or enable
     * statistics and rendering information in response.
     * @param context Additional context that is passed through the Http pipeline during the service call. If no
     * additional context is required, pass {@link Context#NONE} instead.
     * @return The logs matching the query including the HTTP response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public <T> Response<List<T>> queryResourceWithResponse(String resourceId, String query, QueryTimeInterval timeInterval,
                                                            Class<T> type, LogsQueryOptions options, Context context) {
        return asyncClient.queryResourceWithResponse(resourceId, query, timeInterval, options, context)
            .map(response -> new SimpleResponse<>(response.getRequest(),
                response.getStatusCode(), response.getHeaders(),
                LogsQueryHelper.toObject(response.getValue().getTable(), type)))
            .block();
    }

}
