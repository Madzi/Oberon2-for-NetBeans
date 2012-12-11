package ru.madzi.o2.ast;

import ru.madzi.o2.ast.nodes.Statement;
import ru.madzi.o2.ast.nodes.visitors.Visitor;

/**
 * @author Dmitry Eliseev
 */
public class ASTError extends Statement {

    public ASTError(int startOffset, int endOffset) {
        super(startOffset, endOffset);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

}
