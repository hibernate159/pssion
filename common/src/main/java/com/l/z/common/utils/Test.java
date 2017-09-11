package com.l.z.common.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BarcodeQRCode;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.qrcode.EncodeHintType;
import com.itextpdf.text.pdf.qrcode.ErrorCorrectionLevel;

public class Test {

	public static void main(String[] args) {

		Document doc = new Document();
		OutputStream os = null;

		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		BarcodeQRCode qrCode = new BarcodeQRCode("12312312312312313", 200, 200, hints);

		try {
			os = new FileOutputStream(new File("D://a.pdf"));
			PdfWriter.getInstance(doc, os);
			doc.open();
			Image img = qrCode.getImage();
			img.setUseVariableBorders(false);
			img.setBorder(1);
			img.setAbsolutePosition(50, 600);
			img.scaleAbsolute(200, 200);
			
			doc.add(img);
		} catch (BadElementException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		} finally {
			if (doc != null) {
				doc.close();
			}
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}

	}
}
