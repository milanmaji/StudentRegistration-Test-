package com.sitapuramargram.studentregistration.activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.sitapuramargram.studentregistration.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalInformationActivity extends AppCompatActivity {

    private FloatingActionButton fabCamera;
    private CircleImageView profilePic;
    private TextInputEditText name, permanentAddress, currentAddress, personalPhone, guardianPhone, bloodGroup;
    private Button btNext;
    private ActivityResultLauncher<Intent> resultLauncher;
    private Boolean isImageSet = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_information);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }


        fabCamera = findViewById(R.id.fab_camera);
        profilePic = findViewById(R.id.profile_pic);
        name = findViewById(R.id.act_name);
        permanentAddress = findViewById(R.id.act_permanent_address);
        currentAddress = findViewById(R.id.act_current_address);
        personalPhone = findViewById(R.id.act_personal_phone);
        guardianPhone = findViewById(R.id.act_guardian_phone);
        bloodGroup = findViewById(R.id.act_blood_group);
        btNext = findViewById(R.id.bt_next);

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInput();
            }
        });

        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pickImageFromGallery();
            }
        });

        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            Intent data = result.getData();
                            Uri uri = data.getData();
                            Glide.with(PersonalInformationActivity.this)
                                    .load(uri)
                                    .fitCenter()
                                    .into(profilePic);

                            isImageSet = true;
                        }
                    }
                }
        );


    }

    private void pickImageFromGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        resultLauncher.launch(Intent.createChooser(intent, "Select Image"));
    }

    private void checkInput() {

        String mName = name.getText().toString();
        String mPAddress = permanentAddress.getText().toString();
        String mCAddress = currentAddress.getText().toString();
        String mPPhone = personalPhone.getText().toString();
        String mGPhone = guardianPhone.getText().toString();
        String mBloodGroup = bloodGroup.getText().toString();

        if (TextUtils.isEmpty(mName)) {
            Toast.makeText(PersonalInformationActivity.this, "Please enter name", Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(mPAddress)) {

            Toast.makeText(PersonalInformationActivity.this, "Please enter permanent address", Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(mCAddress)) {

            Toast.makeText(PersonalInformationActivity.this, "Please enter current address", Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(mPPhone) || mPPhone.length() != 10) {

            Toast.makeText(PersonalInformationActivity.this, "Enter valid phone number", Toast.LENGTH_LONG).show();

        } else if (TextUtils.isEmpty(mGPhone) || mGPhone.length() != 10) {

            Toast.makeText(PersonalInformationActivity.this, "Enter valid phone number", Toast.LENGTH_LONG).show();


        } else if (TextUtils.isEmpty(mBloodGroup)) {
            Toast.makeText(PersonalInformationActivity.this, "Enter blood group", Toast.LENGTH_LONG).show();

        } else {
            saveData(mName, mPAddress, mCAddress, mPPhone, mGPhone, mBloodGroup);
        }
    }

    private void saveData(String mName, String mPAddress, String mCAddress, String mPPhone, String mGPhone, String mBloodGroup) {

        //make api call
        if (isImageSet)
            Toast.makeText(PersonalInformationActivity.this, "Do image and data upload", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(PersonalInformationActivity.this, "Data Saved successfull", Toast.LENGTH_LONG).show();

        startActivity(new Intent(PersonalInformationActivity.this,MainActivity.class));
    }
}