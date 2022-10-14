package com.sparta.northwindapi.web.controllers;

import com.sparta.northwindapi.dao.OrderDAO;
import com.sparta.northwindapi.dto.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("orderList")
public class OrderWebController {

    @Autowired
    private OrderDAO orderDAO;

    @GetMapping("/northwind/order")
    public String findOrder(@RequestParam int id, Model model) {
        OrderDTO orderDTO = orderDAO.get(id);
        model.addAttribute("order", orderDTO);
        return "displayOrder";
    }

    @GetMapping("northwind/order/all")
    public String getAllOrders(Model model) {
        List<OrderDTO> orders = orderDAO.getAll();
        model.addAttribute("orders", orders);
        return "allOrders";
    }

    @GetMapping("northwind/order/create-form")
    public String orderForm(Model model) {
        OrderDTO order = new OrderDTO();

        model.addAttribute("order",order);
        return "orderForm";
    }

    @PostMapping("northwind/order/create-form/create")
    public String createOrder(@ModelAttribute OrderDTO order, Model model) {
        order.setOrderDate(Instant.now());
        order.setRequiredDate(Instant.now().plus(2, ChronoUnit.DAYS));
        order.setFreight(new BigDecimal("10.00"));
        orderDAO.create(order);
        model.addAttribute("order",order);
        return "displayOrder";
    }

    @PostMapping("northwind/oder/update-form/update/")
    public String updateOrder(@ModelAttribute OrderDTO order,Model model) {
        OrderDTO orderToUpdate = orderDAO.get(order.getId());
        if(orderToUpdate != null) {
        if(order.getFreight() != null )    orderToUpdate.setFreight(order.getFreight());
        if(order.getShipAddress() != null )    orderToUpdate.setShipAddress(order.getShipAddress());
        if(order.getShipCountry() != null )    orderToUpdate.setShipCountry(order.getShipCountry());
        if(order.getShipName() != null )    orderToUpdate.setShipName(order.getShipName());
        if(order.getShipCity() != null )    orderToUpdate.setShipCity(order.getShipCity());
        if(order.getShipRegion() != null )    orderToUpdate.setShipRegion(order.getShipRegion());
        if(order.getShipPostalCode() != null )    orderToUpdate.setShipPostalCode(order.getShipPostalCode());
        if(order.getShipCountry() != null )    orderToUpdate.setShipCountry(order.getShipCountry());
        orderDAO.update(orderToUpdate);
        model.addAttribute("order",orderToUpdate);
        return "displayOrder";
        }
        else return "allOrders";
    }

    @GetMapping("northwind/order/update/{id}")
    public String updateForm(Model model,@PathVariable int id) {
        OrderDTO order = orderDAO.get(id);
        model.addAttribute("order",order);
        return "updateOrderForm";
    }

    @GetMapping("/orderList/add/{id}")
    public String addOrder(@PathVariable int id, @ModelAttribute("orderList") List<OrderDTO> orderList) {
        OrderDTO orderToAdd = orderDAO.get(id);
        if(orderToAdd != null) {
            orderList.add(orderToAdd);
            return "orderList";
        }
        else return "allOrders";
    }

    @ModelAttribute("orderList")
    public List<OrderDTO> orderList() {
        return new ArrayList<>();
    }
}
