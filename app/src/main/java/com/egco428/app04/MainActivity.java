package com.egco428.app04;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String[] CLUBS = {"BTS","GOT7","BigBang","WINNER","2PM"};
    String msgSelected;
    ArrayList<Integer> msgMultiSelected;

    Button buttonSimple;
    Button buttonList;
    Button buttonSingle;
    Button buttonMulti;
    Button buttonCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSimple = (Button)findViewById(R.id.btnSimple);
        buttonList   = (Button)findViewById(R.id.btnList);
        buttonSingle = (Button)findViewById(R.id.btnSingle);
        buttonMulti  = (Button)findViewById(R.id.btnMulti);
        buttonCustom = (Button)findViewById(R.id.btnCustom);

        buttonSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // where dialog appear
                builder.setMessage("Do you want to have pizza?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    // when ans = yes do this
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"Yes",Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("No",null);
                builder.create();
                builder.show();
            }
        });

        buttonList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // where dialog appear
                builder.setTitle("Select your favourite?");
                builder.setItems(CLUBS, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selected = CLUBS[i];
                        Toast.makeText(getApplicationContext(),"you likes "+selected,Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("Don't like any group",null);
                builder.create();
                builder.show();
            }
        });

        buttonSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // where dialog appear
                builder.setTitle("Select your favourite?");
                builder.setSingleChoiceItems(CLUBS, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selected = CLUBS[i];
                        Toast.makeText(getApplicationContext(),"you likes " + selected,Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });

                builder.setNegativeButton("Don't like any group",null);
                builder.create();
                builder.show();
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                msgMultiSelected = new ArrayList<Integer>();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // where dialog appear
                builder.setTitle("Select your favourite?");
                builder.setMultiChoiceItems(CLUBS, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean isChecked) {
                        if(isChecked){
                            msgMultiSelected.add(i);
                        }
                        else if(msgMultiSelected.contains(i)){
                            msgMultiSelected.remove(Integer.valueOf(i)); // in case uncheck
                        }
                    }
                });

                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringBuffer buffer = new StringBuffer();
                        for(Integer team:msgMultiSelected){
                            buffer.append(" ");
                            buffer.append(CLUBS[team]);
                        }
                        Toast.makeText(getApplicationContext(),"you likes " + buffer.toString(),Toast.LENGTH_LONG).show();
                        dialogInterface.dismiss();
                    }
                });

                builder.setNegativeButton("Don't like any group",null);
                builder.create();
                builder.show();
            }
        });

        buttonCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setTitle("Login Dialog");
                dialog.setContentView(R.layout.dialog_custom);

                final EditText username = (EditText)findViewById(R.id.username);
                final EditText password = (EditText)findViewById(R.id.password);
                final Button buttonLogin = (Button)findViewById(R.id.login);
                final Button buttonCancel = (Button)findViewById(R.id.cancel);
                
            }
        });
    }

}
