package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;
import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<User> users = new ArrayList<User>();
    private final ArrayList<Product>cartItems= new ArrayList<>();
    ArrayList<Product> products = new ArrayList<>();
    private final MerchantService merchantService;
    private final ProductService productService;
    private final MerchantStockService merchantStockService;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public boolean updateUser(int id, User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.set(i, user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                users.remove(i);
                return true;
            }
        }
        return false;
    }



    public int buyProduct(int userId, int productId, int merchantId) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() != userId) {
                return 1;
            }

        }
        for (int j = 0; j < merchantService.getMerchants().size(); j++) {
            if (merchantService.getMerchants().get(j).getId() == merchantId) {
                return 2;
            }

        }
        for (int j = 0; j < productService.getProducts().size(); j++) {
            if (productService.getProducts().get(j).getId() == productId) {
                return 3;
            }
        }
        return 0;
    }



    public void addCartItem(Product product  ) {
        cartItems.add(product);

    }
    public ArrayList<Product> getCartItems() {
        return cartItems;
    }
    public boolean discountProducts(double discountPercentage) {
        boolean discounted = false;
        for (Product product : products) {
            double discountedPrice = product.getPrice() * (1 - discountPercentage / 100);
            if (discountedPrice < product.getPrice()) {
                product.setPrice(discountedPrice);
                discounted = true;
            }
        }
        return discounted;
    }}

