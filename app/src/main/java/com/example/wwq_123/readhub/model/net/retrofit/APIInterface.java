package com.example.wwq_123.readhub.model.net.retrofit;

import com.example.wwq_123.readhub.model.jsonbean.BlockchainData;
import com.example.wwq_123.readhub.model.jsonbean.JobData;
import com.example.wwq_123.readhub.model.jsonbean.NewsData;
import com.example.wwq_123.readhub.model.jsonbean.TechData;
import com.example.wwq_123.readhub.model.jsonbean.TopicData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface APIInterface {

    @GET("/")
    Observable<String> getTabTitle();

    @GET("topic")
    Observable<TopicData> getTopicData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("news")
    Observable<NewsData> getNewsData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("technews")
    Observable<TechData> getTechsData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("blockchain")
    Observable<BlockchainData> getBlockchainData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("jobs")
    Observable<JobData> getJobData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);
}
