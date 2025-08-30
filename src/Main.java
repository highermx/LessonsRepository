import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        FileStorage storage = new FileStorage(Paths.get("/data/storage"));
        storage.put("documents", "report.pdf", Paths.get("local_report.pdf"));

        FileStorageReader reader = new FileStorageReader(storage);
        byte[] fullContent = reader.read("documents", "report.pdf");
        List<byte[]> chunks = reader.read("documents", "report.pdf", 4096);

    }
}
