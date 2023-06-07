package com.example.demo.usermodules;





import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "UserCollection")

public class UserModel {

	
	


		  @Id
		  private String id;
//		 private long seqId;
			private String username;
			  private String email;
			  private String  password;
			  private boolean isAdmin;
			  
			
//			  @OneToMany(mappedBy = "user")
			  
//			  @OneToMany(fetch = FetchType.EAGER)
//			    @JoinColumn(name = "course_id", referencedColumnName = "id")
			public UserModel(String username, 
					String password,String email,
					boolean isAdmin) {
				 	this.email = email;
				    this.username = username;
				    this.password = password;
				    this.isAdmin= isAdmin;
			}
			
			public UserModel() {
				
			}
			

			public boolean getIsAdmin() {
				return isAdmin;
			}

			public void setIsAdmin(boolean isAdmin) {
				this.isAdmin = isAdmin;
			}

			public String getId() {
				return id;
			}

			public void setId(String id) {
				this.id = id;
			}

			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getEmail() {
				return email;
			}

			public void setEmail(String email) {
				this.email = email;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

		



	}















































