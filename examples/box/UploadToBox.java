import com.sendgrid.*;

public class UploadToBox {
    public static void main(String[] args) {
        String fileName = "dummy_test";
        String type = "text/plain";
        String content = "This test checks if upload to Box works fine";
        InputStream contentStream = new ByteArrayInputStream(content.getBytes(Charset.forName("UTF-8")));
        String contentId = "someId";
        String dispositon = "someDisposition";
        String accessToken = "user's access token";
        String path = "/path/to/folder";
        String content = "This test checks if the builder works fine";
        String folderId = "0";

        Attachments attachments = new Attachments.Builder(fileName, contentStream)
                    .withType(type)
                    .withContentId(contentId)
                    .withDisposition(dispositon)
                    .build();
        String previewLink = attachments.uploadToBox(accessToken, folderId);
        System.out.print("PreviewLink : ", previewLink)
    }
}