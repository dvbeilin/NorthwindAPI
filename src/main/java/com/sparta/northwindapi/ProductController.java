package com.sparta.northwindapi;

import com.sparta.northwindapi.Entity.Product;
import com.sparta.northwindapi.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepo;


    @GetMapping("/product/all")
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    @PutMapping("/product/{id}")
    public Product getProduct(@PathVariable int id){
        return productRepo.findById(id).get();
    }

    @PutMapping("/product/price/{id}")
    public java.math.BigDecimal getProce(@PathVariable int id){
        Product product = productRepo.findById(id).get();
        return product.getUnitPrice();
    }

    @PostMapping("/product/post")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void newProduct(@RequestBody Product newProduct){
        productRepo.save(newProduct);
        //productRepo.toString();
    }

    @DeleteMapping("/product/remove/{id}")
    public void removeProduct(@PathVariable Integer id){
        productRepo.deleteById(id);
    }

    @PatchMapping("/product/patch")
    public void editProduct(int ProductID, String ProductName, int SupplierID, int CategoryID, String QuantityPerunit, float UnitPrice, int UnitsInStock, int UnitOnOrder, int Reorderlevel, boolean Discontinued)){

        productRepo.save();
    }

    @PutMapping("/Product/put/{id}/productname/{newProductName}")
    public void edditOrAddProduct(@PathVariable int id, @PathVariable String newProductName){
    Product product = productRepo.findById(id).get();
    product.setProductName(newProductName);
    productRepo.save(product);
    }
}
