package com.example.demo.models;

public class Items {
	private Producto productosX;
	private Integer cantidad;
	
	
	public Items() {
	}
	
	public Items(Producto productosX, Integer cantidad) {
		this.productosX = productosX;
		this.cantidad = cantidad;
	}
	
	
	public Producto getProductosX() {
		return productosX;
	}
	public void setProductosX(Producto productosX) {
		this.productosX = productosX;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	public Double getTotal() {
		return productosX.getPrecio() * cantidad.doubleValue() ;
	}
	
	

}
