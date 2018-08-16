package com.example.wwq_123.readhub.util;

import com.example.wwq_123.readhub.mvc.model.bean.Title;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.List;


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
}
