package fr.amineaitm.blutoothapp;


import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ENABLE_BT = 1;
    private static final int REQUEST_PERMISSION_LOCATION = 2;

    private BluetoothAdapter bluetoothAdapter;

    private Button enableButton;
    private Button disableButton;
    private Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enableButton = findViewById(R.id.enableButton);
        disableButton = findViewById(R.id.disableButton);
        searchButton = findViewById(R.id.searchButton);

        // Vérifie si le Bluetooth est pris en charge sur l'appareil
        BluetoothManager bluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        if (bluetoothManager == null) {
            // Le Bluetooth n'est pas pris en charge
            Toast.makeText(this, "Le Bluetooth n'est pas pris en charge sur cet appareil.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Obtient l'adaptateur Bluetooth
        bluetoothAdapter = bluetoothManager.getAdapter();

        // Vérifie si le Bluetooth est activé
        if (bluetoothAdapter == null || !bluetoothAdapter.isEnabled()) {
            // Le Bluetooth n'est pas activé, demande de l'activer
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }

        // Gestionnaire de clic du bouton Activer
        enableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableBluetooth();
            }
        });

        // Gestionnaire de clic du bouton Désactiver
        disableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                disableBluetooth();
            }
        });

        // Gestionnaire de clic du bouton Rechercher
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchBluetoothDevices();
            }
        });
    }

    // Activer le Bluetooth
    private void enableBluetooth() {
        if (bluetoothAdapter != null && !bluetoothAdapter.isEnabled()) {
            // Vérifie la permission ACCESS_FINE_LOCATION avant d'activer le Bluetooth
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_PERMISSION_LOCATION);
            } else {
                bluetoothAdapter.enable();
                Toast.makeText(this, "Le Bluetooth est activé.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Désactiver le Bluetooth
    private void disableBluetooth() {
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            // Vérifie la permission ACCESS_FINE_LOCATION avant de désactiver le Bluetooth
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_PERMISSION_LOCATION);
            } else {
                bluetoothAdapter.disable();
                Toast.makeText(this, "Le Bluetooth est désactivé.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Rechercher les appareils Bluetooth
    private void searchBluetoothDevices() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // La permission de localisation n'est pas accordée, demande la permission
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    REQUEST_PERMISSION_LOCATION);
        } else {
            // La permission de localisation est déjà accordée, démarrer la recherche des appareils
            startDeviceDiscovery();
        }
    }

    // Gérer la réponse de demande de permission
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // La permission de localisation est accordée, démarrer la recherche des appareils
                startDeviceDiscovery();
            } else {
                Toast.makeText(this, "La permission de localisation est requise pour rechercher des appareils Bluetooth.",
                        Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Démarrer la recherche des appareils
    private void startDeviceDiscovery() {
        if (bluetoothAdapter == null) {
            return;
        }

        if (!bluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "Le Bluetooth n'est pas activé.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Set<BluetoothDevice> pairedDevices = bluetoothAdapter.getBondedDevices();
        List<String> deviceNames = new ArrayList<>();
        if (pairedDevices.size() > 0) {
            for (BluetoothDevice device : pairedDevices) {
                deviceNames.add(device.getName());
            }
        } else {
            Toast.makeText(this, "Aucun appareil Bluetooth apparié trouvé.", Toast.LENGTH_SHORT).show();
        }

        // Afficher la liste des appareils appariés ou effectuer toute autre action
        // avec les appareils Bluetooth trouvés
        // Exemple :
        // showDeviceList(deviceNames);
    }
}


