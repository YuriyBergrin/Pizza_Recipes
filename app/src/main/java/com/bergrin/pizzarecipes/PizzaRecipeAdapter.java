package com.bergrin.pizzarecipes;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PizzaRecipeAdapter extends RecyclerView.Adapter<PizzaRecipeAdapter.PizzaRecipeAdapterHolder> {
    ArrayList<PizzaRecipeItem> pizzaRecipeItems;
    Context context;

    public PizzaRecipeAdapter(ArrayList<PizzaRecipeItem> pizzaRecipeItems, Context context) {
        this.pizzaRecipeItems = pizzaRecipeItems;
        this.context = context;
    }

    @NonNull
    @Override
    public PizzaRecipeAdapter.PizzaRecipeAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza_recipe_item, parent, false);
        PizzaRecipeAdapterHolder pizzaRecipeAdapterHolder = new PizzaRecipeAdapterHolder(view);
        return pizzaRecipeAdapterHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaRecipeAdapterHolder holder, int position) {
        PizzaRecipeItem pizzaRecipeItem = pizzaRecipeItems.get(position);
        holder.pizzaImageView.setImageResource(pizzaRecipeItem.getImageResource());
        holder.titleTextView.setText(pizzaRecipeItem.getTitle());
        holder.descriptionTextView.setText(pizzaRecipeItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return pizzaRecipeItems.size();
    }


    class PizzaRecipeAdapterHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView pizzaImageView;
        public TextView titleTextView;
        public TextView descriptionTextView;

        public PizzaRecipeAdapterHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            pizzaImageView = itemView.findViewById(R.id.pizzaImageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descriptionTextView = itemView.findViewById(R.id.descriptionTextView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            PizzaRecipeItem pizzaRecipeItem = pizzaRecipeItems.get(position);
            Intent intent = new Intent(context, RecipeActivity.class);
            intent.putExtra("imageRosource", pizzaRecipeItem.getImageResource());
            intent.putExtra("title", pizzaRecipeItem.getTitle());
            intent.putExtra("description", pizzaRecipeItem.getDescription());
            intent.putExtra("recipe", pizzaRecipeItem.getRecipe());
            context.startActivity(intent);
        }
    }

}
