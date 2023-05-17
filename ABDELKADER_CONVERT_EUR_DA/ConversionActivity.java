package isi.conversion;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ConversionActivity extends Activity {
	/** Called when the activity is first created. */

	RadioButton dinarToEuro, euroToDinar;
	EditText entree;
	TextView sortie;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		entree = (EditText) findViewById(R.id.monnaie);
		sortie = (TextView) findViewById(R.id.resultat);

		euroToDinar = (RadioButton) findViewById(R.id.conv1);
		dinarToEuro = (RadioButton) findViewById(R.id.conv2);

		euroToDinar.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				v.showContextMenu();
				return false;
			}
		});

		dinarToEuro.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {
				v.showContextMenu();
				return false;
			}
		});

		euroToDinar.setOnCreateContextMenuListener(this);
		dinarToEuro.setOnCreateContextMenuListener(this);

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {

		super.onCreateContextMenu(menu, v, menuInfo);
		menu.add(0, 1, 0, "Conversion euro -> dinar");
		menu.add(0, 2, 0, "Conversion dinar -> euro");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Toast.makeText(this, "0.5020", 1000).show();
			break;
		case 2:
			Toast.makeText(this, "1.9919", 1000).show();
			break;
		}

		return super.onContextItemSelected(item);
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 1, 0, "Conversion C <-> F");
		menu.add(0, 2, 0, "Quitter");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case 1:
			Intent i = new Intent(ConversionActivity.this,ConversionTemperatureActivity.class);
			startActivity(i);
			break;
		case 2:
			this.finish();
			break;
		}

		return super.onOptionsItemSelected(item);
	}

	public void convertir(View v) {

		if (entree.getText().toString().equals("")) {
			AlertDialog alertDialog;
			alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Champs Manquant");
			alertDialog
					.setMessage("Vous devez ins�rer une valeur � convertir !!!");
			alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					dialog.dismiss();
					
				}
			});  
			alertDialog.show();
			

		} else {
			float valeurInitiale = Float.valueOf(entree.getText().toString());

			float resultat;
			if (euroToDinar.isChecked()) {
				resultat = euroToDinar(valeurInitiale);
			} else {
				resultat = dinarsToEuro(valeurInitiale);
			}

			sortie.setText(String.valueOf(resultat));
		}
	}

	private float euroToDinar(float valeurEuro) {
		return (float) (valeurEuro * 1.9919);
	}

	private float dinarsToEuro(float valeurDinar) {
		return (float) (valeurDinar * 0.5020);
	}
}