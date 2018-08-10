package com.example.wwq_123.readhub.util;

import com.example.wwq_123.readhub.model.bean.ContentItem;
import com.example.wwq_123.readhub.model.bean.Link;
import com.example.wwq_123.readhub.model.bean.Title;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HtmlUtil {


    public static List<Title> getTitle(String htmlData){
        Document document = Jsoup.parse(htmlData);
        Elements links = document.select("div.content___2NWFu nav.nc_clearfix a");
        List<Title> titleList = new ArrayList<>();
        for (Element link:links) {
            Title title = new Title();
            title.setHref(link.attr("href"));
            title.setName(link.text());
            titleList.add(title);
        }
        return titleList;
    }
    public static List<ContentItem> getHotTopic(String htmlData){
        Document document = Jsoup.parse(htmlData);
        Elements links = document.select("div.topicItem___3YVLI");
        List<ContentItem> contentItems = new ArrayList<>();
        for (Element link:links) {
            ContentItem item = new ContentItem();
            item.setTitle(link.select("h2 span.content___2vSS6").text());       //获取标题
            item.setSummary(link.select("div.bp-pure___3xB_W").text());     //获取内容
            item.setUrl(link.select("a.topicLink___2YkaP").attr("href"));      //获取链接
            contentItems.add(item);
        }
        return contentItems;
    }

    public static List<ContentItem> getTech(String htmlData){
        Document document = Jsoup.parse(htmlData);
        Elements links = document.select("div.timelineItem___1T6m9");
        List<ContentItem> contentItems = new ArrayList<>();
        for (Element link:links) {
            ContentItem item = new ContentItem();
            item.setTitle(link.select("h2.enableVisited").text());       //获取标题
            item.setSummary(link.select("div.bp-pure___3xB_W").text());     //获取内容
            item.setUrl(link.select("h2.enableVisited a").attr("href"));      //获取链接
            item.setAuthor(link.select("div.meta___1ARPK span").text());    //获取作者
            item.setTime(link.select("div.meta___1ARPK span i").text());    //获取时间
            contentItems.add(item);
        }
        return contentItems;
    }
    public static List<ContentItem> getBlockchain(String htmlData){
        Document document = Jsoup.parse(htmlData);
        Elements links = document.select("div.timelineItem___1T6m9");
        List<ContentItem> contentItems = new ArrayList<>();
        for (Element link:links) {
            ContentItem item = new ContentItem();
            item.setTitle(link.select("h2").text());       //获取标题
            item.setSummary(link.select("div.bp-pure___3xB_W").text());     //获取内容
            item.setUrl(link.select("h2 a").attr("href"));      //获取链接
            item.setAuthor(link.select("div.meta___1ARPK span").text());    //获取作者
            item.setTime(link.select("div.meta___1ARPK span i").text());    //获取时间
            contentItems.add(item);
        }
        return contentItems;
    }
    public static void getJobs(String htmlData){
        Document document = Jsoup.parse(htmlData);
        Elements links = document.select("div.timelineItem___1T6m9");
        List<ContentItem> contentItems = new ArrayList<>();
        for (Element link:links) {
            ContentItem item = new ContentItem();
            item.setTitle(link.select("h2").text());       //获取标题
            item.setSummary(link.select("div.bp-pure___3xB_W").text());     //获取内容
            item.setUrl(link.select("h2 a").attr("href"));      //获取链接
            item.setAuthor(link.select("div.meta___1ARPK span").text());    //获取作者
            item.setTime(link.select("div.meta___1ARPK span i").text());    //获取时间
        }
    }

    public String traverseLinks(Map<String,String> map){
        String content = "";
        for (Map.Entry<String, String> entry : map.entrySet()) {
            content = content+"href:"+entry.getKey()+"\ttext:"+entry.getValue()+"\n";
        }
        if (content.equals("")){
            return "content is null;";
        }else {
            return content;
        }
    }

    public List<Link> getItemLinks(String htmlData){
        Document document = Jsoup.parse(htmlData);
        ContentItem contentItem = new ContentItem();

        Elements elements = document.select("ul.timeline__container___3jHS8");
        List<Link> links = new ArrayList<>();
        for (Element e:elements) {
            Link link = new Link();
            link.setTitle(e.select("a").text());//获取标题
            link.setUrl(e.select("a").attr("href"));//获取链接
            links.add(link);
        }
        return links;
    }
}
