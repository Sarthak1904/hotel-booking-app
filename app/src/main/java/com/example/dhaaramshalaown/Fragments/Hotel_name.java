package com.example.dhaaramshalaown.Fragments;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.VideoView;

import com.example.dhaaramshalaown.R;
import com.google.android.material.textfield.TextInputLayout;


public class Hotel_name extends Fragment {

    TextInputLayout txtInput;
    EditText edtInput;

    public Hotel_name() {
        // Required empty public constructor
    }

    VideoView videoView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_hotel_name, container, false);
        videoView = view.findViewById(R.id.videoView);


        txtInput = view.findViewById(R.id.txtInput);
        edtInput = view.findViewById(R.id.edtInput);


        String Link = "android.resource://" + getActivity().getPackageName() + "/" + R.raw.video;
        Uri uri = Uri.parse(Link);
        videoView.setVideoURI(uri);


        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);

            }
        });


        return view;
    }
}