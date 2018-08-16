package com.example.wwq_123.readhub.mvc.presenter;

import com.example.wwq_123.readhub.mvc.model.bean.DataItem;

public interface Presenter {

    public interface LoadTabTitlePresenter{
        public abstract void loadTabTitle();
    }

    public interface LoadDataPresenter{
        public abstract void loadData(int fragmentId);
    }
    public interface LoadMoreDataPresenter{
        public abstract void loadMoreData(int fragmentId, DataItem item);
    }
}
