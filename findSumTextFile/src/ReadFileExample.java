import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public void writeFileText(String filePath){
        try {
            File outFile = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

            for (int i = 1; i <= 100; i++){
                writer.write(Integer.toString(i));
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("The file doesn't exist!");
        }
    }


    public void  readFileText(String filePath){
        try {
            File inFile = new File(filePath);

            if (!inFile.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            String line = "";
            int sum = 0;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
                sum += Integer.parseInt(line);
            }
            reader.close();
            System.out.println("Sum = "+ sum);

        } catch (IOException e) {
            System.err.println("The file doesn't exist!");
        } catch (NumberFormatException e){
            System.err.println("Data in the file cannot be casted to integers!");
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file path: ");
        String filePath = scanner.nextLine();

        ReadFileExample readFile = new ReadFileExample();
        readFile.writeFileText(filePath);
        readFile.readFileText(filePath);
    }
}
