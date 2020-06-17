package CollectionOfFunctionalMethods.BasicMethods;

import macaca.client.MacacaClient;

public class AbnormalScreenshot {
    public static final String AbnormalXpath = "//*[@id=\"detail__\"]";//找到异常
    public static final String AbnormalXpathDetail="//*[@ng-click=\"msg.showMeItem=!msg.showMeItem\"]";//查找异常细表
    public static final String AbnormalXpathDetailGetText="//*[@class=\"message-content ng-binding ng-scope\"]";//查找异常细表
    //"//*[@class=\"message-content ng-binding ng-scope\"]/text()"
    public static final int T=1;
    public int WhetherCatchAbnormal(MacacaClient Driver,String img) throws Exception {
        if (Driver.waitForElementByXPath(AbnormalXpath)==null)
        {
            System.out.println("找了四遍没有找到，开始等待！\n");
            for (int i=1; i <= T; i++)//可以自定义等待区间时长
            {
                Driver.sleep(1000);
                if(Driver.waitForElementByXPath(AbnormalXpath)!=null)//隔一秒查找元素
                {
                    System.out.println("等待了："+i+"秒,找到元素了");
                    MailDelivery.TCTestCaseMailSending(0);
                    break;
                }
                if (i == T) {
                    return 0;//没找到
                }
            }
        }
            Driver.elementByXPath(AbnormalXpath).click();
            Driver.sleep(2000);
            Driver.elementByXPath(AbnormalXpathDetail).click();
            Driver.elementByXPath(AbnormalXpathDetailGetText).getText();
            Driver.saveScreenshot(img);
        return 1;
    }
}
