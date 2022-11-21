package lpnu.mapper;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import lpnu.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderDetailsMapper orderDetailsMapper;

    public Order toEntity(final OrderDTO orderDTO) {
        final Order order = new Order();

        order.setId(orderDTO.getId());
        order.setUser(userRepository.findById(orderDTO.getUserId()));
        if (orderDTO.getOrderDetails() != null) {
            order.setOrderDetails(orderDTO.getOrderDetails().stream().map(orderDetailsMapper::toEntity).collect(Collectors.toList()));
        }
        order.setOrderDateTime(orderDTO.getOrderDateTime());
        order.setOrderStatus(orderDTO.getOrderStatus());

        return order;
    }

    public OrderDTO toDTO(final Order order) {
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setUserId(order.getUser().getId());
        orderDTO.setOrderDateTime(order.getOrderDateTime());
        if (order.getOrderDetails() != null) {
            orderDTO.setOrderDetails(order.getOrderDetails().stream().map(orderDetailsMapper::toDTO).collect(Collectors.toList()));
        }
        orderDTO.setOrderStatus(order.getOrderStatus());

        return orderDTO;
    }
}
