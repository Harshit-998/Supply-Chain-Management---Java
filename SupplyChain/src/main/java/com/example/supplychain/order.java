package com.example.supplychain;
import java.sql.ResultSet;

public class order {
    public static boolean orderProduct(int productId, String customerEmail){
        String query = String.format("INSERT INTO  supply_chain.order (quantity, customer_id, product_id) VALUES(1,(SELECT cid FROM customer WHERE email='%s'),%s)",customerEmail,productId);
        DatabaseConnection dbCon = new DatabaseConnection();
        System.out.println(dbCon.executeQuery(query));
        return true;

    }

    public static void main(String[] args) {
        order.orderProduct(1,"harshit@gmail.com");
    }
}
