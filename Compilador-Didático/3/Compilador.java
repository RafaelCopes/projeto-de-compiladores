class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{
			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();

			CodeGen backend = new CodeGen();
			int result = backend.interpreta(arv);
			System.out.println(result);
		} catch(Exception e) {
			System.out.println("Erro de compilação:\n" + e);
		}
	}
}
