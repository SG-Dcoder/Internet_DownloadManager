
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class cn_proj {

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter the file URL: ");
            String fileURL = reader.readLine();

            System.out.print("Enter the directory to save the file: ");
            String saveDir = reader.readLine();

            System.out.print("Enter the file name (including extension): ");
            String fileName = reader.readLine();

            Downloadmanager downloadManager = new Downloadmanager();
            downloadManager.addDownload(fileURL, saveDir, fileName);
            downloadManager.startDownloads();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Downloadmanager {

    private static final int BUFFER_SIZE = 1024;

    // Represents a download task
    private static class DownloadTask {
        String url;
        String folder;
        String fileName;

        DownloadTask(String url, String folder, String fileName) {
            this.url = url;
            this.folder = folder;
            this.fileName = fileName;
        }
    }

    // Download queue
    private List<DownloadTask> downloadQueue = new ArrayList<>();

    // Add a download task to the queue
    public void addDownload(String url, String folder, String fileName) {
        downloadQueue.add(new DownloadTask(url, folder, fileName));
    }

    // Start downloading all tasks in the queue
    public void startDownloads() {
        for (DownloadTask task : downloadQueue) {
            downloadFile(task.url, task.folder, task.fileName);
        }
    }

    // Download a file from a given URL to a specified folder and file name
    private void downloadFile(String fileURL, String saveDir, String fileName) {
        try {
            URL url = new URL(fileURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            File file = new File(saveDir + File.separator + fileName);
            long existingFileSize = 0;

            if (file.exists()) {
                existingFileSize = file.length();
                System.out.println("Resuming download from " + existingFileSize + " bytes");
                connection.setRequestProperty("Range", "bytes=" + existingFileSize + "-");
            }

            try (InputStream inputStream = connection.getInputStream();
                 RandomAccessFile outputStream = new RandomAccessFile(file, "rw")) {

                outputStream.seek(existingFileSize);

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                long totalBytesRead = existingFileSize;
                long totalFileSize = connection.getContentLength();

                System.out.println("Downloading: " + fileName);

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                    printProgress(totalBytesRead, totalFileSize);
                }

                System.out.println("\nDownload completed!");

            } catch (IOException e) {
                System.err.println("Download failed: " + e.getMessage());
            } finally {
                connection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printProgress(long bytesRead, long totalBytes) {
        double progress = (double) bytesRead / totalBytes * 100;
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.printf("\rProgress: %s%%", df.format(progress));
    }
}
