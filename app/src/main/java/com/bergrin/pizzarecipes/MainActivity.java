package com.bergrin.pizzarecipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import static com.bergrin.pizzarecipes.Utils.*;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<PizzaRecipeItem> pizzaRecipeItems = new ArrayList<>();
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_1, PIZZA_1_TITLE, PIZZA_1_DESCRIPTION, PIZZA_1_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_2, PIZZA_2_TITLE, PIZZA_2_DESCRIPTION, PIZZA_2_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_3, PIZZA_3_TITLE, PIZZA_3_DESCRIPTION, PIZZA_3_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_4, PIZZA_4_TITLE, PIZZA_4_DESCRIPTION, PIZZA_4_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_5, PIZZA_5_TITLE, PIZZA_5_DESCRIPTION, PIZZA_5_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_6, PIZZA_6_TITLE, PIZZA_6_DESCRIPTION, PIZZA_6_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_7, PIZZA_7_TITLE, PIZZA_7_DESCRIPTION, PIZZA_7_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_8, PIZZA_8_TITLE, PIZZA_8_DESCRIPTION, PIZZA_8_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_9, PIZZA_9_TITLE, PIZZA_9_DESCRIPTION, PIZZA_9_RECIPE));
        pizzaRecipeItems.add(new PizzaRecipeItem(R.drawable.pizza_10, PIZZA_10_TITLE, PIZZA_10_DESCRIPTION, PIZZA_10_RECIPE));

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        adapter = new PizzaRecipeAdapter(pizzaRecipeItems, this);

        layoutManager = new LinearLayoutManager(this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
