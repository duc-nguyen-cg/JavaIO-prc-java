import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class Copy {
    public static void copyBinaryFile(String sourcePath, String targetPath){
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);

        try {
            if (targetFile.exists()){
                throw new FileAlreadyExistsException(targetPath);
            }
            FileInputStream fis = new FileInputStream(sourceFile);
            FileOutputStream fos = new FileOutputStream(targetFile);

            int i = -1;
            int count = 0;
            while ((i = fis.read()) != -1){
                count++;
                fos.write(i);
            }
            fos.flush();
            fis.close();
            fos.close();
            System.out.println("Copied "+count+" bytes successfully!");

        } catch (FileNotFoundException e){
            System.err.println("The source file cannot be found!");
        } catch (FileAlreadyExistsException e){
            System.err.println("The target file already exists!");
        } catch (IOException e){
            System.err.println("Cannot copy!");
        }
    }


    public static void main(String[] args) {
        String sourcePath = "source.txt";
        String targetPath = "target.txt";
        copyBinaryFile(sourcePath, targetPath);
    }
}
