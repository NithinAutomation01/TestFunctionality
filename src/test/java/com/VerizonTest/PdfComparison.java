package com.VerizonTest;
import static com.pdfunit.AbstractTest.PATH;

import org.junit.Test;

import com.pdfunit.AssertThat;
import com.pdfunit.filter.page.AnyPage;
import com.pdfunit.filter.page.PagesToUse;
import com.pdfunit.filter.region.PageRegion;
public class PdfComparison {
	
	static String purchase_receipt_BIU ="C:\\Users\\user\\Desktop\\Bau\\3_Device upgrade single_Receipt (1).pdf";
	static String purchase_receipt_NSA = "C:\\Users\\user\\Desktop\\Generated\\purchaseReceipt_PDF.pdf";

	@Test// 			This testcase exibits that the total number of page of the file obtained 
	public void hasThreePage_false() throws Exception {
		AssertThat.document(purchase_receipt_BIU)
		.hasNumberOfPages(1)
		;
		}
	
	@Test
	public void hasThreePage_True() throws Exception {
		 AssertThat.document(purchase_receipt_BIU)
		.hasNumberOfPages(3)
		;
		}
	@Test
	public void fontType() throws Exception {
	String filename = PATH + "verizon/purchaseReceipt_PDF.pdf";
	AssertThat.document(filename)
	.hasFont().withNameContaining("Helvetica")
	;
	}
	@Test
	public void FontType_False() throws Exception {
	String filename = PATH + "verizon/purchaseReceipt_PDF.pdf";
	AssertThat.document(filename)
	.hasFont().withNameContaining("Times Roman")
	;
	}
	
	
	@Test
	public void NSA_datavalidation_NSA() throws Exception {
		purchase_receipt_NSA = "C:\\Users\\user\\Desktop\\Generated\\purchaseReceipt_PDF.pdf";
			String expectedTexts="Verizon retail location,Receipt of transaction,Verizon specialist";
    String[] expectedText = expectedTexts.split(",");
   int length= expectedText.length;
   
   for(int z=0;z<length;z++){
	   String temp = expectedText[z];
    AssertThat.document(purchase_receipt_NSA)
     .restrictedTo(PagesToUse.getPage(3))
    /*.restrictedTo(AnyPage.getPreparedInstance())*/
      .hasText()
      .containing(temp);
    		temp ="";
       }
 }

	  
	@Test
	public void schema_validation() throws Exception {
		purchase_receipt_BIU = PATH + "verizon/purchaseReceipt_PDF.pdf";
    String expectedText = "Receipt of transaction";
  
    AssertThat.document(purchase_receipt_BIU)
     /* .restrictedTo(PagesToUse.getPage(3))*/
    .restrictedTo(AnyPage.getPreparedInstance())
      .hasText()
      .containing(expectedText);
}

	@Test
	public void sameTextComparion_thenSuccess() {
		purchase_receipt_BIU = PATH + "verizon/purchaseReceipt_PDF.pdf";
	    String imageFile = "C:\\Users\\user\\workspace\\Test\\src\\test\\java\\com\\VerizonTest\\verizon.PNG";
	    int leftX  =   0;//0(0-10)
	    int upperY =   0;//5
	    int width  = 50;// 55
	    int height =  20;//65 
	    PageRegion pageRegion = new PageRegion(leftX, upperY, width, height);

	    AssertThat.document(purchase_receipt_BIU)
	              .and(purchase_receipt_NSA)
	              .restrictedTo(PagesToUse.getPage(1))
	              .restrictedTo(pageRegion)
	              .haveSameText();
	             
	        }
	
	@Test
	public void ImageComparison_With_BIU_File() throws Exception {
	  String filename = purchase_receipt_BIU;

	    String imageFile = "C:/Users/user/workspace/Test/src/test/resources/pdf-in-tests/images_Extraction/purchaseReceipt_PDF_resource_2.png";
	 
	    AssertThat.document(filename)
	      .restrictedTo(PagesToUse.getPage(1))
	      .hasImage()
	      .matching(imageFile);
	

	}
	@Test
	public void ImageComparison_With_NIS_File() throws Exception {
	  String filename = purchase_receipt_BIU;

	    String imageFile = "C:/Users/user/workspace/Test/src/test/resources/pdf-in-tests/images_Extraction/purchaseReceipt_PDF_resource_2.png";
	 
	    AssertThat.document(filename)
	      .restrictedTo(PagesToUse.getPage(1))
	      .hasImage()
	      .matching(imageFile);
	

	}
	
	@Test
	public void ImageComparison_WrongImageFile() throws Exception {
	  String filename = purchase_receipt_BIU;

	    String imageFile = "C:/Users/user/workspace/Test/src/test/resources/pdf-in-tests/images/CEO-signature.png";
	 
	    AssertThat.document(filename)
	      .restrictedTo(PagesToUse.getPage(1))
	      .hasImage()
	      .matching(imageFile);
	

	}
	}

