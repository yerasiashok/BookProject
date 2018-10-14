package com.ProjectBook;

public class Get implements Book{
	String id;
	String name;
	String author;
	String price;


	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public String getAuthor()
	{
		return author;
	}
	public String getPrice()
	{
		return price;
	}
	 public void setId(String id) {
		 this.id=id;
	 }
	 public void setName(String name) {
		 this.name=name;
	 }
	 public void setAuthor(String author) {
		 this.author=author;
	 }
	 public void setPrice(String price) {
		 this.price=price;
	 }
	@Override
	public void connectTo(String serverhost) throws Exception {
		
		System.out.println("Connecting to "+ serverhost);
	}
}
