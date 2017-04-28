package com.example.akshay.quickdeal.Activities;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.app.DownloadManager.Query;
import android.app.DownloadManager.Request;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.akshay.quickdeal.R;

public class details extends AppCompatActivity {
    private long enqueue;
    private DownloadManager dm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Button message;
        TextView textView = (TextView) findViewById(R.id.deatilTitle);
       TextView textView1 = (TextView) findViewById(R.id.previous_desc);
        String title = getIntent().getExtras().getString("title");
        String desc= getIntent().getExtras().getString("desc");
        textView1.setText(desc);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (DownloadManager.ACTION_DOWNLOAD_COMPLETE.equals(action)) {
                    long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, 0);
                    DownloadManager.Query query = new DownloadManager.Query();
                    query.setFilterById(enqueue);
                    Cursor c = dm.query(query);
                    if (c.moveToFirst()) {
                        int columnIndex = c
                                .getColumnIndex(DownloadManager.COLUMN_STATUS);
                        if (DownloadManager.STATUS_SUCCESSFUL == c
                                .getInt(columnIndex)) {

//
                        }
                    }
                }
            }
        };
        registerReceiver(receiver, new IntentFilter(
                DownloadManager.ACTION_DOWNLOAD_COMPLETE));

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(title);
        actionBar.setElevation(0);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        message = (Button) findViewById(R.id.button2);
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    public void onClick(View view) {
        dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
        Request request = new Request(
                Uri.parse("http://cdn2.knowyourmobile.com/sites/knowyourmobilecom/files/styles/gallery_wide/public/2017/03/screen_shot_2017-03-29_at_17.35.22.png"));
        enqueue = dm.enqueue(request);
        request.setDestinationInExternalFilesDir(details.this, Environment.DIRECTORY_DOWNLOADS,"QuickDeal.jpeg");

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
