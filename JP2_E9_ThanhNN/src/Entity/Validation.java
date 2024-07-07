package Entity;

public class Validation {
    //validate Product
    public static boolean validateProductID(String productID){
        String patternProductID = "^(MS|NE|SE)[0-9]{6}$";
        return productID.matches(patternProductID);
    }

    public static boolean validateProductName(String productName){
        String patternProductName = "^[a-zA-Z ]+$";
        return productName.matches(patternProductName);
    }

    public static boolean validateProductQuantity(int productQuantity){
        return productQuantity >= 0;
    }

    //validate Customer
    public static boolean validateCustomerName(String customerName){
        String patternCustomerName = "^[a-zA-Z ]{3,50}$";
        return customerName.matches(patternCustomerName);
    }

    public static boolean validateCustomerID(int customerID){
        return customerID > 0;
    }

    //Validate Order
    public static boolean validateOrderID(String orderID){
        String patternOrderID = "^(ORDPM)[0-9]{8}$";
        return orderID.matches(patternOrderID);
    }

    //Validate OrderDetail
    public static boolean validateOrderDetailQuantity(int quantity){
        return quantity > 0;
    }

}
