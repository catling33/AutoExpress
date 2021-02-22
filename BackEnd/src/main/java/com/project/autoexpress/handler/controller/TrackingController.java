package com.project.autoexpress.handler.controller;

import com.project.autoexpress.entity.ShippingOrder;
import com.project.autoexpress.handler.service.OrderService;
import com.project.autoexpress.handler.service.TrackingService;
import com.project.autoexpress.holder.request.OrderRequestBody;
import com.project.autoexpress.holder.response.OrderResponseBody;
import com.project.autoexpress.holder.response.TrackingResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TrackingController {

    @Autowired
    private TrackingService trackingService;

    @RequestMapping(value = "/tracking", method = RequestMethod.GET)
    public ResponseEntity<Object> getShippingOrderById(@RequestParam(value = "orderId") int orderId) {
        ShippingOrder shippingOrder = trackingService.getShippingOrderById(orderId);
        TrackingResponseBody trackingResponse = new TrackingResponseBody();
        trackingResponse.setOrderId(orderId);
        trackingResponse.setSenderAddress(shippingOrder.getSenderAddress());
        trackingResponse.setReceiverAddress(shippingOrder.getReceiverAddress());
        trackingResponse.setReceiverName(shippingOrder.getReceiverName());
        trackingResponse.setCardNumber(shippingOrder.getCardNumber());
        trackingResponse.setSize(shippingOrder.getSize());
        trackingResponse.setWeight(shippingOrder.getWeight());
        trackingResponse.setDescription(shippingOrder.getDescription());
        trackingResponse.setDeliveryMethod(shippingOrder.getDeliveryMethod());
        trackingResponse.setFee(shippingOrder.getFee());
        trackingResponse.setStatus(shippingOrder.getStatus());
        trackingResponse.setTime(shippingOrder.getTime());
        trackingResponse.setStation(shippingOrder.getStation());
        //Do not add Customer to trackingResponse
        return new ResponseEntity<>(trackingResponse, HttpStatus.OK);
    }
}
