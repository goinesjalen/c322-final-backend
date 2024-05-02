package edu.iu.habahram.c322final.repository;

import edu.iu.habahram.c322final.model.Flower;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlowerFileRepository {

    private static String IMAGES_FOLDER_PATH = "flowers/images/";
    private String DATABASE_NAME = "flowers/flowers.txt";
    private static final String NEW_LINE = System.lineSeparator();

    public FlowerFileRepository() {
        File flowersImagesDirectory = new File("flowers/images");
        if (!flowersImagesDirectory.exists()) {
            flowersImagesDirectory.mkdirs();
        }
    }

    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    public int add(Flower flower) throws IOException {
        List<Flower> flowers = findAll();
        int maxId = 0;
        for (int i = 0; i < flowers.size(); i++) {
            if (flowers.get(i).getId() > maxId) {
                maxId = flowers.get(i).getId();
            }
        }
        int id = maxId + 1;
        Path path = Paths.get(DATABASE_NAME);
        String data = flower.toLine(id);
        appendToFile(path, data + NEW_LINE);
        return id;
    }




    public List<Flower> findAll() throws IOException {
        List<Flower> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            if(!line.trim().isEmpty()) {
                Flower d = Flower.fromLine(line);
                result.add(d);
            }
        }

        return result;
    }

    public Flower find(int id) throws IOException {
        List<Flower> flowers = findAll();
        for(Flower flower : flowers) {
            if (flower.getId() == id) {
                return flower;
            }
        }
        return null;
    }
    public List<Flower> search(String type) throws IOException {
        List<Flower> flowers = findAll();
        List<Flower> result = new ArrayList<>();
        for(Flower flower : flowers) {
            if (type != null && !flower.getType().equalsIgnoreCase(type)) {
                continue;
            }
            result.add(flower);
        }
        return result;
    }

    public static byte[] getImage(int id) throws IOException {
        String fileExtension = ".jpeg";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        byte[] image = Files.readAllBytes(path);
        return image;
    }

    public boolean updateImage(int id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        String fileExtension = ".jpeg";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        System.out.println("The file " + path + " was saved successfully.");
        file.transferTo(path);
        return true;
    }

}
