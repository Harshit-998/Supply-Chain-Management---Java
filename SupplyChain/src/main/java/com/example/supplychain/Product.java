package com.example.supplychain;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.util.PrimitiveIterator;

public class Product {
    public SimpleIntegerProperty id;
    public SimpleStringProperty name;
    public SimpleDoubleProperty price;

    public Product(int id, String name, double price){
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);

    }
    public int getId() { return id.get();}
    public String getName() { return name.get();}
    public double getPrice() { return price.get();}

    public static ObservableList<Product> getAllProducts(){
//        DatabaseConnection dbcon = new DatabaseConnection();
//        ObservableList<Product> data = FXCollections.observableArrayList();
        String selectProduct = "SELECT * FROM supply_chain.products;";
        return getProductList(selectProduct);

//        try{
//            ResultSet rs =  dbcon.getQueryTable(selectProduct);
//            while(rs.next()){
//                data.add(new Product(rs.getInt("pid"), rs.getString("name"), rs.getDouble("price") ));
//                System.out.println(rs.getInt("pid") + " " +
//                        rs.getString("name") + " " +
//                        rs.getDouble("price")
//                );
//            }
//            rs.close();
//        }catch(Exception e){
//            throw new RuntimeException(e);
////            e.printStackTrace();
//        }
//        return data;

    }

    public static ObservableList<Product> getProductByName(String productName){
//        DatabaseConnection dbcon = new DatabaseConnection();
//        ObservableList<Product> data = FXCollections.observableArrayList();
        String selectProduct = String.format("SELECT * FROM supply_chain.products where name like '%%%s%%'",productName.toLowerCase());
        return getProductList(selectProduct);

//        try{
////            ResultSet rs =  dbcon.getQueryTable(selectProduct);
////            while(rs.next()){
////                data.add(new Product(rs.getInt("pid"), rs.getString("name"), rs.getDouble("price") ));
////                System.out.println(rs.getInt("pid") + " " +
////                        rs.getString("name") + " " +
////                        rs.getDouble("price")
////                );
////            }
////            rs.close();
//
//
//        }catch(Exception e){
//            throw new RuntimeException(e);
////            e.printStackTrace();
//        }
//        return data;
    }

    private static ObservableList<Product> getProductList(String query){
        DatabaseConnection dbcon = new DatabaseConnection();
        ObservableList<Product> data = FXCollections.observableArrayList();
//        String selectProduct = String.format("SELECT * FROM supply_chain.products where name like '%%%s%%'",productName.toLowerCase());
        try{
            ResultSet rs =  dbcon.getQueryTable(query);
            while(rs.next()){
                data.add(new Product(rs.getInt("pid"), rs.getString("name"), rs.getDouble("price") ));
//                System.out.println(rs.getInt("pid") + " " +
//                        rs.getString("name") + " " +
//                        rs.getDouble("price")
//                );
            }
            rs.close();
        }catch(Exception e){
            throw new RuntimeException(e);
//            e.printStackTrace();
        }
        return data;
    }





}
