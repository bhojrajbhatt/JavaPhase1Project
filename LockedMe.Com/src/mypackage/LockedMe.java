	package mypackage;

	import java.io.File;
	import java.io.FileWriter;
	import java.util.Scanner;

	public class LockedMe {
		
		static final String projectFilesPath = "C:\\Users\\bhojr\\Documents\\java\\JavaProgram\\LockedMe.Com\\docs";
		static final String errorMessage = "There is something wrong. Please contact the administrator!";
		

		/**
		 * @param args
		 */
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
					
					case 4: exit();
					break;
				}
				
			}while(ch>0);
			obj.close();
		}
		/**
		 * This code will display the Menus
		 */
		public static void displayMenu()
		{
			System.out.println("=====================================================================");
			System.out.println("**********************Welcome To LockedMe.com************************");
			System.out.println("###################Developed By: Bhoj Raj Bhatt######################");
			System.out.println("=====================================================================");
			System.out.println('\n');
			System.out.println("\t\t 1. Display all the files.");
			System.out.println("\t\t 2. Add a new files.");
			System.out.println("\t\t 3. Delete the files.");
			System.out.println("\t\t 4. Search the files");
			System.out.println("\t\t 5. Exit");
			
		  	
		}
        /**
         * This function displays all the existing files
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
				{
					for(int i = 0; i<listOfFiles.length; i++)
					{				
						System.out.println(listOfFiles[i].getName());
					}
				}
			}catch(Exception Ex)
			{
				System.out.println("Some error occure. Please contact: info@lockedme.com!");
			}
			
		}
		/**
		 * This function creates the new file
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
		 * This function delete the file
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
						System.out.println("File Not found!");
			}catch(Exception Ex){
				
			}
		}
		
		/**
		 * This function search the file with filename
		 */
		public static void searchFiles()
		{
			String fileName;
			Scanner obj = new Scanner(System.in);
			System.out.println("Enter the file name to be search: ");
			fileName = obj.nextLine();
			File folder = new File(projectFilesPath);
			File[] listOfFiles = folder.listFiles();
			
			
			
		}
		
		public static void exit()
		{
			
		}

	}
