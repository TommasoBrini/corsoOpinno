package PrenotazioneUfficio.service;

import PrenotazioneUfficio.model.Città;
import PrenotazioneUfficio.repository.CittàRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CittàService {
    @Autowired
    CittàRepository repo;

    public CittàService(CittàRepository repo) {
        this.repo = repo;
    }

    public void saveCity(Città c){
        repo.save(c);
    }

    public Città updateCity(Città c){
        return repo.save(c);
    }

    public void deleteCity(Città c){
        repo.delete(c);
    }

    public Optional<Città> getCityById(int id){
        return repo.findById(id);
    }

    public List<Città> getAllCity(){
        return repo.findAll();
    }

}
