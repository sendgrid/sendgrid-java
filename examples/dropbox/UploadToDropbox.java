import com.sendgrid.*;

public class UploadToDropbox {
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
    String returnPath = attachments.uploadToDropbox(accessToken, path);
    System.out.println("Path: " + returnPath);
  }
}