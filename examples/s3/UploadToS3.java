import com.sendgrid.*;
public class UploadToS3 {
    public static void main(String[] args) throws IOException {
        String bucketName = "Provide Your bucket name";
        String secretKey = "Provide Your secret key";
        String accessKey = "Provide Your access key";
        String fileName = "dummy_file";
        String type = "text/plain";
        String content = "This test checks if the builder works fine";
        InputStream contentStream = new ByteArrayInputStream(content.getBytes(Charset.forName("UTF-8")));
        String contentId = "someId";
        String dispositon = "someDisposition";

        Attachments attachments = new Attachments.Builder(fileName, contentStream)
                .withType(type)
                .withContentId(contentId)
                .withDisposition(dispositon)
                .build();
        attachments.uploadToS3(accessKey, secretKey, bucketName);
    }
}