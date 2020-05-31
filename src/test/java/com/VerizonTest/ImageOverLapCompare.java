package com.VerizonTest;

import static com.pdfunit.AbstractTest.PATH;
import java.io.IOException;

import de.redsix.pdfcompare.PdfComparator;

public class ImageOverLapCompare {
	
	static String purchase_receipt_BAU =Constants.purchase_receipt_BAU;
	static String purchase_receipt_NSA = Constants.purchase_receipt_NSA;

			
			public static void main(String args[]) throws Exception{
			String file1 = purchase_receipt_BAU;
					String file2 = purchase_receipt_NSA;
					String resultFile ="C:\\Users\\user\\Desktop\\ResultFile\\imagecomparison.pdf";

					
			new PdfComparator(file1,file2).compare().writeTo(resultFile);
			new PdfComparator(file1,file2).compare().writeTo(Constants.Pdf_OverLap_Image);
		System.out.println("Image comparison completed and written to the filepath");

	
}
}