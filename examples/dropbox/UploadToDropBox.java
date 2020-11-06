package dropbox;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.sendgrid.Attachments;
import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;

/*
    Add Dropbox dependencies for compiling code
    Gradle : compile 'com.dropbox.core:dropbox-core-sdk:3.0.5'
    maven :
    <dependency>
       <groupId>com.dropbox.core</groupId>
       <artifactId>dropbox-core-sdk</artifactId>
       <version>3.0.5</version>
    </dependency>
 */
public class UploadToDropBox {
    public static void main(String[] args) {
        String fileName = "book3.txt";
        String type = "text/plain";
        String content = "This test checks if the builder works fine";
        InputStream contentStream = new ByteArrayInputStream(content.getBytes(Charset.forName("UTF-8")));
        String contentId = "someId";
        String dispositon = "someDisposition";
        String accessToken = "user's access token";
        String path = "/path/to/folder";

        Attachments attachments = new Attachments.Builder(fileName, contentStream)
            .withType(type)
            .withContentId(contentId)
            .withDisposition(dispositon)
            .build();
        String returnPath = uploadToDropbox(attachments, accessToken, path);
        System.out.println("Path: " + returnPath);
    }

    /**
     * Uploads attachment to Dropbox
     *
     * @param attachments attachment to be uploaded
     * @param accessToken user's Dropbox access token
     * @param path        path of the folder in which attachment needs to be added. Should not end with /
     * @return the full path to the uploaded file
     */
    private static String uploadToDropbox(Attachments attachments, String accessToken, String path) {
        try {
            DbxRequestConfig config = DbxRequestConfig.newBuilder("sendgrid/0.1").build();
            DbxClientV2 client = new DbxClientV2(config, accessToken);
            FileMetadata uploadedFile = client.files().upload(String.format("%s/%s", path, attachments.getFilename()))
                .uploadAndFinish(new ByteArrayInputStream((Base64.decodeBase64(attachments.getContent()))));
            return uploadedFile.getPathDisplay();
        } catch (Exception ex) {
            throw new RuntimeException("Error while uploading to Dropbox", ex);
        }
    }
}
