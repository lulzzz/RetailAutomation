package com.retail.pageObjects;

//import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import com.framework.wrapper.WebOperations;

public class AccountDetailsPage extends WebOperations{

	//private static Logger log = Logger.getLogger(Account_LookUpPage.class);

	public static By 
	launchMobileBtn = By.xpath("//BUTTON[text()='Launch Mobile']"),
	launchMobileRtBtn = By.xpath("//BUTTON[text()='Launch Mobile']"),
	Address= By.xpath("//span[text()='Address']"),
	Telephone= By.xpath("//span[text()='Telephone #']"),
	Account= By.xpath("//span[text()='Account #']"),
	addressDetails = By.xpath("//span[@class='br ng-binding']"),
	phoneDetails = By.xpath("//div[@class='row clearfix'][2]//span[2]"),
	accountDetails = By.xpath("//div[@class='row clearfix'][3]//span[2]"),
   Email_Address= By.xpath("//span[text()='Email Address']"),
   Customer_for= By.xpath("//span[text()='Customer for']"),
   Appointments= By.xpath("//h4[text()='Appointments']"),
   noAppointment = By.xpath("//div[contains(text(),'No appointments scheduled')]"),
   NotesDetails= By.xpath("//li[@class='message ng-binding ng-scope'][1]"),
   Notes = By.xpath("//h4[contains(text(),'Notes')]"),
   
   noNotes = By.xpath("//span[contains(text(),'No notes')]"),
   serviceimages= By.xpath("//div[@class='fa-boxs flex']"),
   viewAll= By.xpath("//a[text()='View All']"),
    addNote= By.xpath("//a[text()='Add Note']"),
    addNewnote= By.xpath("//h2[text()='Add New Note']"),
    addNewNote_button = By.xpath("//button[contains(text(),'Add Note')]"),
    noteType = By.xpath("//h2[text()='Note type required']"),
    selectNotetype= By.xpath("//span[text()='Select note type']"),
    Subject= By.xpath("//label[text()='Subject (optional)']"),
    Message= By.xpath("//label[text()='Message']"),
    closeAddnote= By.xpath("//button[@ng-click='ctl.cancel()']//md-icon"),
    close_NotetypeRequired= By.xpath("//form[@ng-submit='ctl.showNoteTypeErr=false;']//button//md-icon[contains(text(),'clear')]"),
    cancelAddnote= By.xpath("//button[@ng-click='ctl.cancel()'][text()='Cancel']"),
    compareBills= By.xpath("//a[text()='Compare Bills']"),
    Ok_NotetypeRequired= By.xpath("//form[@ng-submit='ctl.showNoteTypeErr=false;']//button[contains(text(),'Ok')]"),
    Compare2= By.xpath("//h3[text()='Compare Bills']"),
    billTable = By.xpath("//tbody//td[2]"),
    noBill = By.xpath("//span[text()='Bill Comparison is unavailable for this user.']"),
   Source= By.xpath("//span[text()='Source ']"),
   close_message= By.xpath("//form[@ng-submit='ctl.showNoteMessageErr=false;']//button//md-icon[contains(text(),'clear')]"),
   ok_message= By.xpath("//form[@ng-submit='ctl.showNoteMessageErr=false;']//button[contains(text(),'Ok')]"),
   AccountStatus= By.xpath("//Span[text()='Account Status']"),
   CurrentAccountStatus = By.xpath("//span[@class='info-txt ng-binding']"),
   
   eligible_icon= By.xpath("//md-icon[contains(text(),' check_circle ')]"),
   eligibility_text= By.xpath("//div[text()='Eligible for XFINITY Mobile']"),
   manageDev= By.linkText("Manage Devices"),
   viewbill= By.xpath("//a[@class='blue-link'][contains(text(),'View Bill')]"),
   verify_bill= By.xpath("//embed[@id='plugin']"),
   mobileDetails= By.xpath("//div[contains(text(),'Mobile Details')]"),
   noBills = By.xpath("//p[text()='No recent bills are available for this account']"),
   message_required= By.xpath("//p[contains(text(),'Please add Message text before clicking Add Note')]"),
   note_required = By.xpath("//p[contains(text(),'Please select a note type')]"),
   manageMobileLink = By.xpath("//A[text()='Manage Mobile Devices']");
   
	
	
	 public static void selectNotetype(String notetype) 
		{
			By selectNotetype = By.xpath("//button[contains(text(),'"+notetype+"')]");
			clickElement(selectNotetype);
		}
}
