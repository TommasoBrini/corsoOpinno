package PrenotazioneUfficio.service;

import PrenotazioneUfficio.model.Città;
import PrenotazioneUfficio.repository.CittàRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CittàService {
    @Autowired
    CittàRepository repo;

    public CittàService(CittàRepository repo) {
        this.repo = repo;
    }

    public Città save(Città c){
        return repo.save(c);
    }
}
