import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {

    public static void writeToFile(String filePath, List<Product> products){

        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(products);
            oos.close();
            fos.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    public static List<Product> readDataFromFile(String filePath){
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            ObjectInputStream ois = new ObjectInputStream(fis);
            products = (List<Product>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            System.err.println("Class Product is missing!");
        }
        return products;
    }


    public static void main(String[] args) {
        List<Product> shop = new ArrayList<>();
        shop.add( new Product("1", "A", "MadeA", "None", 1.0));
        shop.add( new Product("2", "B", "MadeB", "None", 2.0));
        shop.add( new Product("3", "C", "MadeC", "None", 3.0));

        writeToFile("products.txt", shop);
        List<Product> extractedData = readDataFromFile("products.txt");
        for (Product product: extractedData){
            System.out.println(product);
        }
    }
}
