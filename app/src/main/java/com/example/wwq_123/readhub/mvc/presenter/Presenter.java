package com.example.wwq_123.readhub.mvc.presenter;

import com.example.wwq_123.readhub.mvc.model.bean.DataItem;

public interface Presenter {

    interface LoadTabTitlePresenter{
         void loadTabTitle();
    }

    interface LoadDataPresenter{
        void loadData(int fragmentId);
    }
    interface LoadMoreDataPresenter{
        void loadMoreData(int fragmentId, DataItem item);
    }
    interface UpdateDataPresenter{
        void updateData(int fragmentId,DataItem item);
    }
}
