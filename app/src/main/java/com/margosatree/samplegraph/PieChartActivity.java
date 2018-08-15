package com.margosatree.samplegraph;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    private PieChart pieChart;
    private ArrayList<PieEntry> pieEntries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);
        pieChart = findViewById(R.id.pie_chart);
        initPieChart();
    }

    private void initPieChart() {
        pieChart.setUsePercentValues(true);
        pieChart.getDescription().setEnabled(false);
        pieChart.setExtraOffsets(5, 10, 5, 5);

        pieChart.setDragDecelerationFrictionCoef(0.99f);
        pieChart.setDrawHoleEnabled(true);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleRadius(60f);

        pieEntries.add(new PieEntry(34f, "USA"));
        pieEntries.add(new PieEntry(23f, "Aus"));
        pieEntries.add(new PieEntry(14f, "Rus"));
        pieEntries.add(new PieEntry(35f, "Ind"));
        pieEntries.add(new PieEntry(40f, "Eng"));

        PieDataSet dataSet = new PieDataSet(pieEntries, "countries");
        dataSet.setSliceSpace(3f);
//        dataSet.setSelectionShift(2f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(14f);
        data.setValueTextColor(Color.WHITE);

        pieChart.animateX(1000, Easing.EasingOption.EaseInOutCubic);
        pieChart.setData(data);


    }
}
