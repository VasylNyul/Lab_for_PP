package lpnu.service;

import lpnu.dto.DrinkDTO;

import java.util.List;

public interface DrinkService {
    List<DrinkDTO> getAllDrinks();

    DrinkDTO create(DrinkDTO drinkDTO);

    DrinkDTO findById(Long id);

    DrinkDTO update(DrinkDTO drinkDTO);

    void delete(Long id);
}