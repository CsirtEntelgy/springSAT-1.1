package com.example.demo.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name= "servicio-productos" , "localhost:8001")
public interface IProductoClienteRest {

}
