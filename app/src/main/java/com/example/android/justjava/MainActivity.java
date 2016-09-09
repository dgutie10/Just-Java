package com.example.android.justjava;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;


import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    int pricePerCup = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
//        String priceMessage = "Total: $"+calculatePrice(quantity, 10)+" \nThank you!";
//        displayMessage(priceMessage);
//        displayPrice(quantity*5);

        displayMessage(createOrderSummary(calculatePrice(quantity,pricePerCup)));
    }

    public String createOrderSummary (int totalPrice){
        String name = "Kaptain Kunal";
        String summary = "Name: "+ name;
        summary += "\nQuantity: "+ quantity;
        summary += "\nTotal: $"+totalPrice;
        summary += "\nThank you!";
        return summary;
    }


    private int calculatePrice(int quantity, int pricePerCup) {
        int price = quantity * pricePerCup;
        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    public void increment (View view){
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view){
        if (quantity > 0){ this.quantity -- ;}
        displayQuantity(this.quantity);
    }

    private void displayMessage (String message){
        TextView orderSumaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSumaryTextView.setText(message);

    }
}
