package com.group3.shoesshop.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.common.collect.Lists;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyUtils {
    public static String generateRandomString(Integer length) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static Boolean upFileToGoogleCloud() {
        try {
            String projectId = "kinetic-highway-331915";
            String bucketName = "test_bucket_syvy";
            String objectName = "test_object.txt";
            String filePath = "test_object.txt";

            File file1 = ResourceUtils.getFile("classpath:kinetic-highway-331915-40ccf03f8100.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(file1.toPath().toString()))
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(credentials).build().getService();
            BlobId blobId = BlobId.of(bucketName, objectName);
            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
            File file = ResourceUtils.getFile("classpath:test_object.txt");
            byte[] sendFile = Files.readAllBytes(file.toPath());
            storage.create(blobInfo, sendFile);

            System.out.println(
                    "File " + filePath + " uploaded to bucket " + bucketName + " as " + objectName);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public static byte[] getFileFromGoogleCloud(String fileName){
        try {
            String projectId = "kinetic-highway-331915";
            String bucketName = "test_bucket_syvy";

            File file1 = ResourceUtils.getFile("classpath:kinetic-highway-331915-40ccf03f8100.json");
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(file1.toPath().toString()))
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(credentials).build().getService();

            Blob blob = storage.get(BlobId.of(bucketName, fileName));
            blob.downloadTo(Paths.get(System.getProperty("java.class.path").split(":")[0] + "/downloaded/" + fileName));

            File file = ResourceUtils.getFile("classpath:downloaded/" + fileName);
            System.out.println(
                    "Downloaded object "
                            + fileName
                            + " from bucket name "
                            + bucketName
                            + " to "
                            + file.toPath());

            return Files.readAllBytes(Paths.get(System.getProperty("java.class.path").split(":")[0]  + "/downloaded/" + fileName));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
