package com.example.android_livraria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity03 extends AppCompatActivity {
    ImageButton adicionarCapa;
    Button adicionar;
    EditText titulo, autor, editora, ano;
    Uri selectedImage;
    ImageView capaEscolhida;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);

        titulo = findViewById(R.id.editTextTextPersonName5);
        autor = findViewById(R.id.editTextTextPersonName6);
        editora = findViewById(R.id.editTextTextPersonName7);
        ano = findViewById(R.id.editTextTextPersonName8);
        adicionarCapa = findViewById(R.id.adicionarCapa);
        adicionar = findViewById(R.id.adicionarLivro);
        capaEscolhida = findViewById(R.id.capa);

        adicionarCapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);
            }
        });

        adicionar.setOnClickListener(view -> addItem());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            selectedImage = data.getData();
            capaEscolhida.setImageURI(selectedImage);
        }
    }

    private void addItem() {
        Livro livro = new Livro(selectedImage, titulo.getText().toString(), autor.getText().toString(), editora.getText().toString(), Integer.parseInt(ano.getText().toString()));
        MainActivity.listaLivros.add(livro);
        System.out.println("LIVRO AQUI Ó >>>>>>>>>>>>>>>>>>>> " +  MainActivity.listaLivros.toString());

        Intent intent = new Intent(this, MainActivity.class);
        startActivityForResult(intent, 2);
    }
}