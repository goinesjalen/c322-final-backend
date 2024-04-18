package edu.iu.habahram.ducksservice.repository;

import edu.iu.habahram.ducksservice.model.Customer;
import edu.iu.habahram.ducksservice.model.DuckData;
import edu.iu.habahram.ducksservice.model.DuckRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Repository
public interface DucksRepository extends CrudRepository<DuckRecord, String> {
    DuckRecord findById(int id);

    String IMAGES_FOLDER_PATH = "ducks/images/";
    String AUDIO_FOLDER_PATH = "ducks/audio/";

     default boolean updateImage(int id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        String fileExtension = ".png";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        System.out.println("The file " + path + " was saved successfully.");
        file.transferTo(path);
        return true;
    }
     default boolean updateAudio(int id, MultipartFile file) throws IOException {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());

        String fileExtension = ".mp3";
        Path path = Paths.get(AUDIO_FOLDER_PATH
                + id + fileExtension);
        System.out.println("The file " + path + " was saved successfully.");
        file.transferTo(path);
        return true;
    }


     default byte[] getImage(int id) throws IOException {
        String fileExtension = ".png";
        Path path = Paths.get(IMAGES_FOLDER_PATH
                + id + fileExtension);
        byte[] image = Files.readAllBytes(path);
        return image;
    }

     default byte[] getAudio(int id) throws IOException {
        String fileExtension = ".mp3";
        Path path = Paths.get(AUDIO_FOLDER_PATH
                + id + fileExtension);
        byte[] file = Files.readAllBytes(path);
        return file;
    }
}
