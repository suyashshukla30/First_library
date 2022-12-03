package com.suyashshukla.webpdflibrary;

import android.content.Context;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintJob;
import android.print.PrintManager;
import android.webkit.WebView;
import android.widget.Toast;

public class Force {
    public static void Convert(Context context, WebView wv){
        boolean printBtnPressed = true;
        PrintJob printJob;
        // Creating PrintManager instance
        PrintManager printManager = (PrintManager) context
                .getSystemService(Context.PRINT_SERVICE);

        String jobName = context.getPackageName() + " webpage" + wv.getUrl();
        PrintDocumentAdapter printAdapter = wv.createPrintDocumentAdapter(jobName);

        // Create a print job with name and adapter instance
        assert printManager != null;
        printJob = printManager.print(jobName, printAdapter,
                new PrintAttributes.Builder().build());

    }
    public static void result(Context context, PrintJob printJob, boolean printBtnPressed){
        if (printJob != null && printBtnPressed) {
            if (printJob.isCompleted()) {
                Toast.makeText(context, "Completed", Toast.LENGTH_SHORT).show();
            } else if (printJob.isStarted()) {
                // Showing Toast Message
                Toast.makeText(context, "isStarted", Toast.LENGTH_SHORT).show();

            } else if (printJob.isBlocked()) {
                Toast.makeText(context, "isBlocked", Toast.LENGTH_SHORT).show();
            } else if (printJob.isCancelled()) {
                // Showing Toast Message
                Toast.makeText(context, "isCancelled", Toast.LENGTH_SHORT).show();

            } else if (printJob.isFailed()) {
                // Showing Toast Message
                Toast.makeText(context, "isFailed", Toast.LENGTH_SHORT).show();

            } else if (printJob.isQueued()) {
                // Showing Toast Message
                Toast.makeText(context, "isQueued", Toast.LENGTH_SHORT).show();

            }
            printBtnPressed = false;
        }
    }
}
