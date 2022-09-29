import java.io.*;

class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{
      		BufferedWriter output = new BufferedWriter(new FileWriter("testeMaquinaPilha.txt"));
			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			CodeGen backend = new CodeGen();
			String codigo = backend.geraCodigo(arv);

			System.out.println(codigo);

			output.write(codigo);

			output.close();
		} catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
