package com.example.pdfhelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//import com.zjy.pdfview.PdfView;

import com.example.pdfhelper.pdfview.PdfView;
import com.example.pdfhelper.rspdfview.RSPdfView;

public class MainActivity extends AppCompatActivity {

    private RSPdfView mPdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPdfView = findViewById(R.id.pdf_view);
        mPdfView.loadPdf("https://info.smartcamview.com/mobile/help/UserManual.pdf");
        mPdfView.setPreviousText("Previous");
        mPdfView.setNextText("Next");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPdfView.release();
    }
}