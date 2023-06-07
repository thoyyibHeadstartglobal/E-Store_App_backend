package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "submenu")


public class SubMenu {
	

	  @Id
	  private String id;
	  private String mainId;
	  private String optionName;
	  private String optionImage;
		  
		
		  
		public SubMenu(
				String optionName, 
				String optionImage,String mainId) {
			 	this.optionName = optionName;
			    this.optionImage = optionImage;
			    this.mainId = mainId;
		}
		
		public SubMenu() {
			
		}

	  public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public String getOptionImage() {
		return optionImage;
	}

	public void setOptionImage(String optionImage) {
		this.optionImage = optionImage;
	}
	

//	public void getMainId(String mainId) {
//		this.mainId = mainId;
//	}

	public String getMainId() {
		return mainId;
	}

	public void setMainId(String mainId) {
		this.mainId =  mainId;
	}

	public static Object where(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	


}

