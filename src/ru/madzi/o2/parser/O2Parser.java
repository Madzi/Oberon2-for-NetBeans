package ru.madzi.o2.parser;

import ru.madzi.o2.ast.ASTNode;
import ru.madzi.o2.chars.O2SnapshotCharStream;
import ru.madzi.o2.lexer.O2Lexer;
import ru.madzi.o2.lexer.O2Token;

/**
 * @author Dmitry Eliseev
 */
public class O2Parser {

    private O2Lexer lexer;
    private ASTNode ast;

    public O2Parser(CharSequence sequence) {
        lexer = new O2Lexer(new O2SnapshotCharStream(sequence));
    }

    public void parse() {
        O2Token token = lexer.getToken();
        while (token != O2Token.EOF) {
            token = lexer.getToken();
        }
    }

    public ASTNode getAST() {
        return ast;
    }

}
