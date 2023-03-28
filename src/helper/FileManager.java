package helper;

import model.Customer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileManager {

    private static final String outputFilePath = "E:\\2023\\cpp\\data\\output\\";

    //Read All Customers from File
    public static List<Customer> readCustomersFromFile(String inputFilePath) {
        List<String> fileInputList = Collections.emptyList();

        try {
            fileInputList = Files.readAllLines(Paths.get(inputFilePath), StandardCharsets.UTF_8);
            System.out.println("File read successful.");
        } catch (IOException e) {
            System.out.println("Might be the file is not available in directory. Please check. File read failed with error: " + e.getMessage());
        }

        //Convert and return the Input Customer String List to Customer Model List
        return CustomerPojoConverter.customerInputToPojoList(fileInputList);
    }

    //Write customers in file as per synchronized process
    public static synchronized void writeCustomersInFile(String threadName, List<Customer> customerList) throws IOException {

        RandomAccessFile file = new RandomAccessFile(outputFilePath + threadName + ".txt", "rw");
        FileChannel channel = file.getChannel();

        try {
            for (Customer customer : customerList) {
                String data = customer.toOutputString() + System.lineSeparator();
                ByteBuffer buffer = ByteBuffer.wrap(data.getBytes());
                channel.position(channel.size());
                channel.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            channel.close();
            file.close();
        }

    }

}
