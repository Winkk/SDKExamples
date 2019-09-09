package com.winkk.sdk.demo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.winkk.sdk.Winkk;
import com.winkk.sdk.WinkkAuthorizationCallback;
import com.winkk.sdk.WinkkAuthorizationFailure;
import com.winkk.sdk.WinkkProfile;
import com.winkk.sdk.demo.databinding.ActivityMainBinding;

/**
 * Main screen to show how to perform authorization through Winkk SDK.
 * It implements Winkk authorization callbacks to fetch authorization results into.
 * */
public class MainActivity extends AppCompatActivity implements WinkkAuthorizationCallback {

    /** References to views. */
    private ActivityMainBinding mBinding;

    /**
     * Initializations and configurations for views.
     * */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Loading layout.
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Setting toolbar.
        setSupportActionBar(mBinding.toolbar);

        // Binding authorization start action to this button.
        mBinding.btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initiates Winkk-based authorization.
                Winkk.SDK.start(
                        MainActivity.this,  // context
                        MainActivity.this); // callbacks to fetch authorization results
            }
        });
    }

    /**
     * When Winkk-based authorization has been successfully completed.
     *
     * @param profile Obtained profile data.
     * */
    @Override
    public void onWinkkAuthorizationSucceeded(@NonNull WinkkProfile profile) {
        // Setting avatar if it is present in profile.
        final int size = mBinding.ivAvatar.getWidth();
        final Bitmap avatar = profile.getAvatar(size, size);
        mBinding.ivAvatar.setImageBitmap(avatar);

        // Preparing profile fields data to render.
        final StringBuilder sb = new StringBuilder();

        // Name.
        sb.append(profile.getName());

        // Auth type.
        sb.append(System.lineSeparator());
        sb.append(String.format(
                getString(R.string.has_strong_auth),
                String.valueOf(profile.hasStrongAuthorization())));

        // Email.
        final String email = profile.getEmail();
        if (email != null) {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    getString(R.string.email),
                    email));
        }

        // First name.
        final String firstName = profile.getFirstName();
        if (firstName != null) {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    getString(R.string.first_name),
                    firstName));
        }

        // Last name.
        final String lastName = profile.getLastName();
        if (lastName != null) {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    getString(R.string.last_name),
                    lastName));
        }

        // Nickname.
        final String nickname = profile.getNickname();
        if (nickname != null) {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    getString(R.string.nickname),
                    nickname));
        }

        // Country.
        final String country = profile.getCountry();
        if (country != null) {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    getString(R.string.country),
                    country));
        }

        // Address.
        final String address = profile.getAddress();
        if (address != null) {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    getString(R.string.address),
                    address));
        }

        // Phone.
        final String phone = profile.getPhone();
        if (phone != null) {
            sb.append(System.lineSeparator());
            sb.append(String.format(
                    getString(R.string.phone),
                    phone));
        }

        // Rendering prepared text.
        mBinding.tvData.setText(sb.toString());
    }

    /**
     * When Winkk-based authorization has failed for some reason.
     *
     * @param reason Failure reason.
     * */
    @Override
    public void onWinkkAuthorizationFailed(@NonNull WinkkAuthorizationFailure reason) {
        Toast.makeText(this, reason.toString(), Toast.LENGTH_SHORT).show();
    }

}
