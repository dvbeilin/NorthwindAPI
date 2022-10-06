package com.sparta.northwindapi.dao;

import com.sparta.northwindapi.Entity.Product;
import com.sparta.northwindapi.dto.ProductDTO;
import com.sparta.northwindapi.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductDAO {

    @Autowired
    private ProductRepository productRepo;

    public ProductDAO(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    public ProductDTO update(ProductDTO productDTO){
        Optional<Product> optional = productRepo.findById(productDTO.getId());
        Product product = null;
        if(optional.isPresent())
            product = optional.get();
        else
            return new ProductDTO(-1, null, null, null, null, null, null, null);
        if(productDTO.getProductName()!= null)
            product.setProductName(productDTO.getProductName());
//        if(productDTO.getLastName()!= null)
//            actor.setLastName(actorDTO.getLastName());
        productRepo.save(product);
        product = productRepo.findById(productDTO.getId()).get();
        return new ProductDTO(product.getId(), product.getProductName(), product.getQuantityPerUnit(), product.getUnitPrice(), product.getUnitsInStock(), product.getUnitsOnOrder(), product.getReorderLevel(), product.getDiscontinued());
    }

    public void delete(int id){
        productRepo.deleteById(id);
    }

    public ProductDTO get (ProductDTO productDTO){
        Optional<Product> optional = productRepo.findById(productDTO.getId());
        Product product = null;
        if(optional.isPresent())
            product = optional.get();
        else
            return new ProductDTO(-1, null, null, null, null, null, null, null);
        return new ProductDTO(product.getId(), product.getProductName(), product.getQuantityPerUnit(), product.getUnitPrice(), product.getUnitsInStock(), product.getUnitsOnOrder(), product.getReorderLevel(), product.getDiscontinued());
    }
}
