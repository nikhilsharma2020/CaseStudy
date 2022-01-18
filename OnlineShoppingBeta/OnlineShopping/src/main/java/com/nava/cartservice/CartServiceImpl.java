package com.nava.cartservice;

import java.util.ArrayList;
import java.util.List;

import com.nava.bean.Itoms;
import com.nava.bean.ItomsList;
import com.nava.cartpersistance.CartDaoImpl;

public class CartServiceImpl implements CartService {

	CartDaoImpl cartDaoImpl = new CartDaoImpl();
	
	@Override
	public String createNewCart(String userName) {
		return cartDaoImpl.createNewCart(userName);
	}
	@Override
	public String addItomInCart(Itoms itom) {                                         
		String addedItom=itom.getItoms();
		String oldItoms =cartDaoImpl.getItomsFromCart(itom.getUserName());
		if(oldItoms!=null) { 
			if(cartDaoImpl.updateItomInCart(itom.getUserName(),(oldItoms+","+itom.getItoms()))) 
				return addedItom+" added to cart";
			else 
				return "can'n add";
			}
		else {
			if(cartDaoImpl.updateItomInCart(itom.getUserName(),itom.getItoms())) 
				return addedItom+" added to cart";
			else 
				return "can'n add";	
		}
	}
	@Override
	public String addItomsInCart(Itoms itom) {
		String s="";
		for(int i=0;i<itom.getQuantity();i++)
			s=addItomInCart(itom);
		return s;
	}
	@Override
	public ItomsList getItomsFromCart(String userName) {                           // get items completed without quantity
		ItomsList list = new ItomsList();
		List<Itoms> itomList = new ArrayList<Itoms>();
		String itoms =cartDaoImpl.getItomsFromCart(userName);									//----------------
		if(itoms==null) {
			Itoms itom = new Itoms();
//			itom.setUserName(userName);
			itom.setQuantity(0);
			itom.setItoms("empty");
			itomList.add(itom);
			list.setItoms(itomList);
			return list;
		}
		list.setItoms(stringToListWithQuantity(userName,itoms));
		return list;
			
	}
	@Override
	public String deleteItomFromCart(Itoms itom) {
		boolean b=false;
		String deletedItom="";
		String oldItoms =cartDaoImpl.getItomsFromCart(itom.getUserName());
		if(oldItoms==null) 
			return "cart empty";
		List<Itoms> list =stringToListWithoutQuantity(itom.getUserName(), oldItoms);
		for(Itoms str : list) {                             ////
			if(str.getItoms().equals(itom.getItoms())) {
				deletedItom=str.getItoms();
				list.remove(str);
				b=true;
				break;
			}
		}
		String newString=listToString(list);
		if(cartDaoImpl.updateItomInCart(itom.getUserName(), newString) && b)
			return deletedItom+" deleted from cart";
		else
			return "can't delete";
	}
	@Override
	public String deleteItomsFromCart(Itoms itom) {
		String s="";
		int i=0;
		for( ;i<itom.getQuantity();i++) {
			s=deleteItomFromCart(itom);
			if(i==(itom.getQuantity()-1) && (!s.equals("can't delete")))
				return (i+1)+" "+itom.getItoms()+" is deleted";
		}
		System.out.println((!s.equals("can't delete")));
		if(s.equals("can't delete") && i!=(itom.getQuantity())) 
			return i+" itoms delete";
		else
			return "can't delete";
	}
	@Override
	public String deleteAllItomsFromCart(String userName) {
		String oldItoms=cartDaoImpl.getItomsFromCart(userName);
		if(oldItoms!=null && cartDaoImpl.updateItomInCart(userName,""))
			return "deleted all";
		else
		return "no itoms to delete";
	}	    		
	public String listToString(List <Itoms> list) {
		String itoms="";
		for(Itoms s: list)
			if(itoms!="") 
				itoms=itoms+","+(s.getItoms());
			else 
				itoms=s.getItoms();
		return itoms;
	}
	public List<Itoms> stringToListWithQuantity(String userName, String itoms) {
		String[] myArray = itoms.split(",");
		for (int i = 0; i < myArray.length - 1; i++) {
			for (int j = i + 1; j < myArray.length; j++) {
				if (myArray[i].compareTo(myArray[j]) > 0) {
					String temp = myArray[i];
					myArray[i] = myArray[j];
					myArray[j] = temp;
				}
			}
		} 
		return stringToListForQuantity(userName, myArray);
	}
	public List<Itoms> stringToListForQuantity(String userName, String[] myArray) {
		List<Itoms> itomsList = new ArrayList<Itoms>();
		int quant = 0;
		for (int i = 0; i < myArray.length; i++) {
			Itoms itom = new Itoms();
			//itom.setUserName(userName);
			if (myArray.length == 1) {
				itom.setItoms(myArray[i]);
				itom.setQuantity(1);
				itomsList.add(itom);
				break;
			}
			if(myArray.length==2 ) {
				if(myArray[0].equals(myArray[1])) {
					itom.setQuantity(2);
					itom.setItoms(myArray[0]);
					itomsList.add(itom);
					break;
				}
				else {
					itom.setQuantity(1);
					itom.setItoms(myArray[0]);
					itomsList.add(itom);
					itom.setItoms(myArray[1]);
					itomsList.add(itom);
					break;
				}
				
			}
			if (myArray.length >2 && i == (myArray.length-2)) {
				if( myArray[(myArray.length-2)].equals(myArray[(myArray.length-1)])){
					itom.setItoms(myArray[myArray.length-1]);
					itom.setQuantity(quant+2);
					itomsList.add(itom);
					break;
				}
				else {
					Itoms itom1 = new Itoms();
					itom1.setQuantity(++quant);
					itom1.setItoms(myArray[(myArray.length-2)]);
					itomsList.add(itom1);
					Itoms itom2 = new Itoms();
					itom2.setItoms(myArray[(myArray.length-1)]);
					itom2.setQuantity(1);
					itomsList.add(itom2);
					break;
				}
			}
			if (myArray[i+1].equals(myArray[i]))
				itom.setQuantity(++quant);
			else {
				itom.setQuantity(++quant);
				itom.setItoms(myArray[i]);
				itomsList.add(itom);
				quant=0;
			}
		}
		return itomsList;
	}
	public List<Itoms> stringToListWithoutQuantity(String userName, String itoms){
		List<Itoms> itomsList = new ArrayList<Itoms>();
		String[] myArray = {""};
		if(itoms!="") 
			myArray = itoms.split(",");
	     for (int i = 0; i < myArray.length; i++) {
	 		Itoms itom = new Itoms();
			itom.setUserName(userName);
			itom.setItoms(myArray[i]);
			itomsList.add(itom);
		}
	    return itomsList;
		}
}
