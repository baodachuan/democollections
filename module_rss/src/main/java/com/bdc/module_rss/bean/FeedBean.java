package com.bdc.module_rss.bean;

import java.util.List;

public class FeedBean {
    /**
     * results : [{"feedId":"feed/http://xueqiu.com/hots/topic/rss","score":205500,"lastUpdated":1569468180000,"coverage":0,"averageReadTime":0,"coverageScore":0,"estimatedEngagement":4,"tagCounts":{"投资":33,"财经":221,"财经资讯":66,"finance":74},"totalTagCount":587,"websiteTitle":"雪球 - 聪明的投资者都在这里","id":"feed/http://xueqiu.com/hots/topic/rss","title":"今日话题 - 雪球","updated":1569468180000,"velocity":986.1,"topics":["财经资讯","finance","news","新闻","投资"],"subscribers":2056,"website":"http://xueqiu.com/hots/topic","partial":false,"iconUrl":"http://storage.googleapis.com/site-assets/WwGDm_ZgE2wA_UB9c36C-r0hJf81SaxM9f3jmuREOpc_sicon-1483f27e1f3","visualUrl":"http://storage.googleapis.com/site-assets/WwGDm_ZgE2wA_UB9c36C-r0hJf81SaxM9f3jmuREOpc_svisual-14b8b1cbe31","contentType":"longform","language":"zh","description":"雪球是一个社交投资网络，「今日话题」是雪球用户每日发布的投资交流精选。","deliciousTags":["财经","finance","财经资讯","投资"]},{"feedId":"feed/https://rsshub.app/xueqiu/hots","score":1000,"lastUpdated":1569463800000,"coverage":0,"averageReadTime":0,"coverageScore":0,"id":"feed/https://rsshub.app/xueqiu/hots","title":"热帖 - 雪球","updated":1569463800000,"velocity":80.6,"subscribers":10,"website":"https://xueqiu.com/","language":"zh","description":"雪球热门帖子 - Made with love by RSSHub(https://github.com/DIYgod/RSSHub)"},{"feedId":"feed/http://engineering.xueqiu.com/atom.xml","score":660,"lastUpdated":1435274880000,"coverage":0,"averageReadTime":0,"coverageScore":0,"websiteTitle":"Xueqiu Engineering Blog","id":"feed/http://engineering.xueqiu.com/atom.xml","title":"Xueqiu Engineering Blog","updated":1435274880000,"velocity":0.01,"subscribers":66,"website":"http://xueqiu.github.io/","partial":false,"iconUrl":"http://storage.googleapis.com/site-assets/9I37ccq-H7pBVoUkyYesuaWFSM9FJ17qE0ulwS4DWSM_sicon-1542866bff9","visualUrl":"http://storage.googleapis.com/site-assets/9I37ccq-H7pBVoUkyYesuaWFSM9FJ17qE0ulwS4DWSM_svisual-1542866bff9","state":"dormant","contentType":"article","language":"en","description":"合理堆大小的设置 基本上所有会写Java的人也都知道怎么设置堆相关的参数，会设置但并不意味着这个是一个简单事情。常见的OOM问题，大部分都是因为不恰当的堆设置引起的。 该给Java进程配置多大的堆？ 换个方式问这个问题：\n大堆、小堆对Java进程会有怎样的影响？ 对Java程序而言， \u2026"}]
     * queryType : term
     * scheme : txt:b:o
     */

