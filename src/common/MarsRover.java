package common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarsRover {

	public static void main(String[] args) {
		List<String> commands = new ArrayList<String>(); 
		Plateau plateau;
		Rover rover1;
		Rover rover2;
		
		BufferedReader rd;
		
		try {
			rd = new BufferedReader(new FileReader(new File("src/Input.txt")));
			
			while(rd.ready()){
				String linha = rd.readLine();
				for (int i=0; i<linha.length(); i++) {
					String caractere = linha.substring(i, i+1); 
					if(!" ".equals(caractere)) {
						commands.add(caractere);
					}
				}
			}
			int plateauInicioX = Integer.valueOf(commands.get(0));
			int plateauInicioY = Integer.valueOf(commands.get(1));
			int rover1InicioX = Integer.valueOf(commands.get(2));
			int rover1InicioY = Integer.valueOf(commands.get(3));
			char direction1 = commands.get(4).charAt(0);
			int rover2InicioX = Integer.valueOf(commands.get(14));
			int rover2InicioY = Integer.valueOf(commands.get(15));
			char direction2 = commands.get(16).charAt(0);
			
			 plateau = new Plateau(plateauInicioX, plateauInicioY);
			 
				rover1 = new Rover(rover1InicioX, rover1InicioY, plateau.getLowerLeftY(),plateau.getLowerLeftX(), direction1, plateau.getupperRightX(),plateau.getupperRightY());
				plateau.insertRover(rover1);
				
				rover2 = new Rover(rover2InicioX, rover2InicioY, plateau.getLowerLeftY(),plateau.getLowerLeftX(), direction2, plateau.getupperRightX(),plateau.getupperRightY());
				plateau.insertRover(rover2);
			 
				for(int i = 5; i <= 13 ; i++) {
					try {
						rover1.control(commands.get(i).charAt(0));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				for(int i = 17; i <= 26 ; i++) {
					try {
						rover2.control(commands.get(i).charAt(0));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				System.out.println(rover1.toString() + "\n" + rover2.toString());
				FileWriter arquivo = new FileWriter(new File("src/Output.txt"));
				String output = (rover1.toString() + "\n" + rover2.toString());
		            arquivo.write(output);
		            arquivo.close();
				
				
				
//				BufferedWriter bw = new BufferedWriter(new FileWriter(new File("src/Output.txt")));
			//	bw.write(output);
					
			rd.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
		}

	}
}
