package com.example.jasondollie.readingexcelfile;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void order(View v) throws IOException, BiffException {
    try {

        AssetManager am = getAssets();
        InputStream is =am.open("data.xls");
        Workbook wb = Workbook.getWorkbook(is);
        Sheet s = wb.getSheet(0);
        int row = s.getRows();
        int col = s.getColumns();
        String xx = "";
        for (int i = 0; i < row; i++)
        {
            for (int c = 0; c < col; c++)
            {
                Cell z = s.getCell(c, i);
                xx = xx + z.getContents();


            }
            xx=xx+"\n";
        }
    display(xx);
    }
    catch (Exception e)
    {

    }

    }
    private void display(String value)
    {
        TextView x=(TextView) findViewById(R.id.textView);
        x.setText(value);

    }
}
