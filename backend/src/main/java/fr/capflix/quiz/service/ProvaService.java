package fr.capflix.quiz.service;

import fr.capflix.quiz.dto.ProvaDTO;
import fr.capflix.quiz.model.Pergunta;
import fr.capflix.quiz.model.Prova;
import fr.capflix.quiz.repository.ProvaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvaService {

    ModelMapper mapper = new ModelMapper();
    @Autowired
    private ProvaRepository provaRepository;

    public List<ProvaDTO> getProvasByAssunto(String assunto) {

        return provaRepository.findByAssunto(assunto.toLowerCase());
    }

    public Prova save(ProvaDTO prova) {


        prova.getAssunto().toLowerCase();
        Prova teste = mapper.map(prova, Prova.class);

        return provaRepository.save(teste);
    }

    public void delete(Long id) {

        if (findProvaById(id).isPresent()) {
            provaRepository.deleteById(id);
        }

    }

    private Optional<Prova> findProvaById(Long id) {
        //  return provaRepository.findById(id).map(ProvaDTO::new);

        return provaRepository.findById(id);
    }


    public List<Prova> findAll() {


        return provaRepository.findAll();

		/* Fazendo manualmente:

		List<ProvaDTO> list = new ArrayList<>();
		for (Prova p : provas){
			list.add(new ProvaDTO(p));
		}
		*/

    }

    public Prova insert(ProvaDTO prova) {
        Assert.isNull(prova.getProvaId(), "Não foi possível inserir o registro");
        Prova teste = mapper.map(prova, Prova.class);
        return provaRepository.save(teste);
    }


/*    public List<Pergunta> findPerguntas(ProvaDTO prova) {

        return provaRepository.findAll(prova.setPerguntas(prova.getPerguntas())

    }*/
}
