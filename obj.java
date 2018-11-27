package Employee;
import java.io.*;
import java.util.Scanner;
import java.io.Serializable;
import java.util.ArrayList;	
import java.util.HashMap; 
import java.util.Map; 

public class obj implements Serializable{
	String name,filename;
	int age,number,count;
	long mobile;
	boolean exists = false;
	ArrayList<obj> o = new ArrayList<obj>();
	HashMap<Integer, String> map = new HashMap<Integer, String>(); 	// Used to store records 
		

	public void update(){		

		for(int  i = 0; i < o.size(); i++ ){
			if( this.number == o.get(i).number ){
				System.out.println("Found!");
						o.get(i).name = this.name; 
						o.get(i).age = this.age; 
						o.get(i).mobile = this.mobile; 
				}
		}
		objwrite();
	}

	public void objwrite(){

		try {
			ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(this.filename));
			oos.writeObject(o);
			oos.close();
		}
		catch(Exception e){

			e.printStackTrace();
		}

	}

	public void objread(){

		try { 
			FileInputStream is = new FileInputStream(this.filename);
			ObjectInputStream ois = new ObjectInputStream(is);
		   	o = (ArrayList<obj>) ois.readObject();
		   	ois.close();
			is.close();
		}
		catch(Exception e){}

	}

	public void helper(){		
			objread();
	   		o.add(this);		
			objwrite();
	}

	public obj object(){

		try {
			
			System.out.println("Filename : "+this.filename);
			exists = new File(this.filename).exists();
			if(exists)
			{
				helper();
			}
			else{
				System.out.println("New Record");
				o.clear();				// Clear is put here as just after reading the file in Checksize, the value of arraylist O has not been modified and must be emptied
				ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream(this.filename));
				o.add(this);
				oos.writeObject(o);	
			}

		}
		catch( Exception e ){

			e.printStackTrace();
		}
		return this;
	}

	public ArrayList<obj> view(){

			System.out.println("The file is :"+this.filename);
			objread();
	 //   		for( int i = 0; i < o.size(); i++ ){
	 //   			System.out.println(o.get(i));		
		// }
			return o;
	}

	public boolean checksize(){

			objread();
			if( o.size() == 0 )
				return true;
			if( o.size() < 2 )				// Checking condition for size greater than 5 
				return true;	
		return false;

	}


	public String getvalue(){

		this.filename = "sample0.ser";

		while(true)	// Checking if current filesize has greater than 5 records
		{
			try{ 

				exists = new File(this.filename).exists();
				if( exists && (!this.checksize()) ){		// iterating through the files, to see if it exists already
					this.count++;
					System.out.println("Checking a new file...");
					this.filename = "sample"+this.count+".ser";
				}
				else
					break;		
			}
			catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return this.filename;

	}

	public String get(String number, String name, String age, String mobile){

		this.number = Integer.parseInt(number);
		this.name = name;
		this.age = Integer.parseInt(age);
		this.mobile = Long.parseLong(mobile);
		return " This Works! ";

	}

	public String get1(){

		
		return " This Works! till here!";

	}



	public void delete(){

		objread();
		System.out.println("Record in file: "+this.filename);
		for( int i = 0; i < o.size(); i++ ){

			if( this.number == o.get(i).number ){
				mapread();
				map.remove(o.get(i).number);
				mapwrite();
				o.remove(i);
			}
		}		
		objwrite();
	}

	public String toString() {

		return "Register:"+this.number+" "+"Name:"+this.name+" "+"Age:"+this.age+" "+"Mobile:"+this.mobile;
	}

	public void mapread(){

		try { 
			 File toRead=new File("map.txt");
		     FileInputStream fis=new FileInputStream(toRead);
	         ObjectInputStream ois=new ObjectInputStream(fis);
	         map=(HashMap<Integer,String>)ois.readObject();
	         ois.close();
	         fis.close();
			}
	    	catch(Exception e){}
	    	if( map.containsKey(this.number) ){
					this.filename = map.get(this.number);
					System.out.println(this.filename);
			}
	}

	public void mapwrite(){

				map.put(this.number,this.filename);		// Inserting records into a hash map
				try{
					File f1 = new File("map.txt");
					FileOutputStream fos=new FileOutputStream(f1);
		        	ObjectOutputStream oos=new ObjectOutputStream(fos);
			        oos.writeObject(map);
			        oos.flush();
			        oos.close();
			        fos.close();	
				}
				catch(Exception e){}
		}


	public static void main(String args[]){
		obj db = new obj();
		Scanner sc = new Scanner(System.in);
		db.filename = "sample0.ser";
		boolean exists = false;
		// int choice;
		// do{ 
		// 	System.out.println("Would you like to 1. Add records ? 2. Update existing records ? 3. View the file ? 4.Delete a record? 5. Exit ?");
		// 	choice = sc.nextInt();
		// 	sc.nextLine();
		// 	if ( choice == 1 )
		// 	{
		// 		db.getvalue();
		// 		db.mapread();	
		// 		db.mapwrite();
		// 		db.object();					// Onwards to create the file 
		// 	}
		// 	else if ( choice == 2 ){
		// 		System.out.println("Enter the Employee's Register No. whoose record you wish to manipulate  : ");
		// 		db.number = sc.nextInt();
		// 		sc.nextLine();
		// 		db.mapread();
		// 		db.view();
		// 		db.update();
				
		// 	}
		// 	else if( choice == 3 ){
		// 		System.out.println("Enter the Employee's Register No. who you want to view  : ");
		// 		db.number = sc.nextInt();
		// 		sc.nextLine();
		// 		db.mapread();
		// 		db.view();
		// 	}
		// 	else if(choice == 4){
		// 		System.out.println("Enter the Employee's Register No. whom you want to delete  : ");
		// 		db.number = sc.nextInt();
		// 		sc.nextLine();
		// 		db.mapread();
		// 		db.delete();
		// 	}
		// 	else {
				
		// 		break;
		// 	}
		//   }while( choice != 5 );
	}
}	