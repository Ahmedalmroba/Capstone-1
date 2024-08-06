package com.example.capstone.Service;

import com.example.capstone.Model.MerchantStock;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MerchantStockService {
    ArrayList<MerchantStock> merchantStocks = new ArrayList<>();
    public ArrayList<MerchantStock> getMerchantStocks() {
        return merchantStocks;
    }
    public void addMerchantStock(MerchantStock merchantStock) {
        merchantStocks.add(merchantStock);

    }
    public boolean updateMerchantStock(int id,MerchantStock merchantStock) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.set(i, merchantStock);
                return true;
            }
        }
        return false;
    }
    public boolean deleteMerchantStock(int id) {
        for (int i = 0; i < merchantStocks.size(); i++) {
            if (merchantStocks.get(i).getId() == id) {
                merchantStocks.remove(i);
                return true;
            }
        }
        return false;
    }
    public boolean addStockToMerchant(int productid, int merchantid, int amount) {
        for (MerchantStock merchantStock : merchantStocks) {
            if (merchantStock.getProductid().equals(productid)&& merchantStock.getMerchantid().equals(merchantid)) {

                int currentStock = merchantStock.getStock();
                int newStock = currentStock + amount;
                merchantStock.setStock(newStock);
                return true;
            }
        }

        return false;

    }



            }





