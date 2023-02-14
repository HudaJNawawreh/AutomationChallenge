/**
 * A class to contains all method might be needed for an order
 */
package selenium.buisnessFlows;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.JavascriptExecutor;
import selenium.testBase.TestBase;
import selenium.utils.SeleniumActions;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class OrderPageLogics extends SeleniumActions {

    public enum AirwayBillType
    {
        onePerPage,
        twoPerPage,
        fourPerPage,
        ThermalFormat
    }

    /**
     * a method to print the bill in one step
     * @param type
     */
    public void printAirwayBill(AirwayBillType type)
    {
        click(orderPg.printAirWayBillButton);
        switch (type)
        {
            case onePerPage:
            {
                click(orderPg.oneBillPerPage);
                break;
            }
            default:
        }
        waitForElementPresent(orderPg.printBillButton);
        click(orderPg.printBillButton);
        switchTab();
    }

    /**
     * This method will download the bill then read its content
     * @param url
     * @return
     * @throws IOException
     */
    public String getPdfContent(String url) throws IOException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("url = \""+url+"\";\n" +
                "\n" +
                "var a = document.createElement(\"a\");\n" +
                "document.body.appendChild(a);\n" +
                "a.style = \"display: none\";\n" +
                "a.href = url;\n" +
                "a.setAttribute(\"download\",\"bill\");\n" +
                "a.click();\n" +
                "window.URL.revokeObjectURL(url);");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        URL pdfURL=new URL("File:///"+TestBase.filePath.replaceAll("\\\\","/")+"/bill.pdf");
      InputStream is=pdfURL.openStream();
      BufferedInputStream bis=new BufferedInputStream(is);
      PDDocument doc=PDDocument.load(bis);
      int pages=doc.getNumberOfPages();
      System.out.println("The total number of pages "+pages);
      PDFTextStripper strip=new PDFTextStripper();
      strip.setStartPage(1);
      strip.setEndPage(2);
      String stripText=strip.getText(doc);
      System.out.println(stripText);
      doc.close();
      bis.close();
      is.close();

      return stripText;

    }
    
}
