package com.example.demo.models;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "mainmenu")


public class MainMenu {
	
	
	
	

	  @Id
	  private String id;
//	 private long seqId;
		private String optionName;
		  private String optionImage;
		  
		
//		  @OneToMany(mappedBy = "user")
		  
//		  @OneToMany(fetch = FetchType.EAGER)
//		    @JoinColumn(name = "course_id", referencedColumnName = "id")
		public MainMenu(String optionName, 
				String optionImage) {
			 	this.optionName = optionName;
			    this.optionImage = optionImage;
		}
		
		public MainMenu() {
			
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
	



}













































