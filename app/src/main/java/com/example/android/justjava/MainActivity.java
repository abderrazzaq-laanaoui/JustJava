package com.example.android.justjava;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.text.NumberFormat;
/**

 This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 0;
    int price = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     This method is called when the order button is clicked.
     */
    @SuppressLint("SetTextI18n")
    public void submitOrder(View view) {
        TextView orderMessage = (TextView) findViewById(R.id.order_message);
        orderMessage.setText("Thank you! \n Your order of $"+price+" has been submitted");
        display(quantity = 0);
        displayPrice(price = quantity * 5);
    }
    public void addOne(View view){
        if(quantity == 0 ){
            TextView orderMessage = (TextView) findViewById(R.id.order_message);
            orderMessage.setText("");
        }
        if(quantity<999)
            display(++quantity);
        displayPrice(price = quantity * 5);
    }

    public void supOne(View view){
        if(quantity == 0 ){
            TextView orderMessage = (TextView) findViewById(R.id.order_message);
            orderMessage.setText("");
        }
        if(quantity>0)
                display(--quantity);
        displayPrice(price = quantity * 5);
    }
    /**

     This method displays the given quantity value on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    @SuppressLint("SetTextI18n")
    private void displayPrice(int number) {
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText("Total: "+ NumberFormat.getCurrencyInstance().format(number));
    }
}