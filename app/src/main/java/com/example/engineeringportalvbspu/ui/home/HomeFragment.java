package com.example.engineeringportalvbspu.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.engineeringportalvbspu.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

private ImageSlider imageSlider;
private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/engineering-portal-vbspu.appspot.com/o/slider_Image%2Fslider1.png?alt=media&token=ef7694b1-9e13-4f2e-bccb-849e150f0072", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/engineering-portal-vbspu.appspot.com/o/slider_Image%2Fslider2.png?alt=media&token=e43c1eaf-c046-4519-892a-7429a347b9f6", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/engineering-portal-vbspu.appspot.com/o/slider_Image%2Fslider3.png?alt=media&token=9c1c6807-fa33-4ee0-8f56-b219c57ffbe1", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/engineering-portal-vbspu.appspot.com/o/slider_Image%2Fslider4.jpeg?alt=media&token=ab39d6ec-a3db-4835-af1b-da1cd1724eb7", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://firebasestorage.googleapis.com/v0/b/engineering-portal-vbspu.appspot.com/o/slider_Image%2Fslider5.jpeg?alt=media&token=43883e1d-cef9-43c6-923a-ad13ca838812", ScaleTypes.FIT));


     imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });


        return view;
    }
    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=UNS Institute Of Engineering & Technology, Harlalka Road, Deokali, Uttar Pradesh");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

}