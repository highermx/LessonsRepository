import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileStorageReader implements ObjectStorageReader {

    private final FileStorage storage;

    public FileStorageReader(FileStorage storage) {
        this.storage = storage;
    }

    @Override
    public byte[] read(String namespace, String name) throws IOException {
        Path filePath = storage.get(namespace, name);
        return Files.readAllBytes(filePath);
    }

    @Override
    public List<byte[]> read(String namespace, String name, int chunkSize) throws IOException {
        Path filePath = storage.get(namespace, name);
        List<byte[]> chunks = new ArrayList<>();

        try (FileChannel channel = FileChannel.open(filePath, StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(chunkSize);

            while (channel.read(buffer) > 0) {
                buffer.flip();
                byte[] chunk = new byte[buffer.remaining()];
                buffer.get(chunk);
                chunks.add(chunk);
                buffer.clear();
            }
        }
        return chunks;
    }
}
