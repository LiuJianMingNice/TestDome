package com.example.jianshuprojection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.zjy.pdfview.PdfView;

public class MainActivity extends AppCompatActivity {

    private PdfView mPdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPdfView = findViewById(R.id.pdf_view);
        mPdfView.loadPdf("https://info.smartcamview.com/mobile/help/UserManual.pdf");
    }
}
