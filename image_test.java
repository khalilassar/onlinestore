package soeq.app.soeq;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;

import butterknife.BindView;
import butterknife.ButterKnife;
import soeq.app.soeq.Others.RealPathUtil;

public class image_test extends AppCompatActivity {

    @BindView(R.id.img_test)
    ImageView imageView;

    @BindView(R.id.buttton)
    Button bt;

    public Uri currImageURI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_test);

        ButterKnife.bind(this);

        bt.setOnClickListener(e -> {

            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(Intent.createChooser(intent, "Select Picture"),1);


        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {

            if (requestCode == 1) {

                System.out.println(data.getData());
                currImageURI = data.getData();
          //      imageView.setImageBitmap(currImageURI);
            }
        }
    }


    private void setTextViews(int sdk, String uriPath, String realPath) {

        Uri uriFromPath = Uri.fromFile(new File(realPath));
        System.out.println(realPath);
        imageView.setImageURI(uriFromPath);


    }


}
