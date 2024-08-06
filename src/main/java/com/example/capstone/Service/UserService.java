package com.example.capstone.Service;

import com.example.capstone.Model.Merchant;
import com.example.capstone.Model.Product;
import com.example.capstone.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<Product> products = new ArrayList<>();
    private final MerchantService merchantService;
    private final ProductService productService;
    private final MerchantStockService merchantStockService;
    private  final  ShoppingCartService shoppingCartService;





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

    public void addProductToCart(int userId, int productId) {
        User user = null;
        for (User u : users) {
            if (u.getId() == userId) {
                user = u;
                break;
            }
        }

        Product product = null;
        for (Product p : products) {
            if (p.getId() == productId) {
                product = p;
                break;
            }
        }

        if (user != null && product != null) {
            shoppingCartService.addProductToCart(product);
        }
    }


    public List<Product> viewCart(int userId) {
        User user = null;
        for (User u : users) {
            if (u.getId() == userId) {
                user = u;
                break;
            }
        }

        if (user != null) {
            return shoppingCartService.getCartItems();
        }

        return products;
    }

    public void checkout(int userId) {
        User user = null;
        for (User u : users) {
            if (u.getId() == userId) {
                user = u;
                break;
            }
        }

        List<Product> cartItems = shoppingCartService.getCartItems();
        double totalAmount = 0.0;

        for (Product product : cartItems) {
            totalAmount += product.getPrice();
        }

        if (user != null && user.getBalance() >= totalAmount) {
            user.setBalance(user.getBalance() - totalAmount);
            shoppingCartService.clearCart();

        }


    }}


