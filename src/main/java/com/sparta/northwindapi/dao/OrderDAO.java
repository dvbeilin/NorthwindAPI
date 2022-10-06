package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.dto.OrderDTO;
import com.sparta.northwindapi.entity.Order;
import com.sparta.northwindapi.repo.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class OrderDAO {

    private OrderRepository orderRepo;

    public OrderDAO(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderDTO get(int id) {
        Optional<Order> orderOpt = orderRepo.findById(id);

        if(orderOpt.isPresent()) {
            Order theOrder = orderOpt.get();
            return new OrderDTO(
                    theOrder.getId(),
                    theOrder.getOrderDate(),
                    theOrder.getRequiredDate(),
                    theOrder.getShippedDate(),
                    theOrder.getFreight(),
                    theOrder.getShipName(),
                    theOrder.getShipAddress(),
                    theOrder.getShipCity(),
                    theOrder.getShipRegion(),
                    theOrder.getShipPostalCode(),
                    theOrder.getShipCountry()
                    );
        } else return null;
    }

    public List<OrderDTO> getAll() {
       List<Order> orders = orderRepo.findAll();
       if(orders.isEmpty()) {
           return null;
       }
       List<OrderDTO> orderDTO = new ArrayList<>();
       orders.forEach(theOrder -> orderDTO.add(new OrderDTO(theOrder.getId(),
               theOrder.getOrderDate(),
               theOrder.getRequiredDate(),
               theOrder.getShippedDate(),
               theOrder.getFreight(),
               theOrder.getShipName(),
               theOrder.getShipAddress(),
               theOrder.getShipCity(),
               theOrder.getShipRegion(),
               theOrder.getShipPostalCode(),
               theOrder.getShipCountry())));
       return orderDTO;
    }

    public Integer create(OrderDTO orderDTO) {
        Order theOrder = new Order(orderDTO);
        orderRepo.save(theOrder);
        return theOrder.getId();
    }

    public OrderDTO update(OrderDTO orderDTO) {
        Optional<Order> orderOpt = orderRepo.findById(orderDTO.getId());
        Order theOrder = null;
        if(orderOpt.isPresent()) {
            theOrder = orderOpt.get();
        } else {
            return null;
        }
        if(orderDTO.getOrderDate() != null) theOrder.setOrderDate(orderDTO.getOrderDate());
        if(orderDTO.getFreight() != null) theOrder.setFreight(orderDTO.getFreight());
        if(orderDTO.getRequiredDate() != null) theOrder.setRequiredDate(orderDTO.getRequiredDate());
        if(orderDTO.getShipAddress() != null) theOrder.setShipAddress(orderDTO.getShipAddress());
        if(orderDTO.getShipCity() != null) theOrder.setShipCity(orderDTO.getShipCity());
        if(orderDTO.getShipCountry() != null) theOrder.setShipCountry(orderDTO.getShipCountry());
        if(orderDTO.getShipName() != null) theOrder.setShipName(orderDTO.getShipName());
        if(orderDTO.getShippedDate() != null) theOrder.setShippedDate(orderDTO.getShippedDate());
        if(orderDTO.getShipRegion() != null) theOrder.setShipRegion(orderDTO.getShipRegion());
        if(orderDTO.getShipPostalCode() != null) theOrder.setShipPostalCode(orderDTO.getShipPostalCode());
        orderRepo.save(theOrder);
        theOrder = orderRepo.findById(orderDTO.getId()).get();
        return new OrderDTO(
                theOrder.getId(),
                theOrder.getOrderDate(),
                theOrder.getRequiredDate(),
                theOrder.getShippedDate(),
                theOrder.getFreight(),
                theOrder.getShipName(),
                theOrder.getShipAddress(),
                theOrder.getShipCity(),
                theOrder.getShipRegion(),
                theOrder.getShipPostalCode(),
                theOrder.getShipCountry());
    }

    public boolean deleteById(int id) {
        Optional<Order> orderOpt = orderRepo.findById(id);
        if(orderOpt.isPresent() ) {
            orderRepo.deleteById(id);
            return true;
        } else return false;
    }

    public List<OrderDTO> findByName(String name) {
        List<Order> orders = orderRepo.findByShipName(name);
        List<OrderDTO> ordersDTO = new ArrayList<>();
        orders.forEach(order -> ordersDTO.add(new OrderDTO(order)));
        return ordersDTO;
    }
}
