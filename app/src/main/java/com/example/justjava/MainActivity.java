package com.example.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    double priceMultiplier = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view)
    {
        double price = priceMultiplier*quantity;
        TextView priceView = findViewById(R.id.price_view);

        priceView.setText("$" + String.format("%.2f", price));
    }

    public void alterQuantity(View view)
    {
        if(view.getId() == R.id.increment_view)
            increment();
        else if(view.getId() == R.id.decrement_view)
            decrement();
    }

    public void decrement ()
    {
        if(quantity <= 1)
        {
            Toast toast = Toast.makeText(this, "Must not descend 1", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        quantity--;

        TextView quantityView = findViewById(R.id.quantity_view);
        quantityView.setText("" + quantity);
    }

    public void increment ()
    {
        if(quantity >= 10)
        {
            Toast toast = Toast.makeText(this, "Must not ascend 10", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }

        quantity++;

        TextView quantityView = findViewById(R.id.quantity_view);
        quantityView.setText("" + quantity);
    }
}
