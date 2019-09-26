package com.bdc.module_rss.net;

import com.bdc.lib_common.net.BaseNet;

public class FeedNet extends BaseNet<FeedApi> {

    public static FeedNet getInstance() {
        return INSTANCE;
    }

    private static final FeedNet INSTANCE = new FeedNet();

    @Override
    protected String getDefaultBaseUrl() {
        return FeedApi.BASE_URL;
    }

    private FeedNet() {

    }

    public static FeedApi api(){
        return INSTANCE.getApi();
    }






}
