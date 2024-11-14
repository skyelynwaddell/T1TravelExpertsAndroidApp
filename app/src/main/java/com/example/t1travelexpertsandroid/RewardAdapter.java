package com.example.t1travelexpertsandroid;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.ViewHolder> {
    private final List<Reward> items;
    private final OnItemClickListener listener;

    public RewardAdapter(List<Reward> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_reward, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;

        ViewHolder(View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.rewardName);

            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(items.get(position));
                }
            });
        }

        void bind(Reward item) {
            itemName.setText(item.getName());
        }
    }

    // Define a custom interface that passes a Reward item
    public interface OnItemClickListener {
        void onItemClick(Reward item);
    }
}