package com.example.wwq_123.readhub.net.retrofit;

import com.example.wwq_123.readhub.model.bean.TopicDetail;
import com.example.wwq_123.readhub.model.jsonbean.BlockchainData;
import com.example.wwq_123.readhub.model.jsonbean.Chart;
import com.example.wwq_123.readhub.model.jsonbean.JobData;
import com.example.wwq_123.readhub.model.jsonbean.NewsData;
import com.example.wwq_123.readhub.model.jsonbean.TechData;
import com.example.wwq_123.readhub.model.jsonbean.TopicData;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public interface APIInterface {

    @GET("topic")
    Observable<TopicData> getTopicData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("topic/{id}")
    Observable<TopicDetail> getTopicDetail(@Path("id") String id);

    @GET("news")
    Observable<NewsData> getTechNews(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("technews")
    Observable<TechData> getDeveloperNews(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("blockchain")
    Observable<BlockchainData> getBlockchainNews(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("jobs")
    Observable<JobData> getJobData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("jobs/{id}/chart")
    Observable<Chart> getChart(@Path("id") String id);
}
