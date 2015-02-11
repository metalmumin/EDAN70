package lang.ast; // The generated scanner will belong to the package lang.ast

import lang.ast.LangParser.Terminals; // The terminals are implicitly defined in the parser
import lang.ast.LangParser.SyntaxError;

%%

// define the signature for the generated scanner
%public
%final
%class LangScanner
%extends beaver.Scanner

// the interface between the scanner and the parser is the nextToken() method
%type beaver.Symbol 
%function nextToken 

// store line and column information in the tokens
%line
%column

// this code will be inlined in the body of the generated scanner class
%{
  private beaver.Symbol sym(short id) {
    return new beaver.Symbol(id, yyline + 1, yycolumn + 1, yylength(), yytext());
  }
%}

// macros
WhiteSpace = [ ] | \t | \f | \n | \r
ID = [a-zA-Z]+[a-zA-Z0-9]*
// Numeral = [0-9]+
// Comments = ("/*")({WhiteSpace} | [a-zA-Z0-9] | "*" | ".")*("*/")

%%

// discard whitespace information and comments
// {Comments}	 { }
{WhiteSpace}  { }

// token definitions
"state"			{ return sym(Terminals.STATE); }
"trans"			{ return sym(Terminals.TRANS); }
"{"				{ return sym(Terminals.LBRACK); }
"}"				{ return sym(Terminals.RBRACK); }
"->"			{ return sym(Terminals.ARROW); }
";"				{ return sym(Terminals.SEMICOLON); }
":"				{ return sym(Terminals.COLON); }
{ID}			{ return sym(Terminals.ID); }
<<EOF>>			{ return sym(Terminals.EOF); }

/* error fallback */
[^]           { throw new SyntaxError("Illegal character <"+yytext()+">"); }
