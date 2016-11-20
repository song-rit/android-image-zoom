package app.awitcha.pinchtozoomimage;


import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    private ImageView mImage;
    private Matrix mMatrix = new Matrix();
    private Float mScale = 1f;
    private ScaleGestureDetector mScaleGestureDetector;

    private String mImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        infixView();

        if (getIntent() != null) {
            mImageUrl = getIntent().getExtras().getString("image");
        }

        Glide.with(this)
                .load(mImageUrl)
                .into(mImage);

        mScaleGestureDetector = new ScaleGestureDetector(this, getScaleGestureListener());

    }

    private void infixView() {
        mImage = (ImageView) findViewById(R.id.image);
    }

    ScaleGestureDetector.SimpleOnScaleGestureListener getScaleGestureListener() {
        return new ScaleGestureDetector.SimpleOnScaleGestureListener() {
            @Override
            public boolean onScale(ScaleGestureDetector detector) {

                mScale = mScale * detector.getScaleFactor();
                mScale = Math.max(0.1f, Math.min(mScale, 5f));
                mMatrix.setScale(mScale, mScale);
                mImage.setImageMatrix(mMatrix);

//                return super.onScale(detector);
                return true;
            }
        };
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        mScaleGestureDetector.onTouchEvent(event);
//        return super.onTouchEvent(event);
        return true;
    }
}
