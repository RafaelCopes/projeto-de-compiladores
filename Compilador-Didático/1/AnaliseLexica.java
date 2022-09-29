import java.io.*;

enum TokenType { 
	NUM,
	SOMA, 
	MULT,
	APar,
	FPar, 
	EOF
}

class Token {
  String lexema;
  TokenType token;

 Token (String l, TokenType t) { 
	lexema = l;
	token = t;
}	
}

class AnaliseLexica {
	BufferedReader arquivo;

	AnaliseLexica(String a) throws Exception {
	 	this.arquivo = new BufferedReader(new FileReader(a));
	}

	Token getNextToken() throws Exception {	
		int eof = -1;
		char currchar;
		int currchar1;
		String token = "";

		do{
			currchar1 =  arquivo.read();
			currchar = (char) currchar1;
		} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
		
		if(currchar1 != eof && currchar1 !=10)
		{
			if (currchar >= '0' && currchar <= '9') {
				while (currchar >= '0' && currchar <= '9') {
					arquivo.mark(0);

					token = token + currchar;

					do {
						currchar1 =  arquivo.read();
						currchar = (char) currchar1;
					} while (currchar == '\n' || currchar == ' ' || currchar =='\t' || currchar == '\r');
				}

				arquivo.reset();

				return (new Token (token, TokenType.NUM));

			} else
				switch (currchar){
					case '(':
						return (new Token (token,TokenType.APar));
					case ')':
						return (new Token (token,TokenType.FPar));
					case '+':
						return (new Token (token,TokenType.SOMA));
					case '*':
						return (new Token (token,TokenType.MULT));
					
					default: throw (new Exception("Caractere inválido: " + ((int) currchar)));
				}
		}

		arquivo.close();
		
		return (new Token(token,TokenType.EOF));
		
	}
}
