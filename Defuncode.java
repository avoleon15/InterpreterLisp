import java.util.*;


class Bicycle {
    int id;
    String brand;
    String model;
    double price;
    String condition;

    public Bicycle(int id, String brand, String model, double price, String condition) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.condition = condition;
    }
}

class Sale {
    String id;
    Bicycle bicycle;
    Customer customer;
    Date date;
    double price;

    public Sale(String id, Bicycle bicycle, Customer customer, Date date, double price) {
        this.id = id;
        this.bicycle = bicycle;
        this.customer = customer;
        this.date = date;
        this.price = price;
    }
}

class Customer {
    String name;
    String email;
    List<Sale> purchases;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchases = new ArrayList<>();
    }
}


class Shop {
    String name;
    List<Bicycle> bicycles;
    List<Sale> sales;
    List<Customer> customers;

    public Shop(String name) {
        this.name = name;
        this.bicycles = new ArrayList<>();
        this.sales = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void addBicycle(Bicycle bicycle) {
        bicycles.add(bicycle);
    }

    public void removeBicycle(Bicycle bicycle) {
        bicycles.remove(bicycle);
    }

    public void makeSale(Bicycle bicycle, Customer customer) {
       
    }

    public Customer findCustomerByEmail(String email) {
        for (Customer customer : customers) {
            if (customer.email.equals(email)) {
                return customer;
            }
        }
        return null; // Si no se encuentra ningún cliente con el correo dado
    }

    public void printSales() {
        for (Sale sale : sales) {
            System.out.println("Venta ID: " + sale.id);
            // Imprimir detalles de la venta
        }
    }
}


interface iEvaluator {
    String name();
    List<Bicycle> bicycles();
}


class ExecutorContent implements iEvaluator {
    
}


class FunctionDefinition {
    
}

public class Main {
    public static void main(String[] args) {
        
    }

    // Método para mostrar resultados
    public static void display() {
        
    }
}

