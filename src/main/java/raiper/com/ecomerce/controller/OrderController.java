package raiper.com.ecomerce.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import raiper.com.ecomerce.dto.request.OrderRequest;
import raiper.com.ecomerce.model.Order;
import raiper.com.ecomerce.result.Result;
import raiper.com.ecomerce.result.StatusCode;
import raiper.com.ecomerce.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping
    public Result placedOrder(@RequestBody OrderRequest orderRequest) {
            orderService.placeOrder(orderRequest);
        return new Result(true, StatusCode.SUCCESS, "Order placed successfully", orderRequest);
    }
}
