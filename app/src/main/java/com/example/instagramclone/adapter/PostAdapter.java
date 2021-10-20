package com.example.instagramclone.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.instagramclone.databinding.RecyclerRowBinding;
import com.example.instagramclone.model.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostHolder> {


    ArrayList<Post> postArrayList;

    public PostAdapter(ArrayList<Post> postArrayList) {
        this.postArrayList = postArrayList;
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding = RecyclerRowBinding.
                inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new PostHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

        holder.rowBinding.recyclerViewEmailText.setText(postArrayList.get(position).email);
        holder.rowBinding.recyclerViewComment.setText(postArrayList.get(position).comment);
        Picasso.get().load(postArrayList.get(position).downloadUrl)
                .into(holder.rowBinding.recyclerViewImage);

    }

    @Override
    public int getItemCount() {
        return postArrayList.size();
    }

    class PostHolder extends RecyclerView.ViewHolder{


        RecyclerRowBinding rowBinding;


        public PostHolder(RecyclerRowBinding rowBinding) {
            super(rowBinding.getRoot());
            this.rowBinding = rowBinding;
        }
    }
}
