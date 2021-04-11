import java.io.FileWriter;
import java.io.IOException;

public class CarsList {

	private class ListNode{
		private String name;
		private String tel;
		private String email;
		private String modelCar;
		private String price;
		private String income;
		private String expense;
		private ListNode next;
		
		private ListNode(String name, String tel, String email, String modelCar, String price) {
			this.name = name;
			this.tel = tel;
			this.email = email;
			this.modelCar = modelCar;
			this.price = price;
		}
		
		

		public String getIncome() {
			return income;
		}



		public void setIncome(String income) {
			this.income = income;
		}



		public String getExpense() {
			return expense;
		}



		public void setExpense(String expense) {
			this.expense = expense;
		}



		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getModelCar() {
			return modelCar;
		}

		public void setModelCar(String modelCar) {
			this.modelCar = modelCar;
		}

		public String getPrice() {
			return price;
		}

		public void setPrice(String price) {
			this.price = price;
		}
		
		public String toString() {
			return getName();
		}

		public ListNode getNext() {
			return next;
		}

		public void setNext(ListNode link) {
			next = link;
		}
		
	}	
	
	
	
	public boolean isEmpty() {
		boolean isEmpty = false;
		
		if(this.front == null) {
			isEmpty = true;
		}
		
		return isEmpty;
	}
	
	
	public void addToFront(String name, String tel, String email, String modelCar, String price) {
		
		ListNode link = new ListNode(name, tel, email, modelCar, price);
		
		if(!isEmpty()) {
			link.setNext(this.front);
		}
		else 
		link.setNext(null);
		this.front = link;
		
	
		}
	
	public void addToBack(String name, String tel, String email, String modelCar, String price) {
	  ListNode link = new ListNode(name, tel, email, modelCar, price);
	  
	  if(!isEmpty()) {
		  ListNode Current = this.front;
		  
		  if(Current.getNext() == null) {
			  
			  link.setNext(null);
			  Current.setNext(link);
		  }
		  else {
			  recToBack(Current, link);
		  }
		  
	  }
	  else {
		  this.front = link;
		  this.front.setNext(null);
	  }
	}
		
	
	private void recToBack(ListNode Current, ListNode link) {
		if(Current.getNext() == null) {
			link.setNext(null);
			Current.setNext(link);
		}
		else {
			Current = Current.getNext();
			recToBack(Current, link);
			
		}
	}
	
	public String toString() {
		String result = "";
		if(!isEmpty()) {
			ListNode Current = this.front;
			result += Current.getName() + " " + Current.getTel() + " " + " " + Current.getModelCar() +
					" " + Current.getEmail() + " " + Current.getPrice() + "\n";
			
			if(Current.getNext() != null) {
				Current = Current.getNext();
				result += recToString(Current, result);
				
			}
			
		}
	
	
	return result;
}
	
	private String recToString(ListNode Current, String result){
		result = Current.getName() + " " + Current.getTel() + " " + " " + Current.getModelCar() + 
				" " + Current.getEmail() + " " + Current.getPrice() + "\n";
		
		int num = 0;
		if(Current.getNext() != null) {
			Current = Current.getNext();
		num++;
		result += recToString(Current, result);
		}
		
		return result;
	}
	
	public String reverseToString() {
		String result = "";
		ListNode current = this.front;
		
		if(!isEmpty()) {
			if (current.getNext() != null) {
				result = revRecString(current);
			}
			
			result += current.getName() + " " + current.getTel() + " " + " " + current.getModelCar() + 
					" " + current.getEmail() + " " + current.getPrice() + "\n";
		}
		return result;
	}
	
	private String revRecString(ListNode current) {
		String result = "";
		
		current = current.getNext();
		
		if(current.getNext() != null) {
			result = revRecString(current);
		}
		
		result += current.getName() + " " + current.getTel() + " " + " " + current.getModelCar() +
				" " + current.getEmail() + " " + current.getPrice() + "\n";
		return result;
 	}
	
