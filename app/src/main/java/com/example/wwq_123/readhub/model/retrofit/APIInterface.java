package com.example.wwq_123.readhub.model.retrofit;


import com.example.wwq_123.readhub.model.retrofit.bean.BlockchainData;
import com.example.wwq_123.readhub.model.retrofit.bean.JobData;
import com.example.wwq_123.readhub.model.retrofit.bean.NewsData;
import com.example.wwq_123.readhub.model.retrofit.bean.TechData;
import com.example.wwq_123.readhub.model.retrofit.bean.TopicData;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface APIInterface {

    @GET("topic")
    Observable<TopicData> getTopicData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("topic")
    Observable<String> getString(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("news")
    Observable<NewsData> getNewsData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("technews")
    Observable<TechData> getTechsData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("blockchain")
    Observable<BlockchainData> getBlockchainData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);

    @GET("jobs")
    Observable<JobData> getJobData(@Query("lastCursor") String lastCursor , @Query("pageSize") int pageSize);
}
