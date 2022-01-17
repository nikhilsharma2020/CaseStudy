package com.basha.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.basha.bean.Product;
import com.basha.bean.Products1;
import com.basha.service.ProductService;
import com.basha.service.ProductServiceImpl;

@Path("/products")
public class ProductResource {


		private ProductService productService=new ProductServiceImpl();
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getAllProductResource(){
			Products1 products = new Products1();
			try {
				List<Product> productList=productService.listAllProducts();
				products.setProductList(productList);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return Response.status(200).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
					.header("Access-Control-Max-Age", "1209600").entity(products).build();
		}
		
		@Path("/code/{pcode}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public Response getProductCodeResource(@PathParam("pcode") String productCode) {
			Product product=null;
			try {
				product= productService.getProductByCode(productCode);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return Response.status(200).header("Access-Control-Allow-Origin", "*")
					.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
					.header("Access-Control-Allow-Credentials", "true")
					.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
					.header("Access-Control-Max-Age", "1209600").entity(product).build();
		}
		
		@Path("/add")
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String addProduct(Product product)
		{
			try {
				if( productService.saveProduct(product)) {
					return "Product Added";
				}else {
					return "Product Not Added";
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}
			return "Error";
		}
		@Path("/delete/id/{id}")
		@DELETE
		@Produces(MediaType.APPLICATION_JSON)
		public String deleteProduct(@PathParam("id") String productId){
			try {
				if(	productService.deleteProduct(productId)) {
					return "Product Deleted";
				}else {
					return "Product not Deleted";
				}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		return "Error";
		}
}
