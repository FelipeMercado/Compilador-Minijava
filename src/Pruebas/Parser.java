package Pruebas;

import java.util.StringTokenizer;
import java.util.Vector;

import proyecto1.ArbolRecur;
import proyecto1.Compilador;
import proyecto1.Nodo2;
import proyecto1.Tabla;
public class Parser {
	static ArbolRecur arbol=new ArbolRecur();
	static Nodo2 nodo;
	static Nodo2 nodo1;
	static Nodo2 dec;
	static Nodo2 tipo;
	static boolean valida=true,flag=false;
	String x;
	StringTokenizer tk2;
	Compilador c;
	Tabla tab;
	String linea;
	Vector<String> table=new Vector<String>();
	Vector<String> token=new Vector<String>();
	
	//constructor
	Parser(String g)  {
		////System.out.println(valida);
		valida=true;
		StringTokenizer tk=new StringTokenizer(g,"\n");
		while(tk.hasMoreTokens()==true){
			try {
				nodo1 =new Nodo2 ("programa");
				linea=tk.nextToken();
				//System.out.println(linea);
				tk2=new StringTokenizer(linea," ");
				arbol.raiz=nodo1;
				x=tk2.nextToken();
				//aaaaaaaa
				//arbol.insertarRaiz(nodo1.getDato());
				
				
				
//				arbol.InsertarRecursivo(dec,x,"Programa" );
				
				if(x.equals("<EOF>")){
					nodo =new Nodo2 ("<EOF>сссс");
					nodo1.aumentarHijo(nodo);//inserta hijo 
					eof(x);					
				}
				else{
					

					parsea(x);
					
					//System.out.println(valida);
				}
			} catch (Exception e) {
				valida=false;
			}
		}	
		
		if(valida==true){
			tab=new Tabla(table,token);
//			System.out.println(arbol.raiz.info);
//			arbol.verHijosRecursivo(arbol.raiz);
		}if(valida==false){
			//System.out.println("No compilable");
		}
	}
	public boolean daval(){
		return valida;
	}
	void parsea(String x) {
		//System.out.println(valida);
			programa();
			
	}
	void programa() {
		//System.out.println("Valor actual"+ x);
		if((x.equals("int")||x.equals("boolean"))&&flag==false){
//			nodo=new Nodo2("dec");
//			ArbolRecur.raiz.aumentarHijo(nodo);
//			dec =new Nodo2 ("declaa>сссс");
//			nodo1.aumentarHijo(dec);//inserta hijo 
//			dec =new Nodo2 ("dec");
//			ArbolRecur.InsertarRecursivo(dec, "dec", arbol.raiz.info);//inserta hijo 
//			ArbolRecur.verHijosRecursivo(arbol.raiz);
//			System.out.println("ca");
			
			System.out.println(flag + " " + x);
			if(tk2.hasMoreTokens()){
				//System.out.println(valida);
				varDec(x);
				
			}
		}	
		if((x.equals("int")||x.equals("boolean"))&&flag==true){
			valida=false;
			//System.out.println(valida);
		}
		if((x.equals("if")||x.equals("while"))){
			flag=true;
			//System.out.println(valida);
			statement();
			
		}
		if(x.equals("<EOF>")){
			flag=true;
			nodo =new Nodo2 ("<EOF>,,,,");
			nodo1.aumentarHijo(nodo);//inserta hijo 
			eof(x);
			
			//System.out.println(valida);
		}
	}
	private void statement() {
		flag =true;
		if(esVariable(x)){
			//System.out.println("empieza aqui-------"+x);
			x=tk2.nextToken();
			igual(x);
			x=tk2.nextToken();
			esVariable(x);
			//System.out.println("debe ser variable" + x);
			//System.out.println(valida);
			expresion();
		}
		if(x.equals("if")){
			//System.out.println(valida +"if");
			//System.out.println(x);
			sIf(x);
			x=tk2.nextToken();
			//System.out.println("abre  "+ x);
			abre(x);
			x=tk2.nextToken();
			//System.out.println(valida);
			expresion();
			
			//System.out.println("cierra  "+x);
			cierra(x);
		}
		if(x.equals("while")){
			whil(x);
			System.out.println(x+"debe ir el while");
			
			x=tk2.nextToken();
			//System.out.println("abre  "+ x);
			abre(x);
			x=tk2.nextToken();
			//System.out.println(valida);
			expresion();
			
		}
		

			
	}

	
	void expresion(){//----------------------------Aquн tambien
		flag=true;
		//System.out.println(valida);
			esVariable(x);//si termina en id
			//System.out.println(x+"      aqui vale verga");
			x=tk2.nextToken();
			//System.out.println(x+"    determinar a donde entra");
			if((x.equals("=="))){
				igualigual(x);
				x=tk2.nextToken();
				esVariable(x);
				//System.out.println(x+ " aqui debe se y pero de ai falla el parser");
				
				if( (/*esVariable(x)||*/x.equals("if")||x.equals("while"))){
					//System.out.println("Por si las dudads");
					statement();
				}//vuelve a Statemen
				
				if(x.equals("<EOF>")){
					nodo =new Nodo2 ("<EOF>");
					nodo1.aumentarHijo(nodo);//inserta hijo 
					 eof(x);
				}else
				
				if( (x.equals("int")||x.equals("boolean"))){
					valida=false;
				}
				
			}//iz por parte del s
			if((x.equals("+"))){//-----------mas
				//System.out.println(valida+ "mas");
				mas(x);//System.out.println("Entra aqui al mas");
				x=tk2.nextToken();
				esVariable(x);
				//System.out.println(x+"-----------");
				x=tk2.nextToken();
				//System.out.println(x+"-----------");
				cierra(x);
				
				x=tk2.nextToken();
				//System.out.println(x+"-----------");
				//if((tk2.nextToken().equals("<EOF>"))){
				//eof(x);
				//}else
				if((esVariable(x)||x.equals("if")||x.equals("while"))){
					//System.out.println("tambien");
					//System.out.println(x+"---------aaaa");
					x=tk2.nextToken();
					if(esVariable(x)){
						//System.out.println(x+"-------sss----");
						igual(x);
						x=tk2.nextToken();
						//System.out.println(x+"-------sss----");
						esVariable(x);
					}
					
					
					statement();
				}//vuelve a Statement
				
			}//iz por parte del s en el apartado mas
			if(tk2.hasMoreTokens()&&(esVariable(x)||x.equals("if")||x.equals("while"))){
				x=tk2.nextToken();
				statement();
			}else//vuelve a Statement
			if(tk2.hasMoreTokens()&&(x.equals("<EOF>"))){
				//System.out.println("expresion=");
				nodo =new Nodo2 ("<EOF>");
				nodo1.aumentarHijo(nodo);//inserta hijo 
				eof(x);
			}//id=id  luego eof parte derecha
		
	}
	void varDec(String x) {
		
		vDec(x);
		
		x=tk2.nextToken();
		if(tk2.hasMoreTokens()){
			iden(x);x=tk2.nextToken();
		} 
		punto(x);
		programa();
		if(tk2.hasMoreTokens()){
			//System.out.println(x  +  "    me la turbo pelo aqui");
			x=tk2.nextToken();
			//System.out.println(x+" the last one ");
			programa();
		} 
	}
	
