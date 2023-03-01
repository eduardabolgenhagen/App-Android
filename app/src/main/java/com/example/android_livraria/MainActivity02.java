package com.example.android_livraria;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity02 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);

        Bundle bundle = getIntent().getExtras();

        Integer foto = bundle.getInt("foto");
        Uri foto2 = bundle.getParcelable("foto2");
        String titulo = bundle.getString("titulo");
        String autor = bundle.getString("autor");
        String editora = bundle.getString("editora");
        Integer ano = bundle.getInt("ano");

        ImageView fotoImage = findViewById(R.id.foto);

        if (foto2 != null) {
            fotoImage.setImageURI(foto2);
        } else {
            fotoImage.setImageResource(foto);
        }

        TextView tituloText = findViewById(R.id.titulo);
        tituloText.setText(titulo);

        TextView autorText = findViewById(R.id.autor);
        autorText.setText(autor);

        TextView editoraText = findViewById(R.id.editora);
        editoraText.setText(editora);

        TextView anoText = findViewById(R.id.ano);
        anoText.setText(ano + "");
    }
}