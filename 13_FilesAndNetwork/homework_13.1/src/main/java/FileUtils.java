import java.io.File;
import java.util.List;

public class FileUtils {

    public static long calculateFolderSize(String path) {

        long count = 0;

        File folder = new File (path);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile())
                count += file.length();
            else
                count += calculateFolderSize(file.getAbsolutePath());
        }
        return count;
    }




    public static String FolderSize(String path) {

       double folderSize = calculateFolderSize(path);

        if (folderSize < 1024) {
            return folderSize + " б";

        } else if (folderSize < 1048576) {
            String result = String.format("%.1f",folderSize/1024);
            return result + " Кб";

        } else if (folderSize < 1073741824) {
            String result = String.format("%.1f",folderSize/1048576);
            return result  + " Мб";
        }

        String result = String.format("%.1f",folderSize/1073741824);
        return result + " Гб";
    }
}



