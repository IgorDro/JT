package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoBank extends Page {
  @FindBy (xpath = "//input[@value = '02.09.2017']")
  private WebElement receivingDocument;

  @FindBy (xpath = "//input[@value = '03.09.2017']")
  private WebElement executionDocument;

  @FindBy (xpath = "//textarea")
  private WebElement messageFromBank;

  @FindBy (xpath = "//input[@value = 'Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ']")
  private  WebElement departmentReceivedDocument;

  public String getValueReceivingDocument() {
    String receivingDocumentValue = receivingDocument.getAttribute("value");
    return receivingDocumentValue;
  }

  public String getValueExecutionDocument() {
    String executionDocumentValue = executionDocument.getAttribute("value");
    return executionDocumentValue;
  }

  public String getValueMessageFromBank() {
    String messageFromBankValue = messageFromBank.getAttribute("value");
    return messageFromBankValue;
  }

  public String getValueDepartmentReceivedDocument() {
    String departmentReceivedDocumentValue = departmentReceivedDocument.getAttribute("value");
    return departmentReceivedDocumentValue;
  }



}
