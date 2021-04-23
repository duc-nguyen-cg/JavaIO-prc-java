import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ReadAndWriteFile {

    public List<Integer> readFile(String filePath){
        List<Integer> array = new ArrayList<>();
        try {
            File inFile = new File(filePath);
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            String line = "";

            while ((line = reader.readLine()) != null){
                int i = Integer.parseInt(line);
                array.add(i);
            }
            reader.close();

        } catch (IOException e){
            System.err.println("The file doesn't exist!");
        } catch (NumberFormatException e){
            System.err.println("Some data in the file cannot be casted to integers!");
        }
        return array;
    }


    public void writeFile(String filePath){
        try {
            File inFile = new File(filePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(inFile));
            Random rd = new Random();
            for (int i = 0; i < 10; i++){
                writer.write(Integer.toString(rd.nextInt(100)));
                writer.newLine();
            }
            writer.write("abc");
            writer.close();
        } catch (IOException e){
            System.err.println("The file doesn't exist or cannot be opened!");
        }
    }

    public static int findMaxInt(List<Integer> array){
        int max = Integer.MIN_VALUE;
        for (int element: array){
            if (max < element){
                max = element;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        String source = "numbers.txt";
        ReadAndWriteFile fileExample = new ReadAndWriteFile();

        fileExample.writeFile(source);
        List<Integer> result = fileExample.readFile(source);
        System.out.println(result);
        System.out.println("Max = "+ findMaxInt(result));
    }
}
