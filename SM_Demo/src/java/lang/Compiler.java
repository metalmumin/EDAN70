package lang;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import lang.ast.ErrorMessage;
import lang.ast.LangParser;
import lang.ast.LangScanner;
import lang.ast.Program;
import beaver.Parser.Exception;

public class Compiler {

	public static void main(String[] args) {
		try {
			String filename = "testfiles/sm_test_1.lang";
			if (args.length == 1) {
				filename = args[0];
			}

			LangScanner scanner = new LangScanner(new FileReader(filename));
			LangParser parser = new LangParser();
			Program program = (Program) parser.parse(scanner);
			StringBuilder sb = new StringBuilder();
			for (ErrorMessage m: program.errors()) {
				sb.append(m).append("\n");
			}
			System.out.println(sb);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace(System.err);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

