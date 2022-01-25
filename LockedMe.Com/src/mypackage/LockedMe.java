package mypackage;

import java.io.File;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class LockedMe {
		
		static final String projectFilesPath = "C:\\Users\\bhojr\\Documents\\java\\JavaProgram\\LockedMe.Com\\docs";
		static final String errorMessage = "There is something wrong. Please contact the admin@lockedme.com!";
		

		public static void main(String[] args) {
	        Scanner obj = new Scanner(System.in);
	        int ch;
			do
			{   
				displayMenu();
				System.out.println("Enter you choice(Menu Number):");
				ch = Integer.parseInt(obj.nextLine());
				switch(ch)
				{
					case 1: getAllFiles();
					break;
					case 2: creatFiles();
					break;
					case 3: deleteFiles();
					break;
					case 4: searchFiles();
					break;
					case 5: exit();
					break;
					default:System.out.println("Invalid Option! Please enter correct option(1-5)");
					break;
				}
				
			}while(ch>0);
			obj.close();
		}
		/**
		 * This function will display the Menu.
		 */
		public static void displayMenu()
		{
			System.out.println("=====================================================================");
			System.out.println("**********************Welcome To LockedMe.com************************");
			System.out.println("###################Developed By: Bhoj Raj Bhatt######################");
			System.out.println("=====================================================================");
			System.out.println('\n');
			System.out.println("\t\t 1. Display all the files.");
			System.out.println("\t\t 2. Add a new file.");
			System.out.println("\t\t 3. Delete a file.");
			System.out.println("\t\t 4. Search a file.");
			System.out.println("\t\t 5. Exit.");
			System.out.println("----------------------------------------------------------------------");
			
		  	
		}
        /**
         * This method will displays all the existing files from the project directory.
         */
		public static void getAllFiles()
		{
			try
			{
				File folder = new File(projectFilesPath);
				File[] listOfFiles = folder.listFiles();
				if(listOfFiles.length==0)
					System.out.println("No files exist in the directory");
				else
				{	System.out.println("There are following files in the project directory:");
					for(int i = 0; i<listOfFiles.length; i++)
					{				
						System.out.println(listOfFiles[i].getName());
					}
				}
			}catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}
		}
		
		
		/**
		 * This method will creates the new file
		 */
		public static void creatFiles()
		{
			try{	
			    Scanner obj = new Scanner(System.in);
			    String fileName;
			    String content;
			  
			    System.out.println("Enter file name:");
			    fileName = obj.nextLine();
			    
			    File fobj = new File(projectFilesPath+"\\"+ fileName);
			    
			    if(fobj.createNewFile())
			    {
			        System.out.println("File Created:" + fileName);
			     	int linesCount;
				    System.out.println("Enter how many lines in the file: ");
				    linesCount = Integer.parseInt(obj.nextLine());
				    FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
				   
				    for(int i=1; i<=linesCount; i++)
				    {
				    	System.out.println("Enter the text line" + i);
				    	fw.write(obj.nextLine()+"\n");
				     }
				    fw.flush();
			        fw.close();
				    System.out.println("Text written on the file successfully!!");
			     
			    }else{
			    	System.out.println("File name already exit! Please give new name.");
			    }
			}catch(Exception Ex)
			{
				System.out.println(errorMessage);
			}
		}
		
		
		/**
		 * This method will delete the file based on provided file name.
		 */
		public static void deleteFiles()
		{
			try{
					String fileName;
					Scanner obj = new Scanner(System.in);
					System.out.println("Enter the file name to be deleted: ");
					fileName = obj.nextLine();
		
					File file = new File(projectFilesPath+"\\"+ fileName);
					if(file.exists())
					{
						file.delete();
						System.out.println("File deleted successfully!!");
					}else
						System.out.println("File Not Available!");
			}catch(Exception Ex){
				System.out.println(errorMessage);
			}
		}
		
		
		/**
		 * This method will search the file based on provided file name.
		 */
		public static void searchFiles()
		{
			Scanner obj = new Scanner(System.in);
			try{
				String fileName;
				System.out.println("Enter the file name to be search: ");
				fileName = obj.nextLine();
				
				File folder = new File(projectFilesPath);
				File[] listOfFiles = folder.listFiles();
				LinkedList<String> filenames = new LinkedList<String>();
				
				for(File l:listOfFiles)
					filenames.add(l.getName());
					
					if(filenames.contains(fileName)){
						System.out.println("File Found!");
						
					}else{
						System.out.println("File not found!");
					}
				
			}catch(Exception Ex){
				System.out.println(errorMessage);
			}	
		}
		public static void exit(){
			System.out.println("Thank you for using this system!It's Exit Now!See you again!");
			System.exit(0);
		}
		
}
