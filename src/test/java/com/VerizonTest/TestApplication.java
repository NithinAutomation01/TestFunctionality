package com.VerizonTest;

import java.io.IOException;

import org.testng.annotations.Test;

import com.pdfunit.AssertThat;

import de.redsix.pdfcompare.PdfComparator;

public class TestApplication {
	
	static String purchase_receipt_BAU =Constants.purchase_receipt_BAU;
	static String purchase_receipt_NSA = "C:\\Users\\user\\Desktop\\Generated\\purchaseReceipt_PDF.pdf";
	@Test
	public void hasThreePage_false() throws Exception {
		AssertThat.document(purchase_receipt_BAU)
		.hasNumberOfPages(3)
		;
		}
	@Test
	public void VisualImageComparison(){
		String file1 = purchase_receipt_BAU;
		String file2 = purchase_receipt_NSA;
		String resultFile =Constants.resultFile;

		
try {
	new PdfComparator(file1,file2).compare().writeTo(resultFile);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

System.out.println("Image comparison completed and written to the filepath");


	}

}
