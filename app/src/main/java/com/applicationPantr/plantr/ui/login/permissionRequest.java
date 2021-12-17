package com.applicationPantr.plantr.ui.login;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import com.applicationPantr.plantr.R;
import com.applicationPantr.plantr.ui.home.HomeActivity;
import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
public class permissionRequest extends AppCompatActivity {

    ImageView button;
    public static final int RequestPermissionCode = 7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_request);
        button = (ImageView) findViewById(R.id.ivPermission);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(CheckingPermissionIsEnabledOrNot())
                {
                    Toast.makeText(permissionRequest.this, "All Permissions Granted Successfully", Toast.LENGTH_LONG).show();
                }
                else {
                    RequestMultiplePermission();

                }
            }
        });
    }
    private void RequestMultiplePermission() {
        ActivityCompat.requestPermissions(permissionRequest.this, new String[]
                {
                        CAMERA,
                        ACCESS_COARSE_LOCATION,
                        READ_EXTERNAL_STORAGE
                }, RequestPermissionCode);

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean CameraPermission = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean RecordAudioPermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean SendSMSPermission = grantResults[2] == PackageManager.PERMISSION_GRANTED;

                    if (CameraPermission && RecordAudioPermission && SendSMSPermission) {

                        Toast.makeText(permissionRequest.this, "Permission Granted", Toast.LENGTH_LONG).show();
                        Intent i=new Intent(permissionRequest.this, HomeActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(permissionRequest.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }

                break;
        }
    }
    public boolean CheckingPermissionIsEnabledOrNot() {
        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int SecondPermissionResult= ContextCompat.checkSelfPermission(getApplicationContext(), ACCESS_COARSE_LOCATION);
        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                SecondPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ThirdPermissionResult == PackageManager.PERMISSION_GRANTED ;
    }

}