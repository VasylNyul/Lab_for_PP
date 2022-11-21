package lpnu.service;


import lpnu.dto.AddDrinkToOrderDTO;
import lpnu.dto.AddMealToOrderDTO;
import lpnu.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getAllOrders();
    OrderDTO create(OrderDTO orderDTO);
    OrderDTO findById(Long id);
//    OrderDTO update(OrderDTO orderDTO);

    void delete(Long id);
    void cancelOrder(Long orderId);
    void closeOrder(Long orderId);
    void pendingOrder(Long orderId);

    void addDrinkToOrder(AddDrinkToOrderDTO addDTO);
    void addMealToOrder(AddMealToOrderDTO addDTO);

}
