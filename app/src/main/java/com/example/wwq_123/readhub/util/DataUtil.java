package com.example.wwq_123.readhub.util;

import com.example.wwq_123.readhub.model.bean.CommonDataItem;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import com.example.wwq_123.readhub.model.bean.TopicDataItem;
import com.example.wwq_123.readhub.model.jsonbean.BlockchainData;
import com.example.wwq_123.readhub.model.jsonbean.JobData;
import com.example.wwq_123.readhub.model.jsonbean.NewsData;
import com.example.wwq_123.readhub.model.jsonbean.TechData;
import com.example.wwq_123.readhub.model.jsonbean.TopicData;


import java.util.ArrayList;
import java.util.List;

public class DataUtil {

    public DataUtil(){ }

    //从topic中提取所需的数据
    public List<TopicDataItem> extractTopic(TopicData topic){
        List<TopicDataItem> list = new ArrayList<>();
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
            List<CommonDataItem> newsDataItemList = new ArrayList<>();
            for (TopicData.DataBean.NewsArrayBean newsBean:bean.getNewsArray()) {
                CommonDataItem newsItem = new CommonDataItem();
                newsItem.setId(newsBean.getId());
                newsItem.setTitle(newsBean.getTitle());
                newsItem.setUrl(newsBean.getUrl());
                newsItem.setMobileUrl(newsBean.getMobileUrl());
                newsItem.setSiteName(newsBean.getSiteName());
                newsItem.setAuthorName(newsBean.getAuthorName());
                newsItem.setPublishDate(newsBean.getPublishDate());
                newsDataItemList.add(newsItem);
            }
            item.setNewsArray(newsDataItemList);
            list.add(item);
        }
        return list;
    }
    //从news中提取所需的数据
    public static List<CommonDataItem> extractTech(NewsData news){
        List<CommonDataItem> list = new ArrayList<>();
        for (NewsData.DataBean bean:news.getData()) {
            CommonDataItem item = new CommonDataItem();
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
            item.setStatus(0);
            list.add(item);

        }
        return list;
    }
    //从tech中提取所需的数据
    public static List<CommonDataItem> extractDeveloper(TechData tech){
        List<CommonDataItem> list = new ArrayList<>();
        for (TechData.DataBean bean:tech.getData()) {
            CommonDataItem item = new CommonDataItem();
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
            item.setStatus(0);
            list.add(item);
        }
        return list;
    }

    public static List<CommonDataItem> extractBlockchain(BlockchainData blockchain){
        List<CommonDataItem> list = new ArrayList<>();
        for (BlockchainData.DataBean bean:blockchain.getData()) {
            CommonDataItem item = new CommonDataItem();
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
            item.setStatus(0);
            list.add(item);
        }
        return list;
    }

    public static List<JobDataItem> extractJob(JobData job){
        List<JobDataItem> list = new ArrayList<>();
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
            List<JobArrayBean> beanList = new ArrayList<>();
            for (JobData.DataBean.JobsArrayBean arrayBean:bean.getJobsArray()) {
                JobArrayBean array = new JobArrayBean();
                array.setId(String.valueOf(arrayBean.getId()));
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
