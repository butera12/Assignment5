package com.example.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

public class Search extends AppCompatActivity {
    DatabaseHelper mydb ;
    ListView list;
    SearchView editsearch;
    View TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        mydb = new  DatabaseHelper(this);
        list = (ListView) findViewById(R.id.ListView);

        Cursor cursor= mydb.getRegister();

        if (cursor.getCount()==0){
            //show message
            showmassege("error","nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()){
            buffer.append("id ;"+cursor.getString(0)+"\n");
            buffer.append("username ;"+cursor.getString(1)+"\n");
            buffer.append("password ;"+cursor.getString(2)+"\n\n");
        }
        //show all data
        showmassege ("register",buffer.toString());

    }

    public void showmassege(String title ,String massage){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(massage);
        builder.show();
    }
    }


