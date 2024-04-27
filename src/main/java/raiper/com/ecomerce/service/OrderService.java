package raiper.com.ecomerce.service;

import raiper.com.ecomerce.dto.request.OrderRequest;

public interface OrderService {

    void placeOrder(OrderRequest orderRequest);
}

