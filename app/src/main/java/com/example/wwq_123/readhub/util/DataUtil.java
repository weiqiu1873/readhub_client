package com.example.wwq_123.readhub.util;

import com.example.wwq_123.readhub.mvc.model.bean.DataItem;
import com.example.wwq_123.readhub.mvc.model.bean.JobDataItem;
import com.example.wwq_123.readhub.mvc.model.bean.NewsDataItem;
import com.example.wwq_123.readhub.mvc.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.mvc.model.jsonbean.BlockchainData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.JobData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.NewsData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.TechData;
import com.example.wwq_123.readhub.mvc.model.jsonbean.TopicData;

import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public DataUtil(){ }

    //从topic中提取所需的数据
    public List<DataItem> extractTopic(TopicData topic){
        List<DataItem> list = new ArrayList<>();
        for (TopicData.DataBean bean: topic.getData()) {
            TopicDataItem item = new TopicDataItem();
            item.setUrl(bean.getId());
            item.setCreatedAt(bean.getCreatedAt());
            item.setOrder(bean.getOrder());
            item.setPublishDate(bean.getPublishDate());
            item.setSummary(bean.getSummary());
            item.setTitle(bean.getTitle());
            item.setUpdatedAt(bean.getUpdatedAt());
            item.setTimeline(bean.getTimeline());
            List<NewsDataItem> newsDataItemList = new ArrayList<>();
            for (TopicData.DataBean.NewsArrayBean newsBean:bean.getNewsArray()) {
                NewsDataItem newsItem = new NewsDataItem();
                newsItem.setId(newsBean.getId());
                newsItem.setTitle(newsBean.getTitle());
                newsItem.setUrl(newsBean.getUrl());
                newsItem.setMobileUrl(newsBean.getMobileUrl());
                newsItem.setSiteName(newsBean.getSiteName());
                newsItem.setAuthorName(newsBean.getAuthorName());
                newsItem.setPublishDate(newsBean.getPublishDate());
                newsItem.setSiteSlug(newsBean.getSiteSlug());
                newsDataItemList.add(newsItem);
            }
            item.setNewsArray(newsDataItemList);
            list.add(item);
        }
        return list;
    }
    //从news中提取所需的数据
    public List<DataItem> extractNews(NewsData news){
        List<DataItem> list = new ArrayList<>();
        for (NewsData.DataBean bean:news.getData()) {
            NewsDataItem item = new NewsDataItem();
            item.setId(bean.getId());
            item.setTitle(bean.getTitle());
            item.setSummary(bean.getSummary());
            item.setSummaryAuto(bean.getSummaryAuto());
            item.setUrl(bean.getUrl());
            item.setMobileUrl(bean.getMobileUrl());
            item.setSiteName(bean.getSiteName());
            item.setAuthorName(bean.getAuthorName());
            item.setLanguage(bean.getLanguage());
            item.setPublishDate(bean.getPublishDate());
            item.setSiteSlug(bean.getSiteSlug());
            list.add(item);
        }
        return list;
    }
    //从tech中提取所需的数据
    public List<DataItem> extractTech(TechData tech){
        List<DataItem> list = new ArrayList<>();
        for (TechData.DataBean bean:tech.getData()) {
            DataItem item = new DataItem();
            item.setId(bean.getId());
            item.setTitle(bean.getTitle());
            item.setSummary(bean.getSummary());
            item.setSummaryAuto(bean.getSummaryAuto());
            item.setUrl(bean.getUrl());
            item.setMobileUrl(bean.getMobileUrl());
            item.setSiteName(bean.getSiteName());
            item.setAuthorName(bean.getAuthorName());
            item.setLanguage(bean.getLanguage());
            item.setPublishDate(bean.getPublishDate());
            list.add(item);
        }
        return list;
    }

    public List<DataItem> extractBlockchain(BlockchainData blockchain){
        List<DataItem> list = new ArrayList<>();
        for (BlockchainData.DataBean bean:blockchain.getData()) {
            DataItem item = new DataItem();
            item.setId(bean.getId());
            item.setTitle(bean.getTitle());
            item.setSummary(bean.getSummary());
            item.setSummaryAuto(bean.getSummaryAuto());
            item.setUrl(bean.getUrl());
            item.setMobileUrl(bean.getMobileUrl());
            item.setSiteName(bean.getSiteName());
            item.setAuthorName(bean.getAuthorName());
            item.setLanguage(bean.getLanguage());
            item.setPublishDate(bean.getPublishDate());
            list.add(item);
        }
        return list;
    }

    public List<DataItem> extractJob(JobData job){
        List<DataItem> list = new ArrayList<>();
        for (JobData.DataBean bean:job.getData()) {
            JobDataItem item = new JobDataItem();
            item.setId(bean.getId());
            item.setUuid(bean.getUuid());
            item.setJobTitle(bean.getJobTitle());
            item.setJobCount(bean.getJobCount());
            item.setCompanyCount(bean.getCompanyCount());
            item.setSalaryLower(bean.getSalaryLower());
            item.setSalaryUpper(bean.getSalaryUpper());
            item.setExperienceLower(bean.getExperienceLower());
            item.setExperienceUpper(bean.getExperienceUpper());
            item.setPublishDate(bean.getPublishDate());
            item.setCreatedAt(bean.getCreatedAt());
            List<JobDataItem.JobsArrayBean> beanList = new ArrayList<>();
            for (JobData.DataBean.JobsArrayBean arrayBean:bean.getJobsArray()) {
                JobDataItem.JobsArrayBean array = new JobDataItem.JobsArrayBean();
                array.setId(arrayBean.getId());
                array.setCity(arrayBean.getCity());
                array.setCompany(arrayBean.getCompany());
                array.setUrl(arrayBean.getUrl());
                array.setTitle(arrayBean.getTitle());
                array.setSponsor(arrayBean.isSponsor());
                array.setSiteName(arrayBean.getSiteName());
                array.setSalaryLower(arrayBean.getSalaryLower());
                array.setSalaryUpper(arrayBean.getSalaryUpper());
                array.setExperienceLower(arrayBean.getExperienceLower());
                array.setExperienceUpper(arrayBean.getExperienceUpper());
                beanList.add(array);
            }
            item.setJobsArray(beanList);
            list.add(item);
        }
        return list;
    }
}
