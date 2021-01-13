package com.asiapay.apppay.deeplinkingsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv=findViewById(R.id.tv);

        handleIntent(getIntent());
    }

    private void handleIntent(Intent intent){

        String appLinkAction=intent.getAction();
        Uri appLinkData=intent.getData();
        showDeepLinkOffer(appLinkAction, appLinkData);
    }

    private void showDeepLinkOffer(String appLinkAction,Uri appLinkData) {
        // 1
        if (Intent.ACTION_VIEW == appLinkAction && appLinkData != null) {
            // 2
            String orderID = appLinkData.getQueryParameter("order");
            if (orderID.isEmpty()) {

                tv.setText("Empty Data");

            } else {
                tv.setText("Order id -: "+orderID);

            }
        }
    }
}