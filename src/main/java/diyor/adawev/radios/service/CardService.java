package diyor.adawev.radios.service;

import diyor.adawev.radios.dto.AboutUsDto;
import diyor.adawev.radios.dto.CardDto;
import diyor.adawev.radios.model.AboutUs;
import diyor.adawev.radios.model.Card;
import diyor.adawev.radios.model.Photo;
import diyor.adawev.radios.model.Result;
import diyor.adawev.radios.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {
    @Autowired
    CardRepo cardRepo;

    public List<Card> getAll() {
        return cardRepo.findAll();
    }
    public Card getById(Integer id) {
        return cardRepo.findById(id).get();
    }

    public Result create(CardDto cardDto) {
        Card card = new Card();
        card.setName(cardDto.getName());
        card.setCvvNumber(cardDto.getCvvNumber());
        cardRepo.save(card);
        return new Result(true, "Card created");
    }
    public Result update(Integer id, CardDto cardDto) {
        Optional<Card> byId = cardRepo.findById(id);
        if (byId.isPresent()) {
            Card card = byId.get();
            card.setName(cardDto.getName());
            card.setCvvNumber(cardDto.getCvvNumber());
            cardRepo.save(card);
            return new Result(true, "Card updated");
        }
        return new Result(true, "Card not found");
    }
    public Result delete(Integer id) {
        Optional<Card> byId = cardRepo.findById(id);
        if (byId.isPresent()) {
            cardRepo.delete(byId.get());
            return new Result(true, "Card deleted");
        }
        return new Result(true, "Card not found");
    }
}
