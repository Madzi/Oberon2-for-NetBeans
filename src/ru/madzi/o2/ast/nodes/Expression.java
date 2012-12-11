package ru.madzi.o2.ast.nodes;

import ru.madzi.o2.ast.ASTNode;

/**
 * @author Dmitry Eliseev
 */
public abstract class Expression extends ASTNode {

    public Expression(int startOffset, int endOffset) {
        super(startOffset, endOffset);
    }

}
