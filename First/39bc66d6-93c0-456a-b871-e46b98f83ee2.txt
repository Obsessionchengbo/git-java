package Experiment6;

import java.io.*;
import java.util.UUID;

public class Copy {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
    if (args.length != 1) {
        System.out.println("Usage: java Copy sourceFile");
        System.exit(1);

    }

    File sourceFile = new File(args[0]);
    if (!sourceFile.exists()) {
        System.out.println("Source file " + args[0] + " does not exist");
        System.exit(2);
    }

    String targetFileName = UUID.randomUUID().toString() + "." + getFileExtension(sourceFile.getName());
    File targetFile = new File(targetFileName);
    if (targetFile.exists()) {
        System.out.println("Target file " + targetFileName + " already exists");
        System.exit(3);
    }

    try (
            BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
    ) {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        long endTime=System.currentTimeMillis();
        System.out.println(sourceFile.getName() + " copied to " + targetFileName);
    }
}

    private static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex == -1) {
            return "";
        } else {
            return fileName.substring(dotIndex + 1);
        }
    }
}
