package utilitarios;

import exceptions.LexicalException;

public class Sintaxis {
	
	public static boolean analizoTexto(String txt)  throws LexicalException {
		
		boolean esTexto = false;
	
	
		String delimitadores= "[\\ \\	\\  \\   \\    \\		\\\n]";
		
		String texto[] = txt.split(delimitadores);

		for(int i=0; i< texto.length; i++) {
		
		
			
			if(texto.length != 0){
			
				if (texto[i].matches("([a-zA-Z])+")) {
					esTexto = true;
			
				}  else{
					esTexto = false;
			
				}
			}
		}
	
		return esTexto;
	}
	
	public static boolean analizoNumero(String txt)  throws LexicalException {
		
		String delimitadores= "[\\ \\	\\  \\   \\    \\		\\\n]";
		boolean validoNum = false;
		String texto[] = txt.split(delimitadores);
		for(int i=0; i< texto.length; i++) {
			
		
			for (int x=0;x<texto[i].length() ;x++)
     	
			{ 
    	
				if ((Character.isDigit(texto[i].charAt(x))) || 
						(Character.isDigit(texto[i].charAt(x)))) {
					validoNum=true;} 
				else {
					validoNum=false;
				}
			}
			
			}
		return validoNum;
    	
	}
	public static boolean analizoTelefono(String txt)  throws LexicalException {
		
		boolean esTexto = false;
		
		
		String delimitadores= "-";
		
		String texto[] = txt.split(delimitadores);

		for(int i=0; i< texto.length; i++) {
		
		
			
			if(texto.length != 0){
			
				if (texto[i].matches("([0-9])+")) {
					esTexto = true;
			
				}  else{
					esTexto = false;
			
				}
			}
		}
	
		return esTexto;
		
	}
	public static boolean analizoDNI(String texto) throws LexicalException {

		boolean validoNum = false;
		
		
			if(texto.length() > 6 && texto.length() < 10){
				for(int i=0; i< texto.length(); i++) {
					if ((Character.isDigit(texto.charAt(i))) || 
							(Character.isDigit(texto.charAt(i)))) {
						validoNum=true;} 
					else {
						validoNum=false;
					}
				}
				return validoNum;
			}else
			{return false;}
		} 
		

	
}
