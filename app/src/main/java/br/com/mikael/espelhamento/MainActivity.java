package br.com.mikael.espelhamento;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private TextView status;
    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);
        status = findViewById(R.id.status);
        findViewById(R.id.start).setOnClickListener(v -> abrirEspelhamento());
    }
    private void abrirEspelhamento() {
        try {
            startActivity(new Intent(Settings.ACTION_CAST_SETTINGS));
            status.setText("Selecione a TV SEMP Roku e aceite a conexão na TV.");
        } catch (Exception e) {
            try { startActivity(new Intent(Settings.ACTION_WIRELESS_DISPLAY_SETTINGS)); }
            catch (Exception ignored) { Toast.makeText(this, "Abra o painel rápido e toque em Smart View/Transmitir.", Toast.LENGTH_LONG).show(); }
        }
    }
}
