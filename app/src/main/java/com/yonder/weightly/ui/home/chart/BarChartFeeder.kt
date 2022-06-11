package com.yonder.weightly.ui.home.chart

import android.content.Context
import android.graphics.Color
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.yonder.weightly.domain.uimodel.WeightUIModel
import com.yonder.weightly.utils.extensions.EMPTY

object BarChartFeeder {

    fun setChartData(
        barChart: BarChart,
        histories: List<WeightUIModel?>,
        barEntries: List<BarEntry>,
        context: Context
    ) {
        val set1 = BarDataSet(barEntries, String.EMPTY)
        set1.valueFormatter = WeightValueFormatter(histories)
        set1.valueTextSize = 9f
        val xAxis = barChart.xAxis
        xAxis.valueFormatter = XAxisValueDateFormatter(histories)
        set1.color = Color.BLUE
        val dataSets: java.util.ArrayList<IBarDataSet> = ArrayList()
        dataSets.add(set1)
        val data = BarData(dataSets)
        barChart.data = data
        //Set marker view
        val markerView = WeightMarkerView(context, histories)
        markerView.chartView = barChart
        barChart.marker = markerView

        barChart.invalidate()
    }
}