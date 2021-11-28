package com.group3.shoesshop.utils;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.*;
import com.google.common.collect.Lists;
import com.group3.shoesshop.constant.Constant;
import com.group3.shoesshop.entity.OrderItemEntity;
import com.group3.shoesshop.entity.UserEntity;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

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

    public static Boolean upFileToGoogleCloud(String fileName, byte[] data) {
//        try {
//            ResourceBundle rb = ResourceBundle.getBundle("google_cloud");
//
//            String projectId = rb.getString("project.id");
//            String bucketName = rb.getString("bucket.name");
//            String authFilePath = rb.getString("auth.file.path");
//            String platformLink = rb.getString("platform.link");
//
//            File authFile = ResourceUtils.getFile(authFilePath);
//            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(authFile.toPath().toString()))
//                    .createScoped(Lists.newArrayList(platformLink));
//            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(credentials).build().getService();
//            BlobId blobId = BlobId.of(bucketName, fileName);
//            BlobInfo blobInfo = BlobInfo.newBuilder(blobId).build();
////            File file = ResourceUtils.getFile("classpath:test_object.txt");
////            byte[] sendFile = Files.readAllBytes(file.toPath());
//            storage.create(blobInfo, data);
//
//            System.out.println(
//                    "File " + fileName + " uploaded to bucket " + bucketName);
//
//            return true;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return false;
//        }

        try (FileOutputStream fos = new FileOutputStream("downloaded/" + fileName)) {
            fos.write(data);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static byte[] getFileFromGoogleCloud(String fileName){
        try {
            ResourceBundle rb = ResourceBundle.getBundle("google_cloud");
            String projectId = rb.getString("project.id");
            String bucketName = rb.getString("bucket.name");
            String authFilePath = rb.getString("auth.file.path");
            String platformLink = rb.getString("platform.link");
            String downloadedPath = rb.getString("downloaded.path");

            File authFile = ResourceUtils.getFile(authFilePath);
            GoogleCredentials credentials = GoogleCredentials.fromStream(new FileInputStream(authFile.toPath().toString()))
                    .createScoped(Lists.newArrayList(platformLink));
            Storage storage = StorageOptions.newBuilder().setProjectId(projectId).setCredentials(credentials).build().getService();

            Blob blob = storage.get(BlobId.of(bucketName, fileName));
            blob.downloadTo(Paths.get(downloadedPath + "/" + fileName));

            File file = ResourceUtils.getFile(downloadedPath + "/" + fileName);
            System.out.println(
                    "Downloaded object "
                            + fileName
                            + " from bucket name "
                            + bucketName
                            + " to "
                            + file.toPath());

            return Files.readAllBytes(Paths.get(downloadedPath + "/" + fileName));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static UserEntity getUserFromSession(HttpServletRequest request) {
        UserEntity userSession = (UserEntity) request.getSession().getAttribute(Constant.USER_SESSION);
        if (userSession == null)
            return null;

        return userSession;
    }
}
