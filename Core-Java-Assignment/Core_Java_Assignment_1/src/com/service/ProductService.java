package com.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bean.Product;

public class ProductService {
	
	private List<Product> productsList = new ArrayList<Product>();


	public String addProduct(Product p) {
		// TODO Auto-generated method stub
		int flag = 0;
		if(productsList.size() == 0)
		{
			productsList.add(p);
			return "Product added successfully";
		}
		else
		{
			Iterator<Product> it = productsList.iterator();
			while(it.hasNext())
			{
				Product pp = it.next();
				if(pp.getPid() == p.getPid())
				{
					flag++;
					break;
				}
			}
			
			if(flag == 0)
			{
				productsList.add(p);
				return "Product added successfully";
			}
			else
			{
				flag = 0;
				return "Product must be unique";
			}
		}

	}

	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productsList;
	}

	public String deleteProduct(int pid) {
		// TODO Auto-generated method stub
		int flag = 0;
		Iterator<Product> it = productsList.iterator();
		while(it.hasNext())
		{
			Product pro = it.next();
			if(pro.getPid() == pid)
			{
				it.remove();
				flag++;
				break;
			}
		}
		if(flag > 0)
		{
			flag = 0;
			return "Product deleted successfully";
		}
		else
			return "Product doesn't exist";
	}

	public String updatetProduct(Product p1) {
		// TODO Auto-generated method stub
		int flag = 0;
		Iterator<Product> it = productsList.iterator();
		while(it.hasNext())
		{
			Product pr = it.next();
			if(pr.getPid() == p1.getPid())
			{
				pr.setPrice(p1.getPrice());
				flag++;
				break;
			}
		}
		if(flag == 0)
			return "Product doesn't exist";
		else
		{
			flag = 0;
			return "Product updated successfully";
		}
	}

	public void serializeProducts() {
		// TODO Auto-generated method stub
		FileOutputStream file = null;
		ObjectOutputStream oos = null;
		
		try {
			
			if(this.productsList.size() > 0)
				
			{	
				file = new FileOutputStream("product.txt");
				oos = new ObjectOutputStream(file);
				oos.writeObject(this.productsList);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(oos != null )
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	
	public ProductService()
	{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try
		{
			fis = new FileInputStream("product.txt");
			if(fis.available() > 0)
			{
				ois = new ObjectInputStream(fis);
				
				this.productsList = (List<Product>) ois.readObject();
			}

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally 
		{
			try {
				
				if(ois != null)
				{
					ois.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
