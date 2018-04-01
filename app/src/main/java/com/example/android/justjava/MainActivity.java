package com.example.android.justjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    CheckBox whrippedBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        whrippedBox = (CheckBox) findViewById(R.id.whrippedBox);

    }
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        boolean whrippedCream = whrippedBox.isChecked();

        int price = calculatePrice(quantity);
        display(quantity);
        displayPrice(price);

        displayMessage("Price :" +price,"\nQuntity: "+quantity
        );

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }


    /**
     * Calculates the price of the order based on the current quantity.
     *
     * @return the price
     */
    private int calculatePrice(int quantity) {
        int price = quantity * 5;
        return price;
    }

    public void increament(View view) {

        quantity = quantity + 1;
        display(quantity);
    }

    public void decreament(View view) {

        quantity = quantity - 1;
        display(quantity);
    }


    public String displayMessage(String message,String quantity){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message+quantity);
        return message;
    }
}
