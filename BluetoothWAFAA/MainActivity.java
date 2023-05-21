package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.core.app.ActivityCompat;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private BluetoothAdapter bAdapter;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAdapter = BluetoothAdapter.getDefaultAdapter();
        button = findViewById(R.id.Button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bAdapter == null) {
                    Log.e(TAG, "Le périphérique ne prend pas en charge le Bluetooth");
                    return;
                }

                if (!bAdapter.isEnabled()) {
                    Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                    if (ActivityCompat.checkSelfPermission(MainActivity.this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Gérer la demande de permission
                        return;
                    }
                    startActivityForResult(enableBtIntent, 1);
                } else {
                    // Le Bluetooth est déjà activé
                    Log.d(TAG, "Bluetooth est déjà activé");


                    perme();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // L'utilisateur a activé le Bluetooth
                Log.d(TAG, "Bluetooth a été activé par l'utilisateur");

                // Démarrer une recherche de périphériques Bluetooth à proximité
                perme();
            } else {
                // L'utilisateur n'a pas activé le Bluetooth
                Log.e(TAG, "L'utilisateur n'a pas activé le Bluetooth");
            }
        }
    }

    private void perme() {
        // Démarrer la recherche de périphériques Bluetooth à proximité
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        boolean discoveryStarted = bAdapter.startDiscovery();

        if (discoveryStarted) {
            Log.d(TAG, "Recherche de périphériques Bluetooth a commencé");

            Set<BluetoothDevice> pairedDevices = bAdapter.getBondedDevices();
            if (pairedDevices.size() > 0) {
                Log.d(TAG, "Liste des périphériques Bluetooth appairés :");

                for (BluetoothDevice device : pairedDevices) {
                    Log.d(TAG, device.getName() + " - " + device.getAddress());
                }
            } else {
                Log.d(TAG, "Aucun périphérique Bluetooth appairé trouvé");
            }
        } else {
            Log.e(TAG, "La recherche de périphériques Bluetooth n'a pas pu être lancée");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_SCAN) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        bAdapter.cancelDiscovery();
    }
}
