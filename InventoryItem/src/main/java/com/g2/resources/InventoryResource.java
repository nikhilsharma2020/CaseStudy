package com.g2.resources;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.g2.bean.Inventories;
import com.g2.bean.InventoryItem;
import com.g2.service.InventoryService;
import com.g2.service.InventoryServiceImpl;

@Path("inventories")
public class InventoryResource {

	private InventoryService inventoryService = new InventoryServiceImpl();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllInventoryResource() {

		Inventories inventories = new Inventories();
		try {
			List<InventoryItem> invenetoryList = inventoryService.getAllInventories();
			inventories.setInventoriesList(invenetoryList);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").entity(inventories).build();
	}

	@Path("/code/{productcode}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductCodeResource(@PathParam("productcode") String productCode) {
		InventoryItem inventoryItem = null;
		try {
			inventoryItem = inventoryService.getProductByCode(productCode);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").entity(inventoryItem).build();
	}

	@Path("/code/{productCode}/{ availableQuantity }")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateInventoryItemQuantityByProductCode(@PathParam("productCode") String productCode,
			@PathParam("availableQuantity") int availableQuantity) {
		String message = null;
		try {
			if (inventoryService.updateInventoryItemQuantityByProductCode(productCode, availableQuantity)) {
				message = "Product Quantity Updated to " + availableQuantity;
			} else {
				message = "Updation Failed";
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return Response.status(200).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.header("Access-Control-Max-Age", "1209600").entity(message).build();

	}

}
