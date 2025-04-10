package tn.esprit.khotwaback.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.khotwaback.entities.Cours;
import tn.esprit.khotwaback.repositories.CoursRepository;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CoursService implements ICoursService{
    @Autowired
    private CoursRepository coursRepository;
    private Cloudinary getCloudinaryInstance() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dq053blwo",
                "api_key", "618818113881227",
                "api_secret", "pLEEooX8uFRrcQ3tDe693PQTG8w"
        ));
    }
    private String uploadImageToCloud(MultipartFile image) throws IOException {
        Cloudinary cloudinary = getCloudinaryInstance();
        Map<String, Object> uploadResult = cloudinary.uploader().upload(image.getBytes(), ObjectUtils.emptyMap());
        return uploadResult.get("url").toString();
    }
    private String uploadFileToCloud(MultipartFile file) throws IOException {
        Cloudinary cloudinary = getCloudinaryInstance();
        Map<String, Object> params = ObjectUtils.asMap("resource_type", "auto");
        Map<String, Object> uploadResult = cloudinary.uploader().upload(file.getBytes(), params);
        return uploadResult.get("url").toString();
    }

    private String uploadVideoToCloud(MultipartFile video) throws IOException {
        Cloudinary cloudinary = getCloudinaryInstance();
        Map<String, Object> params = ObjectUtils.asMap("resource_type", "video");
        Map<String, Object> uploadResult = cloudinary.uploader().upload(video.getBytes(), params);
        return uploadResult.get("url").toString();
    }
    @Override
    public Cours addCours(Cours cours ,MultipartFile image, MultipartFile fichier, MultipartFile video) {
        try {
            String imageUrl = uploadImageToCloud(image);
            cours.setImage(imageUrl);
            if (fichier != null && !fichier.isEmpty()) {
                String fichierUrl = uploadFileToCloud(fichier);
                cours.setFichier(fichierUrl);
            }

            if (video != null && !video.isEmpty()) {
                String videoUrl = uploadVideoToCloud(video);
                cours.setVideo(videoUrl);
            }
            return coursRepository.save(cours);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload image");

        }

    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public List<Cours> retrieveAllCours() {
       /* List<Cours> cours = coursRepository.findAll();
        if (!cours.isEmpty()) {
            log.info("Liste des cours récupérée : " ,cours);
        } else {
            log.info("Aucun cour trouvé dans la base de données.");
        }*/
        return coursRepository.findAll();
    }

    @Override
    public Cours retrieveById(Long id_cours) {
        return coursRepository.findById(id_cours).orElse(null);
    }

    @Override
    public void deleteCoursById(Long id_cours) {
        coursRepository.deleteById(id_cours);
    }

    @Override
    public List<Cours> searchCoursByTitre(String titre) {
        return coursRepository.findByTitreContainingIgnoreCase(titre);
    }

    @Override
    public Cours getCourseByTitle(String title) {
        List<Cours> courses = coursRepository.findByTitreContainingIgnoreCase(title);
        return courses.isEmpty() ? null : courses.get(0); // Return the first match or null
    }

    @Override
    public List<Cours> searchCoursByCategory(String categorie) {
        return coursRepository.findByCategorieContainingIgnoreCase(categorie);
    }
}
