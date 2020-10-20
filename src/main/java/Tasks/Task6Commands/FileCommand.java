package Tasks.Task6Commands;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class FileCommand implements Command {
    @Override
    public int executeCommand(String commandString, Path path) {

        try {
            String[] args = commandString.split(" ");

            switch (args[1]) {
                case "create":
                    fileCreator(path.toString() + "\\" + args[2]);
                    break;
                case "rm":
                    fileRemover(args[2]);
                    break;
                case "read":
                    readFile(args[2]);
                    break;
                case "rewrite":
                    rewriteFile(args[2], args[3]);
                    break;
                case "append":
                    appendFile(args[2], args[3]);
                    break;

                default:
                    System.out.println("invalid argument");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private int rewriteFile(String fileName, String text) {

        File file = new File(fileName);

        try (PrintWriter printWriter = new PrintWriter(file)) {

            printWriter.write(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -5;
        }

        return 0;
    }

    private int appendFile(String fileName, String text) {

        File file = new File(fileName);


        try {
            FileWriter fileWriter = new FileWriter(fileName, true);

            fileWriter.write(text + "\n");
            fileWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -6;
        } catch (IOException e) {
            e.printStackTrace();
            return -6;
        }

        return 0;
    }

    private int readFile(String fileName) {

        String line;

        File file = new File(fileName);

        try (Scanner fileScanner = new Scanner(file)) {

            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return -4;
        }

        return 0;
    }

    private int fileCreator(String fileName) {
        System.out.println(fileName);
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("File " + fileName.substring(fileName.lastIndexOf("\\") + 1) + " exists");
            return -2;
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }

    private int fileRemover(String fileName) {

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist");
            return -3;
        }

        file.delete();

        return 0;
    }

    @Override
    public String commandName() {
        return "file";
    }
}
