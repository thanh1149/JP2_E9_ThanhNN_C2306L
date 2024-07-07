package Entity;

public class ExceptionDesign extends Exception {

    public static class NotFoundProductIdException extends Exception {
        public NotFoundProductIdException() {
            super("Product ID not found.");
        }
    }

    public static class NotFoundCustomerIdException extends Exception {
        public NotFoundCustomerIdException() {
            super("Customer ID not found.");
        }
    }

    public static class NotFoundOrderIdException extends Exception {
        public NotFoundOrderIdException() {
            super("Order ID not found.");
        }
    }

    public static class InvalidProductIdException extends Exception {
        public InvalidProductIdException() {
            super("Invalid Product ID.");
        }
    }

    public static class InvalidProductNameException extends Exception {
        public InvalidProductNameException() {
            super("Invalid product name.");
        }
    }

    public static class InvalidQuantityException extends Exception {
        public InvalidQuantityException() {
            super("Invalid quantity.");
        }
    }

    public static class InvalidOrderIdException extends Exception {
        public InvalidOrderIdException() {
            super("Invalid Order ID.");
        }
    }

    public static class NotEnoughInventoryNumberException extends Exception {
        public NotEnoughInventoryNumberException() {
            super("Not enough quantity in inventory.");
        }
    }
}
