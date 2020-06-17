package CollectionOfFunctionalMethods.ReportDataStatistics;
import java.awt.Font;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import CollectionOfFunctionalMethods.DatabaseRelatedMethods.DataBase;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class LimeSeriesChartStatistics {
    ChartPanel frame1;
    public LimeSeriesChartStatistics(){
        DefaultCategoryDataset xydataset = (DefaultCategoryDataset) ColumnChartStatistics.getDataSet();
        JFreeChart chart = ChartFactory.createLineChart("订单数量每日统计图", // 折线图名称
                "时间", // 横坐标名称
                "订单数", // 纵坐标名称
                xydataset, // 数据
                PlotOrientation.VERTICAL, // 水平显示图像
                true, // include legend
                true, // tooltips
                false // urls
        );
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinesVisible(true); // 是否显示格子线
        plot.setBackgroundAlpha(0.3f); // 设置背景透明度
        frame1=new ChartPanel(chart,true);
        CategoryAxis dateaxis=plot.getDomainAxis();
        //水平底部标题
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));
        //垂直标题
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));
        //获取柱状
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        //设置标题字体
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
    }
    public ChartPanel getChartPanel(){
        return frame1;

    }
}

