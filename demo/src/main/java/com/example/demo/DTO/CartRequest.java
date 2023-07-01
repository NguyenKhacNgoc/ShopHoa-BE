package com.example.demo.DTO;

public class CartRequest {
    private Long cartID;
    private Long productID;
    private Long userID;
    private int quantity;

    public Long getCartID() {
        return this.cartID;
    }

    public void setCartID(Long cartID) {
        this.cartID = cartID;
    }

    public Long getProductID() {
        return this.productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getUserID() {
        return this.userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
