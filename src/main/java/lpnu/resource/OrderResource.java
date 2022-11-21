package lpnu.resource;

import lpnu.dto.AddDrinkToOrderDTO;
import lpnu.dto.AddMealToOrderDTO;
import lpnu.dto.OrderDTO;
import lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public OrderDTO findById(@PathVariable final Long id) {
        return orderService.findById(id);
    }

    @PostMapping
    public OrderDTO createOrder(@RequestBody @Validated final OrderDTO orderDTO) {
        return orderService.create(orderDTO);
    }

    @PostMapping("/add-drink")
    public void addDrinkToOrder(@RequestBody @Validated final AddDrinkToOrderDTO addDTO) {
        orderService.addDrinkToOrder(addDTO);
    }

    @PostMapping("/add-meal")
    public void addMealToOrder(@RequestBody @Validated final AddMealToOrderDTO addDTO) {
        orderService.addMealToOrder(addDTO);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable final Long id) {
        orderService.delete(id);
        return ResponseEntity.ok().build();
    }
}



