import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
//import java.util.HashSet;
//import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Counter  {


	public static void main(String[] args) {
		if(args.length > 0)
			counter(args[0],args[1]);
		else
			System.out.println("Argumentos invalidos");
	}
/*=======================================================================================================*/
	public static HashSet<String> wordStop(String comodines){
		HashSet<String> set = new HashSet<>();
		
		try{
			Scanner sc = new Scanner(new File(comodines));
			while(sc.hasNext()){
				String word = sc.next().trim().toLowerCase();
				set.add(word);
			}
			
			sc.close();
			
		}catch(FileNotFoundException e){
			System.out.println("No se encontro el archivo: " + comodines);
		}
		/**=======================================================**/
		return set;
	}
	/*====================================================================================*/
	public static void counter(String file,String args1){
		HashMap<String,Integer> words = new HashMap<>();
		Scanner sc ;

				
		try{
			sc = new Scanner(new File(file));
			sc.useDelimiter(",|\\.|:|-|;|\\<|\\>|\\(|\\)|\\¿|\\?|!|\\¡|\\/|\\\\|\\{|\\}|\\[|\\]|\\*|\\+|\\^|\\<|\\>|\\p{javaWhitespace}+");
			String newWord;
			
			while(sc.hasNext()){
				newWord = sc.next();
				newWord = newWord.trim().toLowerCase();
				if(!newWord.equals("")){
					if(words.containsKey(newWord)){
					
						 words.put(newWord, words.get(newWord) +1 );
						
					}else{
						
						words.put(newWord, 1);
					}
				}
			}
			
		}catch(FileNotFoundException e){
			System.out.println("No se encontro el fichero: " + file);
		}
		
		List<Element> list = new ArrayList<>();
		
		for(String word:words.keySet()){
			Integer c = words.get(word);
			Element e = new Element(word,c);
			if(list.isEmpty()){
				list.add(e);
			}else{
				int i = 0;
				while(i<list.size()){
					if(list.get(i).Value <= e.Value){
						list.add(i,e);
						i=list.size()+1;
					}
					i++;
				}
				
			}
		}
/*===================================================================================*/
		HashSet<String> stpWord = wordStop(args1);
		write(file,list,stpWord);
	}

	/****************************************************************************************************/
	
	public static void write(String file, List<Element> list, HashSet<String> stpWord){
		BufferedWriter bw;
		try{
			System.out.println("\t\t|=========================================|");
			System.out.println("\t\t|         CONTADOR DE PALABRAS            |");
			System.out.println("\t\t|=========================================|");
			System.out.println("\t\t|        10 PALABRAS MÁS COMUNES          |");
			System.out.println("\t\t|=========================================|");
			/*======================================================================*/
			bw =  new BufferedWriter( new FileWriter("reporte.txt"));
			bw.write("REPORTE DEL ARCHIVO: "+file);
			bw.newLine();
			bw.newLine();
			//bw.flush();
			bw.write("\t\t|=========================================|");
			bw.newLine();
			bw.write("\t\t|         ESTADISTICAS GENERALES          |");
			bw.newLine();
			bw.write("\t\t|=========================================|");
			bw.newLine();
			bw.write("\t\t|        10 PALABRAS MÁS COMUNES          |");
			bw.newLine();
			bw.write("\t\t|=========================================|");
			bw.newLine();
			/*========================================================================*/
			int i=0,j=0;
			int t1=0;//t1 almacena el total de palabras con auxiliares
			int t2=0;//t2 almacena el total de palabras sin auxiliares
			while(i<list.size()){
				if(!stpWord.contains(list.get(i).key)){
					t2+=list.get(i).Value;
					if(j<10){
						System.out.println("\t\t|\t"+list.get(i).key+" === "+list.get(i).Value);
						bw.write("\t\t|\t"+list.get(i).key+" === "+list.get(i).Value);
						bw.newLine();
						j++;
					}
				}
				t1+=list.get(i).Value;
				i++;
			}
			/*=========================================================*/
			bw.write("\t\t|=========================================|");
			bw.newLine();
			bw.write("\t\t|         ESTADISTICAS GENERALES          |");
			bw.newLine();
			bw.write("\t\t|=========================================|");
			bw.newLine();
			bw.write("\t\t|  Total de palabras con auxiliares: "+t1);
			bw.newLine();
			bw.write("\t\t|=========================================|");
			bw.newLine();
			bw.write("\t\t|  Total de palabras sin auxiliares: "+t2);
			bw.newLine();
			bw.write("\t\t|=========================================|");
			/*=====================================================================*/
			System.out.println("\t\t|=========================================|");
			System.out.println("\t\t|         ESTADISTICAS GENERALES          |");
			System.out.println("\t\t|=========================================|");
			System.out.println("\t\t|  Total de palabras con auxiliares: "+t1);
			System.out.println("\t\t|=========================================|");
			System.out.println("\t\t|  Total de palabras sin auxiliares: "+t2);
			System.out.println("\t\t|=========================================|");
			bw.newLine();
			bw.write("Lista de palabras con sus repeticiones");
			bw.newLine();
			for(i=0;i<list.size();i++){
				bw.write(list.get(i).key + " " + list.get(i).Value);
				bw.newLine();
			}
			System.out.println("\n\t\t reporte generado ");
			/*==========================================================================================*/
		   //bw.flush();
		   bw.close();
		}catch(IOException e){
			System.out.println("Error al escribir en el archivo");
		}
	}
}
