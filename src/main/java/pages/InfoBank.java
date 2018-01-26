package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InfoBank extends Page {

  //Прием документа к исполнению
  public static String getValueReceivingDocument(String receivingDocumentXpath) {
    WebElement receivingDocument = getDriver().findElement(By.xpath(receivingDocumentXpath));
    String receivingDocumentValue = receivingDocument.getAttribute("value");
    return receivingDocumentValue;
  }

  //Исполнение документа
  public static String getValueExecutionDocument(String executionDocumentXpath) {
    WebElement executionDocument = getDriver().findElement(By.xpath(executionDocumentXpath));
    String executionDocumentValue = executionDocument.getAttribute("value");
    return executionDocumentValue;
  }

  //Сообщение из банка
  public static String getValueMessageFromBank(String messageFromBankXpath) {
    WebElement messageFromBank = getDriver().findElement(By.xpath(messageFromBankXpath));
    String messageFromBankValue = messageFromBank.getAttribute("value");
    return messageFromBankValue;
  }

  //Подразделение, получившее документ
  public static String getValueDepartmentReceivedDocument(String departmentReceivedDocumentXpath) {
    WebElement departmentReceivedDocument = getDriver().findElement(By.xpath(departmentReceivedDocumentXpath));
    String departmentReceivedDocumentValue = departmentReceivedDocument.getAttribute("value");
    return departmentReceivedDocumentValue;
  }
}
