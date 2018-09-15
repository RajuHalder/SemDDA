package Octagonal;
import java.util.*;
import java.io.*;

public class InputHandler{

	static String tableName = "";
	static String[] variables = null;
	static double[] constants = null;
	static double[][] array = null;

	public static int[][] main(File dependencyMain,File inputMain){
		int[][] depArray = null;
		try{
			FileOutputStream out = new FileOutputStream("input.txt");
	         ObjectOutputStream oout = new ObjectOutputStream(out);
	         


	         try{
	        	 BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(dependencyMain)));
			 	tableName = in.readLine();
			 	variables = (in.readLine()).split(",");
			 	String[] constantString = (in.readLine()).split(",");
			 	constants = new double[variables.length*2];
			 	array = new double[2*variables.length][variables.length];
			 	for(int i=0;i<variables.length*2;i=i+2){
			 		constants[i] = Integer.parseInt(constantString[i]);
			 		constants[i+1] = -1*Integer.parseInt(constantString[i+1]);
			 	}

				for(int i=0;i<variables.length;i++)
				{
					array[2*i][i] = 1;
					array[2*i+1][i] =-1;
				}
				
	        	oout.writeObject(variables);
	    	    oout.writeObject(array);
		        oout.writeObject(constants);
		        oout.flush();

	         	depArray = SemanticAnalysis.main(inputMain);
	         }
			 catch(Exception e){
			 	e.printStackTrace();
			 	System.out.println("Stack Trace 1111");
			 }

	      
     	}
     	catch(Exception e){
				e.printStackTrace();
     	}
		return depArray;
     }

}