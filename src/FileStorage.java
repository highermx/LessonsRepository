import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class FileStorage implements ObjectStorage<Path> {

    private final Path rootDirectory;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, Path>> storage = new ConcurrentHashMap<>();

    public FileStorage(Path rootPath) throws IOException {
        this.rootDirectory = Files.createDirectories(rootPath);
    }

    @Override
    public void put(String namespace, String name, Path object) throws IOException {
        Path target = rootDirectory.resolve(namespace).resolve(name);
        Files.createDirectories(target.getParent());
        Files.copy(object, target, StandardCopyOption.REPLACE_EXISTING);

        storage.computeIfAbsent(namespace, k -> new ConcurrentHashMap<>())
                .put(name, target);
    }

    @Override
    public Path get(String namespace, String name) throws ObjectNotFoundException {
        return Optional.ofNullable(storage.get(namespace))
                .map(m -> m.get(name))
                .orElseThrow(() -> new ObjectNotFoundException(
                        "Object not found in namespace: " + namespace + ", name: " + name));
    }
}
