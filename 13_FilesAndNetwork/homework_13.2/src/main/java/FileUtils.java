import java.io.File;
import java.nio.file.Files;

public class FileUtils {

    public static void copyFolder(String sourceDirectory, String destinationDirectory)
    {

        File srcFolder = new File(sourceDirectory);
        File destFolder = new File(destinationDirectory);

        if(srcFolder.isDirectory()){
            try {

                if (!destFolder.exists()) {
                    destFolder.mkdir();
                    System.out.println("Папка "
                            + srcFolder + " создана  в " + destFolder);
                }

                String[] files = srcFolder.list();

                for (String file : files) {
                    File srcFile = new File(srcFolder, file);
                    File destFile = new File(destFolder, file);

                    copyFolder(srcFile.toString(), destFile.toString());
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }else{

            try {
            Files.copy(srcFolder.toPath(), destFolder.toPath());

                System.out.println("Файл успешно скопирован.");

            }
            catch (Exception e){
                e.printStackTrace();

            }

        }
    }
}