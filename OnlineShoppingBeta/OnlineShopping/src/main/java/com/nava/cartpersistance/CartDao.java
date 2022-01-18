package com.nava.cartpersistance;

public interface CartDao {
	public String createNewCart(String userName);
	public Boolean updateItomInCart(String userName, String itoms);
	public String getItomsFromCart(String userName);
}
