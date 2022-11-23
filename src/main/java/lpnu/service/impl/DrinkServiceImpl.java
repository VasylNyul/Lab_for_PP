package lpnu.service.impl;

import lpnu.dto.DrinkDTO;
import lpnu.entity.Drink;
import lpnu.exception.ServiceException;
import lpnu.mapper.DrinkMapper;
import lpnu.repository.DrinkRepository;
import lpnu.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkServiceImpl implements DrinkService {

    @Autowired
    private DrinkRepository drinkRepository;

    public DrinkServiceImpl(final DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<DrinkDTO> getAllDrinks() {
        return drinkRepository.getAllDrinks().stream()
                .map(DrinkMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DrinkDTO create(final DrinkDTO drinkDTO) {

        final Drink drink = DrinkMapper.toEntity(drinkDTO);
        drinkRepository.saveDrink(drink);

        return DrinkMapper.toDTO(drink);
    }

    @Override
    public void delete(final Long id) {
        drinkRepository.delete(id);
    }

    @Override
    public DrinkDTO update(final DrinkDTO drinkDTO) {
        if (drinkDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }
        final Drink drink = DrinkMapper.toEntity(drinkDTO);

        drinkRepository.update(drink);

        return DrinkMapper.toDTO(drink);
    }

    @Override
    public DrinkDTO findById(final Long id) {

        return DrinkMapper.toDTO(drinkRepository.findById(id));
    }
}