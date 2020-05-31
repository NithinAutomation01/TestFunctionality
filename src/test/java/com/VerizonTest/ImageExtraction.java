package com.VerizonTest;

import java.io.IOException;

import com.testautomationguru.utility.PDFUtil;



public class ImageExtraction {
	static int pageCount ;
	public static void main(String args[]) throws Exception{
		String Purchase_Receipt_BAU =Constants.purchase_receipt_BAU;
		String Purchase_Receipt_NSA =Constants.purchase_receipt_NSA;

PDFUtil pdfUtil = new PDFUtil();
try {
 pageCount = pdfUtil.getPageCount(Purchase_Receipt_BAU);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(pageCount);


String text = pdfUtil.getText(Purchase_Receipt_BAU);
System.out.println(text);
pdfUtil.setImageDestinationPath(Constants.extracted_Image);
pdfUtil.extractImages(Purchase_Receipt_BAU);
System.out.println("Images have been extracted");
	}

}
