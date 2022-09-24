package com.order.api.mapper;

import com.order.api.dto.*;
import com.order.api.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class OrderMapper {

    @Autowired
    private ModelMapper mapper;

    public PaymentRequestDto convertToCreditCardValidator(Order order) {

        return PaymentRequestDto.builder()
                .cardNumber(order.getPayment().getCardNumber())
                .cardName(order.getPayment().getCardName())
                .cvv(order.getPayment().getCvv())
                .documentNumber(order.getOrderUser().getDocumentNumber())
                .name(order.getOrderUser().getName())
                .productPrice(getProductPrice(order.getProducts()))
                .build();

    }

    private Double getProductPrice(List<OrderProduct> products) {
        //dont know if this is working
        AtomicReference<Double> price = null;
        products.forEach(p  -> price.updateAndGet(v -> v + p.getProductPrice()));
        return price.get();
    }

    public Order fromOrderDtoToOrder(OrderRequestDto order) {

        return Order.builder()
                .orderUser(getOrderUser(order.getUser()))
                .products(generateProductList(order.getProducts()))
                .payment(getPayment(order.getPayment()))
                .orderStatus(order.getOrderStatus()).build();
    }

    private Payment getPayment(PaymentDto payment) {
        return mapper.map(payment, Payment.class);
    }

    private List<OrderProduct> generateProductList(List<OrderProductDto> products) {

        List<OrderProduct> productList = new ArrayList<>();

        products.forEach(product -> {
            OrderProduct orderProduct = new OrderProduct();
            orderProduct.setProductName(product.getProductName());
            orderProduct.setProductPrice(product.getProductPrice());
            productList.add(orderProduct);
        });
        return productList;
    }

    private OrderUser getOrderUser(UserDto userDto) {
        OrderUser user = new OrderUser();
        user.setName(userDto.getName());
        user.setDocumentNumber(userDto.getDocumentNumber());
        user.setEmail(userDto.getEmail());
        user.setAddress(getUserAddress(userDto.getAddress()));
        return user;
    }

    private Address getUserAddress(AddressDto addressDto) {
        return mapper.map(addressDto, Address.class);
    }

    public DeliveryInformationDto convertToDeliveryInformationDto(Order newOrder) {
        // implement conversor
        return DeliveryInformationDto.builder().build();

    }
}
