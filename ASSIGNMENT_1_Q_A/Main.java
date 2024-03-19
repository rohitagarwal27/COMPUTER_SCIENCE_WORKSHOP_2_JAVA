// Q4. Write a Java code snippet comprising two classes: Laptop and Main. The Laptop class 
// defines private fields model and price, alongside setter methods for each attribute. 
// Additionally, it overrides the toString() method to return a string representation of the laptop's 
// model and price. In the Main class, create an instance of Laptop, setting its model using the 
// setter method. Then, print the laptop object using the toString() method. Describe the 
// functionality of the toString() method in the Laptop class and explain how it is utilized in the 
// Main class.

class Laptop {
    private String model;
    private int price;

    public void setModel(String model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MODEL : " + model + " & PRICE : " + price;
    }
}

public class Main {
    public static void main(String[] args) {
        Laptop obj = new Laptop();
        obj.setModel("Realme");
        obj.setPrice(40000);

        System.out.println(obj); // here actually compiler automatically call obj.toString() internally
    }
}

// output MODEL : Realme & PRICE : 40000