package lpnu.service.impl;

import lpnu.dto.MealDTO;
import lpnu.entity.Meal;
import lpnu.exception.ServiceException;
import lpnu.mapper.MealMapper;
import lpnu.repository.MealRepository;
import lpnu.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class MealServiceImpl implements MealService {

    @Autowired
    private MealRepository mealRepository;

    @Override
    public List<MealDTO> getAllMeals() {
        return mealRepository.getAllMeals().stream()
                .map(MealMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MealDTO create(final MealDTO mealDTO) {

        final Meal meal = MealMapper.toEntity(mealDTO);
        mealRepository.saveMeal(meal);

        return MealMapper.toDTO(meal);
    }

    @Override
    public void delete(final Long id) {
        mealRepository.delete(id);
    }

    @Override
    public MealDTO update(final MealDTO mealDTO) {
        if (mealDTO.getId() == null) {
            throw new ServiceException(400, "id is null");
        }
        final Meal meal = MealMapper.toEntity(mealDTO);

        mealRepository.update(meal);

        return MealMapper.toDTO(meal);
    }

    @Override
    public MealDTO findById(final Long id) {

        return MealMapper.toDTO(mealRepository.findById(id));
    }
}