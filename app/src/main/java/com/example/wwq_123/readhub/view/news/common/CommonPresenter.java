package com.example.wwq_123.readhub.view.news.common;

import com.example.wwq_123.readhub.base.BasePresenter;

public class CommonPresenter extends BasePresenter<CommonContract.View> implements CommonContract.Presenter {

    private CommonContract.View view;
    private TechPresenter techPresenter;
    private DeveloperPresenter developerPresenter;
    private BlockchainPresenter blockchainPresenter;

    public CommonPresenter(CommonContract.View view){
        this.view = view;
    }
    @Override
    public void getNews(int position) {
        switch (position){
            case 0:
                if (techPresenter==null){
                    techPresenter = new TechPresenter(view);
                }
                techPresenter.getTechNews();
                break;
            case 1:
                if (developerPresenter==null){
                    developerPresenter = new DeveloperPresenter(view);
                }
                developerPresenter.getDevelopNews();
                break;
            case 2:
                if (blockchainPresenter==null){
                    blockchainPresenter = new BlockchainPresenter(view);
                }
                blockchainPresenter.getBlockchainNews();
                break;
                default:break;
        }
    }

    @Override
    public void getMoreNews(int position) {
        switch (position){
            case 0:
                techPresenter.getMoreTechNews();
                break;
            case 1:
                developerPresenter.getMoreDevelopNews();
                break;
            case 2:
                blockchainPresenter.getMoreBlockchainNews();
                break;
            default:break;
        }
    }

    @Override
    public void updateNews(int position) {
        switch (position){
            case 0:
                techPresenter.getLatestTechNews();
                break;
            case 1:
                developerPresenter.getLatestDevelopNews();
                break;
            case 2:
                blockchainPresenter.getLatestBlockchainNews();
                break;
            default:break;
        }
    }
}
