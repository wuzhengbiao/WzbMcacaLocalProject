package CollectionOfFunctionalMethods.ReportDataStatistics;
import CollectionOfFunctionalMethods.DatabaseRelatedMethods.DataBase;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ColumnChartStatistics {
    ChartPanel frame1;
    public  ColumnChartStatistics(String title,String X,String Y){
        CategoryDataset dataset=getDataSet();
        JFreeChart chart = ChartFactory.createBarChart3D(
                // 图表标题
                title,
                // 目录轴的显示标签
                X,
                // 数值轴的显示标签
                Y,
                // 数据集
                dataset,
                // 图表方向：水平、垂直
                PlotOrientation.VERTICAL,
                // 是否显示图例(对于简单的柱状图必须是false)
                true,
                // 是否生成工具
                false,
                // 是否生成URL链接
                false
        );
        //获取图表区域对象
        CategoryPlot plot=chart.getCategoryPlot();

        //水平底部列表
        CategoryAxis domainAxis=plot.getDomainAxis();
        //水平底部标题
        domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));
        //垂直标题
        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));
        //获取柱状
        ValueAxis rangeAxis=plot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        //设置标题字体
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题
        //这里也可以用chartFrame,可以直接生成一个独立的Frame
       // BarRenderer barrenderer = (BarRenderer) plot.getRenderer();
      //  barrenderer.setDrawBarOutline(false);

       // barrenderer.setItemLabelAnchorOffset(11D);
       // barrenderer.setBaseItemLabelsVisible(true);
     //   barrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        //GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F,Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
      //  barrenderer.setSeriesPaint(0, gradientpaint);
    }
    public static CategoryDataset getDataSet() {
        DataBase data=new DataBase();
        List<String> ListNum = new ArrayList();
        List<String> ListTime = new ArrayList();
        try {
            ListNum=data.QueryDatabaseSql( "select NUMBEROFORDETRANSACTIONS from platform_exception_informatin_table WHERE PLATFORM_EXCEPTION_INFORMATIN like \"%订单%\" " );
            ListTime=data.QueryDatabaseSql( "select CREATEIME from platform_exception_informatin_table WHERE PLATFORM_EXCEPTION_INFORMATIN like \"%订单%\" " );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0;i<ListTime.size();i++ )
        {
            dataset.setValue(Integer.parseInt( ListNum.get( i ) ), "订单数量", ListTime.get(i).substring( 5,10 ));
        }
        return dataset;
    }
    public ChartPanel getChartPanel(){
        return frame1;
    }
}
