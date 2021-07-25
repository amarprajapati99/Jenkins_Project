package com.bridgelabz.selenium.jenkins.utility;


import com.bridgelabz.selenium.jenkins.base.PDFReaderBaseClass;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
public class PDFReader extends PDFReaderBaseClass{

    public void pdfRead() throws IOException {
        String currentURL = driver.getCurrentUrl();
        Log.info (currentURL);
        Log.info("Getting Current URL");
        URL url = new URL(currentURL);

        InputStream is = url.openStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(is);
        PDDocument document = null ;

        document = PDDocument.load(bufferedInputStream);
        String pdfContent = new PDFTextStripper().getText(document);
        Log.info (pdfContent);
    }
}

