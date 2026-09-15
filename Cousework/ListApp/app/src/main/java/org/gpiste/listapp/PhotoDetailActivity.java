package org.gpiste.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class PhotoDetailActivity extends AppCompatActivity {

    ImageView photoImageView;
    TextView itemNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);

        //Find images by ID
        photoImageView = findViewById(R.id.photoImageView);
        itemNameTextView = findViewById(R.id.itemNameTextView);

        //Receive message from mainactivity
        //Set images to imageview
        Intent intent = getIntent();
        int i =  intent.getIntExtra("org.gpiste.listapp", -1);
        if(i > -1){
            int photo =getImage(i);
            scalePhoto(photo, photoImageView);
            itemNameTextView.setText("*** "+ MainActivity.products[i] + " ***");
        }
    }

    //Return Image from resources based on index
    public int getImage(int i){
        if(i == 0){
            return R.drawable.blender;
        }else if(i == 1){
            return R.drawable.iphone;
        }else if(i == 2){
            return R.drawable.xbox;
        }else{
            return -1;
        }
    }
     public void scalePhoto(int photo, ImageView photoImageView) {
         Display originalScreen = getWindowManager().getDefaultDisplay(); //Loads phones screen info
         BitmapFactory.Options options = new BitmapFactory.Options(); //Create object for resizing picture

         //Check and reads image sizes
         options.inJustDecodeBounds = true;
         BitmapFactory.decodeResource(getResources(), photo, options);

         int screenWidth = originalScreen.getWidth();//width of screen
         int originalPicWidth = options.outWidth;//width of photo

         //Ratio used to change photo size
         int resizeRatio = Math.round((float)originalPicWidth/screenWidth);

         if(resizeRatio > 1){
             options.inSampleSize = resizeRatio; //Load smaller photo based on ratio
         }

         //This step scales down the photo based on ratio and saves it to ImageView
         options.inJustDecodeBounds = false;
         Bitmap scaledPhoto = BitmapFactory.decodeResource(getResources(), photo, options);
         photoImageView.setImageBitmap(scaledPhoto);


     }
}