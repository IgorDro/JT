package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InfoBank extends Page {
//  @FindBy (xpath = "//input[@value = '02.09.2017']")
//  private WebElement receivingDocument;
//
//  @FindBy (xpath = "//input[@value = '03.09.2017']")
//  private WebElement executionDocument;
//
//  @FindBy (xpath = "//textarea")
//  private WebElement messageFromBank;
//
//  @FindBy (xpath = "//input[@value = 'Ф. ОПЕРУ БАНКА ВТБ (ПАО) В САНКТ-ПЕТЕРБУРГЕ']")
//  private  WebElement departmentReceivedDocument;

  public String getValueReceivingDocument(String receivingDocumentXpath) {
    WebElement receivingDocument = getDriver().findElement(By.xpath(receivingDocumentXpath));
    String receivingDocumentValue = receivingDocument.getAttribute("value");
    return receivingDocumentValue;
  }

  public String getValueExecutionDocument(String executionDocumentXpath) {
    WebElement executionDocument = getDriver().findElement(By.xpath(executionDocumentXpath));
    String executionDocumentValue = executionDocument.getAttribute("value");
    return executionDocumentValue;
  }

  public String getValueMessageFromBank(String messageFromBankXpath) {
    WebElement messageFromBank = getDriver().findElement(By.xpath(messageFromBankXpath));
    String messageFromBankValue = messageFromBank.getAttribute("value");
    return messageFromBankValue;
  }

  public String getValueDepartmentReceivedDocument(String departmentReceivedDocumentXpath) {
    WebElement departmentReceivedDocument = getDriver().findElement(By.xpath(departmentReceivedDocumentXpath));
    String departmentReceivedDocumentValue = departmentReceivedDocument.getAttribute("value");
    return departmentReceivedDocumentValue;
  }



}
