package software.amazon.awssdk.services.jsonprotocoltests.paginators;

import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import org.reactivestreams.Subscriber;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.core.async.SdkPublisher;
import software.amazon.awssdk.core.pagination.async.AsyncPageFetcher;
import software.amazon.awssdk.core.pagination.async.PaginatedItemsPublisher;
import software.amazon.awssdk.core.pagination.async.ResponsesSubscription;
import software.amazon.awssdk.services.jsonprotocoltests.JsonProtocolTestsAsyncClient;
import software.amazon.awssdk.services.jsonprotocoltests.internal.UserAgentUtils;
import software.amazon.awssdk.services.jsonprotocoltests.model.PaginatedOperationWithResultKeyAndMoreResultsRequest;
import software.amazon.awssdk.services.jsonprotocoltests.model.PaginatedOperationWithResultKeyAndMoreResultsResponse;
import software.amazon.awssdk.services.jsonprotocoltests.model.SimpleStruct;

/**
 * <p>
 * Represents the output for the
 * {@link software.amazon.awssdk.services.jsonprotocoltests.JsonProtocolTestsAsyncClient#paginatedOperationWithResultKeyAndMoreResultsPaginator(software.amazon.awssdk.services.jsonprotocoltests.model.PaginatedOperationWithResultKeyAndMoreResultsRequest)}
 * operation which is a paginated operation. This class is a type of {@link org.reactivestreams.Publisher} which can be
 * used to provide a sequence of
 * {@link software.amazon.awssdk.services.jsonprotocoltests.model.PaginatedOperationWithResultKeyAndMoreResultsResponse}
 * response pages as per demand from the subscriber.
 * </p>
 * <p>
 * When the operation is called, an instance of this class is returned. At this point, no service calls are made yet and
 * so there is no guarantee that the request is valid. If there are errors in your request, you will see the failures
 * only after you start streaming the data. The subscribe method should be called as a request to start streaming data.
 * For more info, see {@link org.reactivestreams.Publisher#subscribe(org.reactivestreams.Subscriber)}. Each call to the
 * subscribe method will result in a new {@link org.reactivestreams.Subscription} i.e., a new contract to stream data
 * from the starting request.
 * </p>
 *
 * <p>
 * The following are few ways to use the response class:
 * </p>
 * 1) Using the subscribe helper method
 *
 * <pre>
 * {@code
 * software.amazon.awssdk.services.jsonprotocoltests.paginators.PaginatedOperationWithResultKeyAndMoreResultsPublisher publisher = client.paginatedOperationWithResultKeyAndMoreResultsPaginator(request);
 * CompletableFuture<Void> future = publisher.subscribe(res -> { // Do something with the response });
 * future.get();
 * }
 * </pre>
 *
 * 2) Using a custom subscriber
 *
 * <pre>
 * {@code
 * software.amazon.awssdk.services.jsonprotocoltests.paginators.PaginatedOperationWithResultKeyAndMoreResultsPublisher publisher = client.paginatedOperationWithResultKeyAndMoreResultsPaginator(request);
 * publisher.subscribe(new Subscriber<software.amazon.awssdk.services.jsonprotocoltests.model.PaginatedOperationWithResultKeyAndMoreResultsResponse>() {
 *
 * public void onSubscribe(org.reactivestreams.Subscriber subscription) { //... };
 *
 *
 * public void onNext(software.amazon.awssdk.services.jsonprotocoltests.model.PaginatedOperationWithResultKeyAndMoreResultsResponse response) { //... };
 * });}
 * </pre>
 *
 * As the response is a publisher, it can work well with third party reactive streams implementations like RxJava2.
 * <p>
 * <b>Please notice that the configuration of MaxResults won't limit the number of results you get with the paginator.
 * It only limits the number of results in each page.</b>
 * </p>
 * <p>
 * <b>Note: If you prefer to have control on service calls, use the
 * {@link #paginatedOperationWithResultKeyAndMoreResults(software.amazon.awssdk.services.jsonprotocoltests.model.PaginatedOperationWithResultKeyAndMoreResultsRequest)}
 * operation.</b>
 * </p>
 */
@Generated("software.amazon.awssdk:codegen")
public class PaginatedOperationWithResultKeyAndMoreResultsPublisher implements
                                                                    SdkPublisher<PaginatedOperationWithResultKeyAndMoreResultsResponse> {
    private final JsonProtocolTestsAsyncClient client;

    private final PaginatedOperationWithResultKeyAndMoreResultsRequest firstRequest;

    private final AsyncPageFetcher nextPageFetcher;

    private boolean isLastPage;

    public PaginatedOperationWithResultKeyAndMoreResultsPublisher(JsonProtocolTestsAsyncClient client,
                                                                  PaginatedOperationWithResultKeyAndMoreResultsRequest firstRequest) {
        this(client, firstRequest, false);
    }

    private PaginatedOperationWithResultKeyAndMoreResultsPublisher(JsonProtocolTestsAsyncClient client,
                                                                   PaginatedOperationWithResultKeyAndMoreResultsRequest firstRequest, boolean isLastPage) {
        this.client = client;
        this.firstRequest = UserAgentUtils.applyPaginatorUserAgent(firstRequest);
        this.isLastPage = isLastPage;
        this.nextPageFetcher = new PaginatedOperationWithResultKeyAndMoreResultsResponseFetcher();
    }

    @Override
    public void subscribe(Subscriber<? super PaginatedOperationWithResultKeyAndMoreResultsResponse> subscriber) {
        subscriber.onSubscribe(ResponsesSubscription.builder().subscriber(subscriber).nextPageFetcher(nextPageFetcher).build());
    }

    /**
     * Returns a publisher that can be used to get a stream of data. You need to subscribe to the publisher to request
     * the stream of data. The publisher has a helper forEach method that takes in a {@link java.util.function.Consumer}
     * and then applies that consumer to each response returned by the service.
     */
    public final SdkPublisher<SimpleStruct> items() {
        Function<PaginatedOperationWithResultKeyAndMoreResultsResponse, Iterator<SimpleStruct>> getIterator = response -> {
            if (response != null && response.items() != null) {
                return response.items().iterator();
            }
            return Collections.emptyIterator();
        };
        return PaginatedItemsPublisher.builder()
                                      .nextPageFetcher(new PaginatedOperationWithResultKeyAndMoreResultsResponseFetcher())
                                      .iteratorFunction(getIterator).isLastPage(isLastPage).build();
    }

    private class PaginatedOperationWithResultKeyAndMoreResultsResponseFetcher implements
                                                                               AsyncPageFetcher<PaginatedOperationWithResultKeyAndMoreResultsResponse> {
        @Override
        public boolean hasNextPage(final PaginatedOperationWithResultKeyAndMoreResultsResponse previousPage) {
            return previousPage.truncated() != null && previousPage.truncated().booleanValue();
        }

        @Override
        public CompletableFuture<PaginatedOperationWithResultKeyAndMoreResultsResponse> nextPage(
            final PaginatedOperationWithResultKeyAndMoreResultsResponse previousPage) {
            if (previousPage == null) {
                return client.paginatedOperationWithResultKeyAndMoreResults(firstRequest);
            }
            return client.paginatedOperationWithResultKeyAndMoreResults(firstRequest.toBuilder()
                                                                                    .nextToken(previousPage.nextToken()).build());
        }
    }
}
