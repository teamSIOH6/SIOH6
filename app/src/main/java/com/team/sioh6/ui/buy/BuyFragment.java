package com.team.sioh6.ui.buy;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.team.sioh6.BasicFunctionHandler;
import com.team.sioh6.R;

import java.util.ArrayList;
import java.util.List;

public class BuyFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private List<BuyModel> buyModelList;
    private BuyAdapter adapter;

    private BasicFunctionHandler handler;
    private ProgressDialog dialog;
    private FloatingActionButton nearbySellers;
    public static double myLat, myLong;

    private final int RESOLVABLE_REQUEST_CODE=1;
    int MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION = 2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_buy, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);
        nearbySellers = root.findViewById(R.id.gps);
        buyModelList = new ArrayList<>();
        handler = new BasicFunctionHandler(getContext());
        dialog = new ProgressDialog(getContext());
        adapter = new BuyAdapter(getActivity(),buyModelList,getChildFragmentManager());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        createLocationRequest();

        nearbySellers.setOnClickListener(this);
        return root;
    }

    private void getNearBySellers(double myLat, double myLong) {
        buyModelList.clear();
        for (int i = 1 ; i<= 4 ; i++){
            BuyModel buyModel = new BuyModel();
            buyModel.setId(i);
            buyModel.setUserName("User Name " + i);
            buyModelList.add(buyModel);
        }
        adapter.notifyDataSetChanged();
        dialog.dismiss();
    }

    private void createLocationRequest(){
        dialog.setMessage("Fetching Near by Sellers");
        dialog.setCancelable(false);
        dialog.show();
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setInterval(1000);
        locationRequest.setFastestInterval(3000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder().addLocationRequest(locationRequest);
        SettingsClient client = LocationServices.getSettingsClient(getContext());
        Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());
        task.addOnSuccessListener(new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                requestCurrentLocationOfUser();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof ResolvableApiException){
                    try{
                        ResolvableApiException resolvable=(ResolvableApiException)e;
                        startIntentSenderForResult(resolvable.getResolution().getIntentSender(),
                                RESOLVABLE_REQUEST_CODE,null,0,0,0,null);
                        //resolvable.startResolutionForResult(getActivity(),RESOLVABLE_REQUEST_CODE);
                    }catch (IntentSender.SendIntentException sendEx){
                        Log.e("IntentSender Exception",sendEx.getMessage()+"");
                    }
                }
            }
        });

    }

    void requestCurrentLocationOfUser(){
        if (isPermissionGranted()){
            FusedLocationProviderClient fusedLocationClient= LocationServices.getFusedLocationProviderClient(getActivity());
            fusedLocationClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    if (location!=null){
                        //requestLocationUpdates();
                        //requestLocationUpdates();
                        myLat = location.getLatitude();
                        myLong = location.getLongitude();
                        getNearBySellers(myLat,myLong);
                        Log.e("User Location","Latitude : "+location.getLatitude()+" Longitude : "+location.getLongitude());
                    }
                }
            });
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gps:
                createLocationRequest();
                break;
        }
    }

    private boolean isPermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                        MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION);
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_COARSE_LOCATION);
                shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION);
                return false;
            } else {
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (requestCode==RESOLVABLE_REQUEST_CODE){
            createLocationRequest();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_READ_FINE_LOCATION) {
            requestCurrentLocationOfUser();
            return;
        }
    }
}