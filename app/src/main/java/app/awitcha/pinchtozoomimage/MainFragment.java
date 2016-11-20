package app.awitcha.pinchtozoomimage;


import android.content.Intent;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.Touch;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private ImageView mImage;
    private Matrix mMatrix = new Matrix();
    private Float mScale = 1f;
    private ScaleGestureDetector mScaleGestureDetector;
    private ScaleGestureDetector.OnScaleGestureListener mOnScaleGestureListener;

    public MainFragment() {
        // Required empty public constructor
    }

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        infixView(rootView);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final String image = "https://docs.google.com/uc?authuser=0&id=0B_IchW5V8GCWdDREZGd2cjNmTU0&export=download";

        Glide.with(getActivity())
                .load(image)
                .into(mImage);

        mImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ImageActivity.class);
                intent.putExtra("image", image);
                startActivity(intent);
            }
        });
    }

    private void infixView(View rootView) {
        mImage = (ImageView) rootView.findViewById(R.id.image);
    }

}
