package com.nava.cartservice;

import java.util.List;

import com.nava.bean.Itoms;
import com.nava.bean.ItomsList;
public interface CartService {
	public String createNewCart(String userName);
	public String addItomInCart(Itoms itom);
	public String addItomsInCart(Itoms itom);
	public ItomsList getItomsFromCart(String userName);
	public String deleteItomFromCart(Itoms itom);
	public String deleteItomsFromCart(Itoms itom);
	public String deleteAllItomsFromCart(String userName);

}
