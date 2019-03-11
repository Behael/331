package com.example.applist;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.provider.ContactsContract.Contacts;  // importing contacts


public class ListViewActivity extends ListActivity {

    static final String[] CHOICE = new String[] {
            "Financial News", "Call Home", "Google Map Search", "Google Contact List", "Ideal Weight Calculator"
    };

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, CHOICE));

        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                callIntent(position);
            }
        });

    }


    public void callIntent(int position) {
        Intent intent = null;
        switch (position) {
            case 0: // open yahoo finance
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://ca.finance.yahoo.com"));
                startActivity(intent);
                break;
            case 1: // open dial with number
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(+1)2504603131"));
                startActivity(intent);
                break;
            case 2: // open google maps
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:50.123,7.1434?z=19"));
                startActivity(intent);
                break;
            case 3: // open contacts
                intent = new Intent(Intent.ACTION_VIEW, Contacts.CONTENT_URI);
                startActivity(intent);
                break;
            case 4: // open new activity
                intent = new Intent(this, selectSystemActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}