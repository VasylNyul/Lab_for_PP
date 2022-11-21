package lpnu.entity;


import lpnu.entity.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private Long id;
    private LocalDateTime orderDateTime;
    private User user;
    private List<OrderDetails> orderDetails;
    private OrderStatus orderStatus;
}
