package com.example.dhaaramshalaown.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.dhaaramshalaown.R;

import com.example.dhaaramshalaown.R;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class Upload_image extends Fragment {
    ImageView image_COVER,image_HOTEL1,image_HOTEL2,image_ROOM1,image_ROOM2;
    Button CHOOSE1,CHOOSE2,CHOOSE3,CHOOSE4,CHOOSE5,UPLOAD1,UPLOAD2,UPLOAD3,UPLOAD4,UPLOAD5;
    private int CurrentProgress = 0;
    private ProgressBar progressBar ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_upload_image, container, false);
        image_COVER=view.findViewById(R.id.img_cover);
        image_HOTEL1=view.findViewById(R.id.img_hotel_1);
        image_HOTEL2=view.findViewById(R.id.img_hotel_2);
        image_ROOM1=view.findViewById(R.id.img_room_1);
        image_ROOM2=view.findViewById(R.id.img_room_2);


        /*progressBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CurrentProgress = CurrentProgress+10;
                progressBar.setProgress(CurrentProgress);
                progressBar.setMax(50);
            }
        });*/


        image_COVER.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Upload_image.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	 //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(1);
            }
        });
        image_HOTEL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Upload_image.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	 //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(2);
            }
        });
        image_HOTEL2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Upload_image.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	 //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(3);
            }
        });
        image_ROOM1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Upload_image.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	 //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(4);
            }
        });
        image_ROOM2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.with(Upload_image.this)
                        .crop()	    			//Crop image(Optional), Check Customization for more option
                        .compress(1024)			//Final image size will be less than 1 MB(Optional)
                        .maxResultSize(1080, 1080)	 //Final image resolution will be less than 1080 x 1080(Optional)
                        .start(5);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1)
        {
            Uri uri= data.getData();
            image_COVER.setImageURI(uri);

        }else if (requestCode==2) {

            Uri uri= data.getData();

            image_HOTEL1.setImageURI(uri);
        }
        else if (requestCode==3) {

            Uri uri= data.getData();

            image_HOTEL2.setImageURI(uri);
        }
        else if (requestCode==4) {

            Uri uri= data.getData();

            image_ROOM1.setImageURI(uri);
        }
        else  {

            Uri uri= data.getData();

            image_ROOM2.setImageURI(uri);
        }

    }
}