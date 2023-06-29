package PrenotazioneUfficio.service;

import PrenotazioneUfficio.model.Postazione;
import PrenotazioneUfficio.repository.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {
    @Autowired
    PostazioneRepository repo;

    public PostazioneService(PostazioneRepository repo) {
        this.repo = repo;
    }

    public void savePostazione(Postazione p){
        repo.save(p);
    }

    public Postazione updatePostazione(Postazione p){
        return repo.save(p);
    }

    public void deletePostazione(Postazione p){
        repo.delete(p);
    }

    public Optional<Postazione> getPostazioneById(int id){
        return repo.findById(id);
    }

    public List<Postazione> getAllPostazione(){
        return repo.findAll();
    }

}
