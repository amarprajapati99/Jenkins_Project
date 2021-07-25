package com.bridgelabz.selenium.jenkins;

import com.bridgelabz.selenium.jenkins.base.PDFReaderBaseClass;
import com.bridgelabz.selenium.jenkins.utility.PDFReader;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import java.io.IOException;

public class PDFReaderTest extends PDFReaderBaseClass{

    @Description(" pdf reader")
    @Test
    public void pdf_test() throws IOException {
        PDFReader pdfReader = new PDFReader();
        pdfReader.pdfRead();
    }
}

