package com.example.supplychain;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

public class ProductDetails {
    TableView<Product> productTable;

    public Pane getAllProduct(){
        TableView<Product> table = new TableView<>();

        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn priceCol = new TableColumn("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        ObservableList<Product> data = FXCollections.observableArrayList(
                new Product(2, "abc", 345.0),
                new Product(3, "xyz", 499.99)
        );

        ObservableList<Product> productData = Product.getAllProducts();


        table.setItems(productData);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(idCol, nameCol, priceCol);
        table.setPrefSize(SupplyChain.width - 10, SupplyChain.height-10);

        productTable = table;
        Pane tpane = new Pane();
        tpane.getChildren().add(table);
        tpane.setPrefSize(SupplyChain.width, SupplyChain.height);
//        tpane.setTranslateY(100);
        return tpane;


    }

    public Pane getProductByName(String searchText){
        TableView<Product> table = new TableView<>();

        TableColumn idCol = new TableColumn("Id");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn nameCol = new TableColumn("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn priceCol = new TableColumn("Price");
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        ObservableList<Product> data = FXCollections.observableArrayList(
                new Product(2, "abc", 345.0),
                new Product(3, "xyz", 499.99)
        );

        ObservableList<Product> productData = Product.getProductByName(searchText);


        table.setItems(productData);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        table.getColumns().addAll(idCol, nameCol, priceCol);
        table.setPrefSize(SupplyChain.width - 10, SupplyChain.height-10);
        productTable = table;

        Pane tpane = new Pane();
        tpane.setPrefSize(SupplyChain.width, SupplyChain.height);
        tpane.getChildren().add(table);
//        tpane.setTranslateY(100);
        return tpane;


    }

    public void getSelectedRowValues(){

        TableView<Product> table = productTable;
        if(productTable==null){
            System.out.printf("Table object not found");
            return;
        }
        if (productTable.getSelectionModel().getSelectedIndex() != -1) {
            Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
            System.out.println("Harshit");
            System.out.println(selectedProduct.getId() + " " + selectedProduct.getName() + " " +  selectedProduct.getPrice());
//            nameTextField.setText(selectedProduct.getName());
//            addressTextField.setText(selectedProduct.getAddress());
        }
        else{
            System.out.println("Nothing selected");
        }
    }

    public int getProductId(){
        Product selectedProduct = productTable.getSelectionModel().getSelectedItem();
        if(selectedProduct!=null){
            return selectedProduct.getId();
        }
        return -1;
    }


}