    private String queryType;
    private String scheme;
    private List<ResultsBean> results;

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * feedId : feed/http://xueqiu.com/hots/topic/rss
         * score : 205500.0
         * lastUpdated : 1569468180000
         * coverage : 0.0
         * averageReadTime : 0.0
         * coverageScore : 0.0
         * estimatedEngagement : 4
         * tagCounts : {"投资":33,"财经":221,"财经资讯":66,"finance":74}
         * totalTagCount : 587
         * websiteTitle : 雪球 - 聪明的投资者都在这里
         * id : feed/http://xueqiu.com/hots/topic/rss
         * title : 今日话题 - 雪球
         * updated : 1569468180000
         * velocity : 986.1
         * topics : ["财经资讯","finance","news","新闻","投资"]
         * subscribers : 2056
         * website : http://xueqiu.com/hots/topic
         * partial : false
         * iconUrl : http://storage.googleapis.com/site-assets/WwGDm_ZgE2wA_UB9c36C-r0hJf81SaxM9f3jmuREOpc_sicon-1483f27e1f3
         * visualUrl : http://storage.googleapis.com/site-assets/WwGDm_ZgE2wA_UB9c36C-r0hJf81SaxM9f3jmuREOpc_svisual-14b8b1cbe31
         * contentType : longform
         * language : zh
         * description : 雪球是一个社交投资网络，「今日话题」是雪球用户每日发布的投资交流精选。
         * deliciousTags : ["财经","finance","财经资讯","投资"]
         * state : dormant
         */

        private String feedId;
        private double score;
        private long lastUpdated;
        private double coverage;
        private double averageReadTime;
        private double coverageScore;
        private int estimatedEngagement;
        private int totalTagCount;
        private String websiteTitle;
        private String id;
        private String title;
        private long updated;
        private double velocity;
        private int subscribers;
        private String website;
        private boolean partial;
        private String iconUrl;
        private String visualUrl;
        private String contentType;
        private String language;
        private String description;
        private String state;
        private List<String> topics;
        private List<String> deliciousTags;

        public String getFeedId() {
            return feedId;
        }

        public void setFeedId(String feedId) {
            this.feedId = feedId;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public long getLastUpdated() {
            return lastUpdated;
        }

        public void setLastUpdated(long lastUpdated) {
            this.lastUpdated = lastUpdated;
        }

        public double getCoverage() {
            return coverage;
        }

        public void setCoverage(double coverage) {
            this.coverage = coverage;
        }

        public double getAverageReadTime() {
            return averageReadTime;
        }

        public void setAverageReadTime(double averageReadTime) {
            this.averageReadTime = averageReadTime;
        }

        public double getCoverageScore() {
            return coverageScore;
        }

        public void setCoverageScore(double coverageScore) {
            this.coverageScore = coverageScore;
        }

        public int getEstimatedEngagement() {
            return estimatedEngagement;
        }

        public void setEstimatedEngagement(int estimatedEngagement) {
            this.estimatedEngagement = estimatedEngagement;
        }



        public int getTotalTagCount() {
            return totalTagCount;
        }

        public void setTotalTagCount(int totalTagCount) {
            this.totalTagCount = totalTagCount;
        }

        public String getWebsiteTitle() {
            return websiteTitle;
        }

        public void setWebsiteTitle(String websiteTitle) {
            this.websiteTitle = websiteTitle;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public long getUpdated() {
            return updated;
        }

        public void setUpdated(long updated) {
            this.updated = updated;
        }

        public double getVelocity() {
            return velocity;
        }

        public void setVelocity(double velocity) {
            this.velocity = velocity;
        }

        public int getSubscribers() {
            return subscribers;
        }

        public void setSubscribers(int subscribers) {
            this.subscribers = subscribers;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public boolean isPartial() {
            return partial;
        }

        public void setPartial(boolean partial) {
            this.partial = partial;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getVisualUrl() {
            return visualUrl;
        }

        public void setVisualUrl(String visualUrl) {
            this.visualUrl = visualUrl;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public List<String> getTopics() {
            return topics;
        }

        public void setTopics(List<String> topics) {
            this.topics = topics;
        }

        public List<String> getDeliciousTags() {
            return deliciousTags;
        }

        public void setDeliciousTags(List<String> deliciousTags) {
            this.deliciousTags = deliciousTags;
        }

        @Override
        public String toString() {
            return "ResultsBean{" +
                    "feedId='" + feedId + '\'' +
                    ", id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", updated=" + updated +
                    '}';
        }
    }



}
