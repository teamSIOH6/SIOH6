package com.team.sioh6;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAccountActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView profImg;
    private TextView userName, userPhone, userEmail, userAddress, userOccupation;
    private GoogleSignInAccount acct;
    private FloatingActionButton edit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_account);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        acct = GoogleSignIn.getLastSignedInAccount(this);

        profImg = findViewById(R.id.prof_img);
        userName = findViewById(R.id.user_name);
        userPhone = findViewById(R.id.user_phone);
        userEmail = findViewById(R.id.user_email);
        userAddress = findViewById(R.id.user_address);
        userOccupation = findViewById(R.id.user_occupation);
        edit = findViewById(R.id.edit);

        Picasso.with(this).load(acct.getPhotoUrl()).placeholder(this.getResources()
                .getDrawable(R.drawable.user_profile)).into(profImg);
        userName.setText(acct.getDisplayName());
        userEmail.setText(acct.getEmail());

        edit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.edit:
                Intent intent = new Intent(UserAccountActivity.this,EditUserProfile.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
