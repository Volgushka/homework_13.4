import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtils {

    private static final Logger logger = LogManager.getLogger(Main.class);


    public static long calculateFolderSize(String path) {
        long count = 0;

        try {

            File folder = new File(path);
            File[] listOfFiles = folder.listFiles();

            for (File file : listOfFiles) {
                if (file.isFile())
                    count += file.length();
                else
                    count += calculateFolderSize(file.getAbsolutePath());}

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Неверный путь либо такой папки не существует: " + path + " " + e);
        }
       return count;
    }


    public static String getFolderSize(String path)
    {

        double folderSize = calculateFolderSize(path);

        if (folderSize < 1024)
        {
            return folderSize + " б";

        } else if (folderSize < 1048576)
        {
            String result = String.format("%.1f", folderSize / 1024);
            return result + " Кб";

        } else if (folderSize < 1073741824)
        {
            String result = String.format("%.1f", folderSize / 1048576);
            return result + " Мб";
        }

        String result = String.format("%.1f", folderSize / 1073741824);
        return result + " Гб";
    }

}
