package com.example.wwq_123.readhub.view.job.detail;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.example.wwq_123.readhub.model.bean.JobArrayBean;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import com.example.wwq_123.readhub.model.jsonbean.Chart;
import com.example.wwq_123.readhub.view.custom_ui.MyItemDecoration;
import com.example.wwq_123.readhub.view.custom_ui.TitleBar;
import com.example.wwq_123.readhub.view.favoritejob.FavoriteJobAdapter;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import java.util.ArrayList;
import java.util.List;

public class JobDetailActivity extends BaseActivity implements JobDetailContract.View {
    private TitleBar titleBar;
    private TextView detail_title,detail_summary;
    private LineChart salary_chart,experience_chart;
    private BarChart city_chart;
    private RecyclerView jobArray;
    private JobDetailPresenter presenter;
    private JobDataItem job;
    private FavoriteJobAdapter adapter;
    @Override
    public int getLayoutId() {
        return R.layout.activity_job_detail;
    }

    @Override
    public void initView() {
        titleBar = findViewById(R.id.job_detail_titlebar);
        detail_title = findViewById(R.id.job_detail_title);
        detail_summary = findViewById(R.id.job_detail_summary);
        jobArray = findViewById(R.id.job_detail_jobArray);
        salary_chart = findViewById(R.id.job_detail_salary_chart);
        experience_chart = findViewById(R.id.job_detail_experience_chart);
        city_chart = findViewById(R.id.job_detail_city_chart);
        initRecycleView();
        initSalaryChart();
        initExperienceChart();
        initCityChart();
    }

    private void initRecycleView() {
        adapter = new FavoriteJobAdapter(this);
        adapter.setShowdelete(false);
        jobArray.setAdapter(adapter);
        jobArray.addItemDecoration(new MyItemDecoration().setTop(5).setBottom(5));
        jobArray.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        job = (JobDataItem) intent.getSerializableExtra("job");
        detail_title.setText(job.getJobTitle());
        String summmary = "北京、上海、深圳"
                +"等地共更新了"+job.getJobCount()+"个职位\n待遇集中在"
                +job.getSalaryLower()+"-"+job.getSalaryUpper()+"k\n一般要求"
                +job.getExperienceLower()+"-"+job.getExperienceUpper()+"年经验";
        detail_summary.setText(summmary);
        adapter.setList(job.getJobsArray());
        if (presenter==null){
            presenter = new JobDetailPresenter(this);
        }
        presenter.getChart(String.valueOf(job.getId()));
    }

    @Override
    public void initTitleBar() {
        titleBar.setTitle("职位详情");
        titleBar.setLeftImage(R.drawable.ic_common_back);
        titleBar.setListener((v)->onBackPressed());
    }

    @Override
    public void initEvent() {

    }

    private void initCityChart() {
        city_chart.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        city_chart.getAxisLeft().setEnabled(false);
        city_chart.getAxisRight().setEnabled(false);
        city_chart.setTouchEnabled(false);
        city_chart.setNoDataText("Loading Data...");
        XAxis xAxis = city_chart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawLabels(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);
        xAxis.setLabelCount(10,false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
    }

    private void initExperienceChart() {
        experience_chart.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        experience_chart.getAxisLeft().setEnabled(false);
        experience_chart.getAxisRight().setEnabled(false);
        experience_chart.setTouchEnabled(false);
        experience_chart.setNoDataText("Loading Data...");
        XAxis xAxis = experience_chart.getXAxis();
        xAxis.setEnabled(true);            // 轴线是否可编辑,默认true
        xAxis.setDrawLabels(true);          // 是否绘制标签,默认true
        xAxis.setDrawAxisLine(true);        // 是否绘制坐标轴,默认true
        xAxis.setDrawGridLines(false);      // 是否绘制网格线，默认true
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(12f);
        xAxis.setValueFormatter(((value, axis) -> value+"年"));
    }

    private void initSalaryChart() {
        salary_chart.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        salary_chart.getAxisLeft().setEnabled(false);
        salary_chart.getAxisRight().setEnabled(false);
        salary_chart.setTouchEnabled(false);
        salary_chart.setNoDataText("Loading Data...");
        XAxis xAxis = salary_chart.getXAxis();
        xAxis.setEnabled(true);
        xAxis.setDrawLabels(true);
        xAxis.setDrawAxisLine(true);
        xAxis.setDrawGridLines(false);   // 是否绘制网格线，默认true
        xAxis.setTextSize(12f);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(((value,axis)->value+"k"));
    }

    @Override
    public void showChart(Chart chart) {
        showSalaryChart(chart.getSalary().getData());
        showExperienceChart(chart.getExperience().getData());
        showCityChart(chart.getCity().getData());
    }

    private void showCityChart(List<Chart.CityBean.DataBeanXX> cityBean) {
        List<BarEntry> cityEntry = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        for (int i=0,size=cityBean.size();i<size;i++){
            cities.add(cityBean.get(i).getXaxis());
            cityEntry.add(new BarEntry(i,cityBean.get(i).getYaxis()));
        }
        BarDataSet citySet = new BarDataSet(cityEntry,"城市分布");
        citySet.setValueTextSize(10);
        citySet.setColor(getResources().getColor(R.color.b4));
        List<IBarDataSet> iBarDataSets = new ArrayList<>();
        iBarDataSets.add(citySet);
        BarData barData = new BarData(iBarDataSets);
        city_chart.setData(barData);
        XAxis xAxis = city_chart.getXAxis();
        xAxis.setValueFormatter(((value, axis) -> cityBean.get((int)value).getXaxis()));
    }

    private void showExperienceChart(List<Chart.ExperienceBean.DataBeanX> experienceBean) {
        List<Entry> entries = new ArrayList<>();
        for (Chart.ExperienceBean.DataBeanX bean:experienceBean) {
            entries.add(new Entry(Float.parseFloat(bean.getXaxis()),bean.getYaxis()));
        }
        LineDataSet experienceSet = new LineDataSet(entries,"经验要求分布");
        experienceSet.setValueTextSize(10);
        experienceSet.setDrawFilled(true);
        experienceSet.setFillColor(getResources().getColor(R.color.b3));
        experienceSet.setColor(getResources().getColor(R.color.b3));
        experienceSet.setDrawCircles(false);
        experienceSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        List<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(experienceSet);
        LineData lineData = new LineData(iLineDataSets);
        experience_chart.setData(lineData);
    }

    private void showSalaryChart(List<Chart.SalaryBean.DataBean> salaryBean) {
        List<Entry> entries = new ArrayList<>();
        for (Chart.SalaryBean.DataBean bean:salaryBean) {
            entries.add(new Entry(Float.parseFloat(bean.getXaxis()),bean.getYaxis()));
        }
        LineDataSet salarySet = new LineDataSet(entries,"资薪分布");
        salarySet.setValueTextSize(10);
        salarySet.setDrawFilled(true);
        salarySet.setFillColor(getResources().getColor(R.color.b3));
        salarySet.setColor(getResources().getColor(R.color.b3));
        salarySet.setDrawCircles(false);
        salarySet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        List<ILineDataSet> iLineDataSets = new ArrayList<>();
        iLineDataSets.add(salarySet);
        LineData lineData = new LineData(iLineDataSets);
        salary_chart.setData(lineData);
        salary_chart.setDescription(new Description());
    }

}
