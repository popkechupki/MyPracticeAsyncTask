package com.example.mypracticeasynctask;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

class ProgressAsyncTask extends AsyncTask<Void, Integer, String> {

    private TextView textView;
    private ProgressBar progressBar;

    public ProgressAsyncTask(ProgressBar progressBar, TextView textView, TextView countText) {
        this.progressBar = progressBar;
        this.textView = textView;
        textView.setText("Status: running");
        int count = Integer.parseInt(TextUtils.split(countText.getText().toString(), ": ")[1]) + 1;
        countText.setText("実行回数: " + count);
    }

    @Override
    protected String doInBackground(Void... voids) {
        for (int i = 0; i <= 25; i++) {
            try {
                publishProgress(i*4);
                Thread.sleep(1000);

                if (isCancelled()) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "finished.";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        progressBar.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        textView.setText("Status: " + s);
    }
}
