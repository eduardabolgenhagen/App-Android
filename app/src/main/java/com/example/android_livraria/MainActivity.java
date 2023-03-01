package com.example.android_livraria;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface {
    private RecyclerView recyclerView;
    public static ArrayList<Livro> listaLivros = new ArrayList<>();
    Button button;

    static {
        listaLivros.add(new Livro(R.drawable.broqueis, "Bróqueis", "João da Cruz e Sousa", "L&PM", 1893));
        listaLivros.add(new Livro(R.drawable.ultimos_sonetos, "Últimos Sonetos", "João da Cruz e Sousa", "L&PM", 1861));
        listaLivros.add(new Livro(R.drawable.evocacoes, "Evocações", "João da Cruz e Sousa", "Serra Azul", 1898));
        listaLivros.add(new Livro(R.drawable.tropos_fantasias, "Tropos e fantasias", "João da Cruz e Sousa", "Fundação Catarinense de Cultura", 1861));
        listaLivros.add(new Livro(R.drawable.livro_derradeiro, "O livro derradeiro", "João da Cruz e Sousa", "Fundação Catarinense de Cultura", 1861));
        listaLivros.add(new Livro(R.drawable.farois, "Farois", "João da Cruz e Sousar", "Serra Azul", 1900));
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        button = findViewById(R.id.adicionarLivro);
        setAdapter();

        button.setOnClickListener(v -> irParaCadastrar());
    }

    private void irParaCadastrar() {
        Intent intent = new Intent(this, MainActivity03.class);
        startActivityForResult(intent, 1);
    }

    private void setAdapter() {
        RecyclerAdapter adapter = new RecyclerAdapter(listaLivros, this, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClickItem(int position) {
        listaLivros.remove(position);
        recyclerView.getAdapter().notifyItemRemoved(position);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        recyclerView.getAdapter().notifyDataSetChanged();
    }
}