	public CarsList reverse() {
		CarsList newList = new CarsList();
		
		if(!isEmpty()) {
			ListNode current = this.front;
			newList.addToFront(current.getName(), current.getTel(), current.getEmail(),
					current.getModelCar(), current.getPrice());
			newList = revList(current, newList);
		}
		
		return newList;
	}
	
	private CarsList revList(ListNode current, CarsList newList) {
		current = current.getNext();
		
		newList.addToFront(current.getName(), current.getTel(), current.getEmail(),
			current.getModelCar(), current.getPrice());
		
		if(current.getNext() != null) {
			newList = revList(current, newList);
		}
		
		return newList;
	}
	
	public int sizeOf() {
		int size = 0;
		
		ListNode current = this.front;
		
		if(!isEmpty()) {
			size = recCount(current);
			size++;
		}
		
		return size;
	}
	
	private int recCount(ListNode current) {
		int size = 0;
		current = current.getNext();
		
		if(current.getNext() != null) {
			size = recCount(current);
		}
		
		size++;
	
		return size;
	}
	
	
	public String phoneNumberByName(String name) {
		String phone = "";
		
		ListNode current = this.front;
		
		if(!isEmpty()) {
			if(current.getName().equalsIgnoreCase(name)) {
				phone = current.getTel();
			}
			else if(current.getNext() != null) {
				current = current.getNext();
				phone = recTel(current, name);
			}
			
		}
			else 
				phone = "No matching data";
				
			return phone;
			}
			
			private String recTel(ListNode current, String name) {
				String phone = "";
				
				if(current.getName().equalsIgnoreCase(name)) {
					phone = current.getTel();
					
				}
				else if(current.getNext() != null) {
					current = current.getNext();
					phone = recTel(current, name);
				}
				else {
					phone = "No matching data";
				}
				
				return phone;
			}
			
			public String emailByName(String name) {
				String email = "";
				
				ListNode current = this.front;
				
				if(!isEmpty()) {
					
					if(current.getName().equalsIgnoreCase(name)) {
						email = current.getEmail();
						
					}
					else if(current.getNext() != null) {
						current = current.getNext();
						email = recEmail(current, name);
					}
					else {
						email = "No matching data";
					}
				}
				else 
					email = " No matching data";
				
				return email;
				}
			
			private String recEmail(ListNode current, String name) {
				String email = "";
				
				if(current.getName().equalsIgnoreCase(name)) {
					email = current.getEmail();
					
				}
				else {
					email = "No matching data;";
				}
				return email;
			}
			
		public String priceByName(String name) {
			String price ="";
			
			ListNode current = this.front;
			
			if(!isEmpty()) {
				
				if(current.getName().equalsIgnoreCase(name)) {
					price = current.getPrice();
				}
				else {
					price = "No matching data";
				}
			}
			else 
				price = "No matching data";
			
			return price;
		}
		 
	private String recPrice(ListNode current, String name) {
		String price = "";
		
		if(current.getName().equalsIgnoreCase(name)) {
			price = current.getPrice();
		}
		else if(current.getNext() != null) {
			current = current.getNext();
			price = recPrice(current, name);
		}
		else {
			price = "No matching data";
		}
		
		
		return price;
	}
	
	public String nameByPhoneNumber (String tel) {
		String name = " ";
		
		ListNode current = this.front;
		
		if(!isEmpty()) {
			if(current.getTel().compareTo(tel) == 0) {
				name = current.getName();
			}
			else if(current.getNext() != null) {
				current = current.getNext();
				name = recName(current, tel);
			}
			else {
				name = "No matching data";
			}
		}
		else
			name = "No matching data";
		
		return name;
		}
	
	
	private String recName(ListNode current, String tel) {
		String name = "";
		
		if(current.getTel().compareTo(tel) == 0) {
			name = current.getName();
		}
		
		else if(current.getNext() != null) {
			current = current.getNext();
			name = recName(current, tel);
		}
		
		else {
			name = "No matching data";
		}
		
		return name;
	}
	
	
	
	
	private ListNode front;
	
	public CarsList() {
		this.front = null;
	}


	
	}


	


	




	
		

