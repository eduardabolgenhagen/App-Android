package com.example.android_livraria;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder{
    private ImageView foto;
    private TextView titulo;
    private View livroView;
    private ImageView fechar;
    private Button adicionar;

    public MyViewHolder(final View view){
        super(view);
        foto = view.findViewById(R.id.foto);
        titulo = view.findViewById(R.id.titulo);
        livroView = view.findViewById(R.id.view);
        fechar = view.findViewById(R.id.fechar);
        adicionar = view.findViewById(R.id.adicionarLivro);
    }

    public ImageView getFoto() {
        return foto;
    }

    public TextView getTitulo() {
        return titulo;
    }

    public View getLivroView() {
        return livroView;
    }

    public ImageView getFechar() {
        return fechar;
    }

    public Button getAdicionar() {
        return adicionar;
    }
}