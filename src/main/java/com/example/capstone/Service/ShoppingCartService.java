package com.example.capstone.Service;

import com.example.capstone.Model.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class ShoppingCartService {
    ArrayList<Product> cartItems = new ArrayList<Product>();

    public ArrayList  ShoppingCart() {
        return cartItems;
    }


    public ArrayList<Product> getCartItems() {
        return cartItems;
    }

    public void addProductToCart(Product product) {
        cartItems.add(product);
    }

    public void clearCart() {
        cartItems.clear();
}

}