	void punto(String x){
		if(x.equals(";")){
			table.add("punto y coma");
			token.add(x);
			////System.out.println("aqui esta linea por linea"+table.lastElement()+"  |  "+token.lastElement());
			
		}else{ 
			//System.out.println("fallo punto");
			valida=false;	
		}
		
	}
	void igual(String x){
		if(x.equals("=")){
			table.add("igual");
			token.add(x);
			////System.out.println("aqui esta linea por linea"+table.lastElement()+"  |  "+token.lastElement());
		}//else //System.out.println("fallo igual");
		
	}
	void mas(String x){
		if(x.equals("+")){
			table.add("mas");
			token.add(x);
			////System.out.println("aqui esta linea por linea"+table.lastElement()+"  |  "+token.lastElement());
		}//else //System.out.println("fallo mas");
	}
	void igualigual(String x){
		if(x.equals("==")){
			table.add("mas mas");
			token.add(x);
			////System.out.println("aqui esta linea por linea"+table.lastElement()+"  |  "+token.lastElement());
		}//else //System.out.println("fallo mas mas");
	}
	void other(String x){
		if(x.equals("|")){
			table.add("other");
			token.add(x);
			////System.out.println("aqui esta linea por linea"+table.lastElement()+"  |  "+token.lastElement());
		}//else //System.out.println("fallo other");
	}
	void whil(String x){
		if(x.equals("while")){
			table.add("while");
			token.add(x);
			////System.out.println("aqui esta linea por linea"+table.lastElement()+"  |  "+token.lastElement());
		}//else System.out.println("fallo while");
	}
	void sIf(String x){
		if (x.equals("if")) {
			table.add("condicion");
			token.add(x);
			////System.out.println("aqui esta linea por linea "+table.lastElement()+"  |  "+token.lastElement());	
		}
	}
	void abre(String X){
		if (x.equals("(")) {
			table.add("parentesis a");
			token.add(x);
			////System.out.println("aqui esta linea por linea "+table.lastElement()+"  |  "+token.lastElement());		
		}
	}
	void cierra(String x){
		if (x.equals(")")) {
			table.add("parentesis cU");
			token.add(x);
			////System.out.println("aqui esta linea por linea "+table.lastElement()+"  |  "+token.lastElement());
		}
	}
	void eof(String x){
		if(x.equals("<EOF>")){
			
			
			table.add("<EOF>");
			token.add(x);
			
			//ArbolRecur.verHijosRecursivo(nodo1);//muestra
			//arbol.InsertarRecursivo(nodo, "<EOF>", ArbolRecur.raiz.getDato());
			if(tk2.hasMoreTokens()){
				valida=false;
			}
			
		}  			
	}
	
	boolean esVariable(String x){
		int aux=0;
		boolean resp=false;
		for (int i = 0; i < token.size(); i++) {
			if(token.elementAt(i).toString().equals(x)){
				aux=i;
			}
		}
		if(table.elementAt(aux).toString().equals("identificador")){
			resp=true;
		}
		
		return resp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------------------copiado---------------------------------------------
	
	
	
	void vDec(String x){
		if((x.equals("int")||x.equals("boolean"))&&tk2.hasMoreTokens()){
//			System.out.println("xxxxxx");
//			tipo =new Nodo2 (x);
//			ArbolRecur.InsertarRecursivo(tipo, x, arbol.raiz.info);//inserta hijo 
//			
			table.add("variable");
			token.add(x);
			////System.out.println("aqui esta linea por linea "+table.lastElement()+"  |  "+token.lastElement());
		} 
	}
	void iden(String x){
		if(Character.isLetter(x.charAt(0))&&tk2.hasMoreTokens()){
			for (int i = 0; i < x.length(); i++) {
				////System.out.println(x.charAt(i));
				if(Character.isDigit(x.charAt(i))||Character.isLetter(x.charAt(i))){
				
				}else{ //System.out.println("error fatal");
				i=x.length()+1;
				}
			}
		}
		table.add("identificador");
		token.add(x);
		////System.out.println("aqui esta linea por linea "+table.lastElement()+"  |  "+token.lastElement());
		
	}

}
	


