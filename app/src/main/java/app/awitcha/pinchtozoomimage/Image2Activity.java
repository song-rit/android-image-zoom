package app.awitcha.pinchtozoomimage;

import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import uk.co.senab.photoview.PhotoViewAttacher;

public class Image2Activity extends AppCompatActivity {

    private ImageView mImage;
    PhotoViewAttacher mAttacher;


    private String mImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image2);

        infixView();

        if (getIntent() != null) {
            mImageUrl = getIntent().getExtras().getString("image");
        }

        Glide.with(this)
                .load(mImageUrl)
                .into(mImage);

        mAttacher = new PhotoViewAttacher(mImage);
        mAttacher.update();

        mImage.performClick();

    }


    private void infixView() {
        mImage = (ImageView) findViewById(R.id.image);
    }




}
