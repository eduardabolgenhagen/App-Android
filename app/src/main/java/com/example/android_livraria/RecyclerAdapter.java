package com.example.android_livraria;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<MyViewHolder> {
    private ArrayList<Livro> listaLivros;
    private View view;
    private ImageView fechar;
    private Context context;
    private RecyclerViewInterface recyclerViewInterface;
    private Button adicionar;

    public RecyclerAdapter(ArrayList<Livro> listaLivros, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.listaLivros = listaLivros;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Integer foto = listaLivros.get(position).getFoto();
        Uri foto2 = listaLivros.get(position).getFoto2();
        String titulo = listaLivros.get(position).getTitulo();
        Livro livro = listaLivros.get(position);

        view = holder.getLivroView();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MainActivity02.class);

                Bundle bundle = new Bundle();


                if (livro.getFoto() != null) {
                    bundle.putInt("foto", livro.getFoto());
                }
                bundle.putParcelable("foto2", livro.getFoto2());
                bundle.putString("titulo", livro.getTitulo());
                bundle.putString("autor", livro.getAutor());
                bundle.putString("editora", livro.getEditora());
                bundle.putInt("ano", livro.getAno());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        if (foto == null) {
            foto = R.drawable.book_bookmark;
        }

        holder.getFoto().setImageResource(foto);
        holder.getFoto().setImageURI(foto2);

        holder.getTitulo().setText(titulo);

        fechar = holder.getFechar();
        fechar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (recyclerViewInterface != null) {
                            int position = holder.getAdapterPosition();

                            if (position != RecyclerView.NO_POSITION) {
                                recyclerViewInterface.onClickItem(position);
                            }
                        }
                    }
                }
        );
    }

    @Override
    public int getItemCount() {
        return listaLivros.size();
    }
}