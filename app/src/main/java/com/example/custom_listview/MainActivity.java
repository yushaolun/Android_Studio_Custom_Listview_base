package com.example.custom_listview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {



    TextView t1;
    TextView t2;
    ImageView im;
    ListView listview;
    public int img[] = {R.drawable.facebook,R.drawable.instagram, R.drawable.twitter, R.drawable.whatsapp,R.drawable.youtube};
    public String[] title = {"FB","whatsapp","Twiter","IG","youtube"};
    String mDescription[] = {"Facebook Description", "Whatsapp Description", "Twitter Description", "Instagram Description", "Youtube Description"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1=findViewById(R.id.textView);
        t2=findViewById(R.id.textView2);
        im=findViewById(R.id.imageView);
        listview = findViewById(R.id.listview);
        MyAdapter adapter=new MyAdapter(this,title,img,mDescription);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    Toast.makeText(getApplicationContext(), "Facebook Description", Toast.LENGTH_SHORT).show();
                }

                if (i == 1) {
                    Toast.makeText(MainActivity.this, "Whatsapp Description", Toast.LENGTH_SHORT).show();
                }
                if (i == 2) {
                    Toast.makeText(MainActivity.this, "Twitter Description", Toast.LENGTH_SHORT).show();
                }
                if (i == 3) {
                    Toast.makeText(MainActivity.this, "Instagram Description", Toast.LENGTH_SHORT).show();
                }
                if (i == 4) {
                    Toast.makeText(MainActivity.this, "Youtube Description", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    class MyAdapter extends ArrayAdapter<String>{

        Context context;
        String title[];
        String[] mDescription;
        int[] img;

         MyAdapter(Context c, String[] title, int[] img, String[] mDescription) {
            super(c,R.layout.item,title);
             this.context = c;
             this.title = title;
             this.img = img;
             this.mDescription=mDescription;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.item, parent, false);  //找xml檔Layout
            ImageView images = row.findViewById(R.id.imageView);
            TextView myTitle = row.findViewById(R.id.textView);
            TextView comment=row.findViewById(R.id.textView2);



            // now set our resources on views
            images.setImageResource(img[position]);
            myTitle.setText(title[position]);
            comment.setText(mDescription[position]);



            return row;
        }
    }


}
