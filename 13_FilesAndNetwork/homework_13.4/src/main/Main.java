
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    //public static File lentaFile = new File("index.html");
    public static String lentaFile = "https://lenta.ru/";
    public static String imagesPath = "images/";

    public static void main(String[] args) {

        if (!Files.isDirectory(Paths.get(imagesPath))) {   // создали папку
            new File(imagesPath).mkdir();
        }

        try { // получили список URL

            Document lentaDoc = Jsoup.connect(lentaFile).userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com").get();

            //    Document lentaDoc = Jsoup.parse(lentaFile, "UTF-8", "Lenta.ru");

            Elements images = lentaDoc.select("img");

            for (Element u : images) {
                String imageAbsUrl = u.absUrl("src").replaceAll("https","http");
                if (imageAbsUrl.contains(".jpg") || imageAbsUrl.contains(".png") || imageAbsUrl.contains(".gif")) {
                    String imageName = imageAbsUrl.substring(imageAbsUrl.lastIndexOf("/") + 1);
                    URL initialImage = new URL(imageAbsUrl);

                        BufferedImage img = ImageIO.read(initialImage);
                        ImageIO.write(img, "jpg", new File(imagesPath + imageName));

                   System.out.println(imageName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

