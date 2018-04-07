package com.example.olife.complainbox;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import at.markushi.ui.CircleButton;

public class Submission extends AppCompatActivity {

    private CircleButton problem_submission_camera;
    private ImageView problem_submission_image;
    private EditText problem_description;
    private Uri file;
    private static String capturedImagePath;
    private int GALLARY_REQUEST = 1, CAPTURE_REQUEST = 100;
    private String submittedProblemImagePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_submission);

        Bundle extras = getIntent().getExtras();
        this.setTitle(extras.getString("message_title"));

        LinearLayout submission = findViewById(R.id.submission);
        submission.setBackgroundResource(extras.getInt("background_image"));

        problem_submission_image = findViewById(R.id.problem_submission_image);
        problem_description = findViewById(R.id.problem_description);
        problem_submission_camera = findViewById(R.id.problem_submission_camera);


        // permission check
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            problem_submission_camera.setEnabled(false);
            ActivityCompat.requestPermissions(this, new String[] { Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE }, 0);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 0) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                problem_submission_camera.setEnabled(true);
            }
        }
    }


    public void captureProblemPhoto(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = Uri.fromFile(getOutputMediaFile());
        intent.putExtra(MediaStore.EXTRA_OUTPUT, file);

        startActivityForResult(intent, CAPTURE_REQUEST);
    }

    public void selectProblemPhotoFromGallery(View view){
        getGallary();
    }


    private static File getOutputMediaFile(){
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), "ComplainBoxPhoto");

        if (!mediaStorageDir.exists()){
            if (!mediaStorageDir.mkdirs()){
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        capturedImagePath = mediaStorageDir.getPath() + File.separator + "IMG_"+ timeStamp + ".jpg";
        return new File(capturedImagePath);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){

            if(requestCode == GALLARY_REQUEST){
                Uri selectUri = data.getData();
                problem_submission_image.setImageURI(selectUri);
                problem_submission_image.setScaleType(ImageView.ScaleType.FIT_CENTER);
                submittedProblemImagePath = getRealPathFromURI(selectUri);
            }

            if(requestCode == CAPTURE_REQUEST){
                submittedProblemImagePath = capturedImagePath;
                problem_submission_image.setImageURI(file);
                problem_submission_image.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            Toast.makeText(this,submittedProblemImagePath,Toast.LENGTH_SHORT).show();
        }
    }

    private String getRealPathFromURI(Uri contentURI) {
        String filePath;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            filePath = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            filePath = cursor.getString(idx);
            cursor.close();
        }
        return filePath;
    }


    private void getGallary(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent,"Select File"),GALLARY_REQUEST);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.overridePendingTransition(R.anim.slide_from_left,R.anim.slide_to_right);
    }
}
