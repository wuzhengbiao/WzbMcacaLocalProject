package CollectionOfFunctionalMethods.ReportDataStatistics;
import java.awt.Font;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import CollectionOfFunctionalMethods.DatabaseRelatedMethods.DataBase;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
public class PieChartStatistics {
    ChartPanel frame1;
    public PieChartStatistics(){
        DefaultPieDataset data = getDataSet();
        JFreeChart chart = ChartFactory.createPieChart3D("订单数量",data,true,false,false);
        //设置百分比
        PiePlot pieplot = (PiePlot) chart.getPlot();
        //获得一个DecimalFormat对象，主要是设置小数问题
        DecimalFormat df = new DecimalFormat("0.00%");
        //获得一个NumberFormat对象
        NumberFormat nf = NumberFormat.getNumberInstance();
        //获得StandardPieSectionLabelGenerator对象
        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);
        //设置饼图显示百分比
        pieplot.setLabelGenerator(sp1);
        //没有数据的时候显示的内容
        pieplot.setNoDataMessage("无数据显示");
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02D);
        //设置不显示空值
        pieplot.setIgnoreNullValues(true);
        //设置不显示负值
        pieplot.setIgnoreZeroValues(true);
        frame1=new ChartPanel (chart,true);
        //设置标题字体
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
        //获取图表区域对象
        PiePlot piePlot= (PiePlot) chart.getPlot();
        //解决乱码
        piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
    }
    private static DefaultPieDataset getDataSet() {
        DataBase data=new DataBase();
        List<String> ListNum = new ArrayList();
        List<String> ListAbnomol = new ArrayList();
        List<String> ListOthers = new ArrayList();
        try {
            ListNum=data.QueryDatabaseSql( "select count(*) from platform_exception_informatin_table WHERE PLATFORM_EXCEPTION_INFORMATIN like \"%订单%\" " );
            ListAbnomol=data.QueryDatabaseSql( "select count(*) from  platform_exception_informatin_table WHERE PLATFORM_EXCEPTION_INFORMATIN like \"%异常%\"" );
            ListOthers=data.QueryDatabaseSql("select count(*) from  platform_exception_informatin_table WHERE PLATFORM_EXCEPTION_INFORMATIN like \"%序号%\"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("异常数量",Integer.parseInt( ListAbnomol.get(0) ));
        dataset.setValue("其他数量",Integer.parseInt(ListOthers.get( 0 )));
        dataset.setValue("订单数量",Integer.parseInt(ListNum.get( 0 )));
        return dataset;
    }
    public ChartPanel getChartPanel(){
        return frame1;

    }
}

