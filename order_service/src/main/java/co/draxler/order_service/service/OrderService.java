package co.draxler.order_service.service;

import co.draxler.order_service.dto.OrderRequest;

public interface OrderService {
    String placeOrder(OrderRequest orderRequest);
}
