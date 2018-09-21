package com.example.wwq_123.readhub.view.job.detail;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wwq_123.readhub.R;
import com.example.wwq_123.readhub.base.BaseActivity;
import com.example.wwq_123.readhub.model.bean.JobDataItem;
import com.example.wwq_123.readhub.model.jsonbean.Chart;
import com.example.wwq_123.readhub.view.WebActivity;
import com.example.wwq_123.readhub.view.custom_ui.MyLoadingView;
import com.example.wwq_123.readhub.view.custom_ui.TitleBar;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
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
    private List<JobDataItem.JobsArrayBean> jobArrayList = new ArrayList<>();
    private JobArrayAdapter adapter;
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
        adapter = new JobArrayAdapter(this);
        jobArray.setAdapter(adapter);
        jobArray.setLayoutManager(new LinearLayoutManager(this));
        salary_chart = findViewById(R.id.job_detail_salary_chart);
        experience_chart = findViewById(R.id.job_detail_experience_chart);
        city_chart = findViewById(R.id.job_detail_city_chart);
        initSalaryChart();
        initExperienceChart();
        initCityChart();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        job = (JobDataItem) intent.getSerializableExtra("job");
        Log.d("job",job.toString());
        detail_title.setText(job.getJobTitle());
        String summmary = "北京、上海、深圳"
                +"等地共更新了"+job.getJobCount()+"个职位\n待遇集中在"
                +job.getSalaryLower()+"-"+job.getSalaryUpper()+"k\n一般要求"
                +job.getExperienceLower()+"-"+job.getExperienceUpper()+"年经验";
        detail_summary.setText(summmary);
        jobArrayList = job.getJobsArray();
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
        adapter.setListenter((v,position)->{
            Intent intent = new Intent(this, WebActivity.class);
            intent.putExtra("url",jobArrayList.get(position).getUrl());
            startActivity(intent);
        });
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
            Log.d("city:","X:"+cityBean.get(i).getXaxis()+"\tY"+cityBean.get(i).getYaxis());
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

    }

    class JobArrayAdapter extends RecyclerView.Adapter{
        private LayoutInflater inflater;
        private OnItemClickListenter listenter;
        public JobArrayAdapter(Context context){
            inflater = LayoutInflater.from(context);
        }
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.item_jobarray,parent,false);
            return new JobArrayViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((JobArrayViewHolder)holder).onBind(jobArrayList.get(position));
        }

        @Override
        public int getItemCount() {
            return jobArrayList.size();
        }

        public void setListenter(OnItemClickListenter listenter) {
            this.listenter = listenter;
        }
    }
    class JobArrayViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView ja_title,ja_company,ja_salary,ja_experience,ja_city,ja_site;
        private OnItemClickListenter listenter;
        public JobArrayViewHolder(View itemView) {
            super(itemView);
            ja_title = itemView.findViewById(R.id.jobArray_item_title);
            ja_company = itemView.findViewById(R.id.jobArray_item_company);
            ja_salary = itemView.findViewById(R.id.jobArray_item_salary);
            ja_experience = itemView.findViewById(R.id.jobArray_item_experience);
            ja_city = itemView.findViewById(R.id.jobArray_item_city);
            ja_site = itemView.findViewById(R.id.jobArray_item_site);
        }
        public void onBind(JobDataItem.JobsArrayBean bean){
            ja_title.setText(bean.getTitle());
            ja_company.setText(bean.getCompany());
            if (bean.getSalaryLower()==-1){
                ja_salary.setText("面议");
            }else {
                ja_salary.setText(bean.getSalaryLower()+"-"+bean.getSalaryUpper()+"k");
            }
            if (bean.getExperienceLower()==-1){
                ja_experience.setText("经验不限");
            }else {
                ja_experience.setText(bean.getExperienceLower()+"-"+bean.getExperienceUpper()+"年");
            }
            ja_city.setText(bean.getCity());
            ja_site.setText(bean.getSiteName());
        }
        @Override
        public void onClick(View v) {
            listenter.OnItemClick(v,getPosition());
        }
    }
    public interface OnItemClickListenter{
        void OnItemClick(View view,int position);
    }
}
