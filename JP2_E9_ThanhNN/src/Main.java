import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.OrderDetailDAO;
import DAO.ProductDAO;
import Entity.*;
import Service.*;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();
        OrderDetailDAO odsDAO = new OrderDetailDAO();

        List<Product> productList = productDAO.getAll();
        List<Customer> customerList = customerDAO.getAll();
        List<Order> orderList = orderDAO.getAll();
        List<OrderDetail> orderDetailList = odsDAO.getAll();

        Order order = new Order();
        OrderDetail orderDetail = new OrderDetail();
        Product product = new Product();

        Thread t1,t2,t3;
        String productID,orderID;
        int quantity,cus_id;

        OrderThread orderThread = new OrderThread(order,product,orderDetail,orderDAO);
        OrderDetailThread orderDetailThread = new OrderDetailThread(order, product,orderDetail,odsDAO);
        ProductThread productThread = new ProductThread(product,orderDetail,productDAO);



        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter order id: ");
            orderID = bufferedReader.readLine();
            if(!Validation.validateOrderID(orderID)){
                System.out.println("Wrong orderID");
                return;
            }
            if(orderDAO.getById(orderID) != null){
                System.out.println("Order Id already exist.");
                return;
            }

            System.out.print("Enter customer id: ");
            cus_id = Integer.parseInt(bufferedReader.readLine());
            if(customerDAO.getById(cus_id) == null){
                System.out.println("Customer not exist.");
                return;
            }
            order.setId(orderID);
            order.setCus_id(cus_id);
            order.setDateTime(LocalDateTime.now());

            System.out.print("Enter Product ID: ");
            productID = bufferedReader.readLine();
            if(!Validation.validateProductID(productID)){
                System.out.println("Wrong productID (ex:(MS|NE|SE)xxxx)");
                return;
            }

            if(productDAO.getById(productID) == null){
                System.out.println("No product ID found.");
                return;
            }
            System.out.print("Enter Quantity: ");
            try {
                quantity = Integer.parseInt(bufferedReader.readLine());
                if(!Validation.validateOrderDetailQuantity(quantity)){
                    System.out.println("Product quantity must > 0");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid quantity entered.");
                return;
            }
            orderDetail.setId(0);
            orderDetail.setOrder_id(orderID);
            orderDetail.setProduct_id(productID);
            orderDetail.setQuantity(quantity);
            orderDetail.setStatus(Status.PENDING);

            t1 = new Thread(orderThread);
            t2 = new Thread(orderDetailThread);
            t3 = new Thread(productThread);

            try{
                t1.start();
                t2.start();
                t3.start();
                t1.join();
                t2.join();
                t3.join();
            }catch(IOError |InterruptedException e){
                System.out.println(e.getMessage());
            }

            System.out.println("New OrderDetail created: " + orderDetail);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        orderDetailList.forEach(System.out::println);
        orderList.forEach(System.out::println);
        productList.forEach(System.out::println);
    }
}