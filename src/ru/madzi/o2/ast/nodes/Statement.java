package ru.madzi.o2.ast.nodes;

import ru.madzi.o2.ast.ASTNode;

/**
 * @author Dmitry Eliseev
 */
public abstract class Statement extends ASTNode {

    public Statement(int startOffset, int endOffset) {
        super(startOffset, endOffset);
    }

}
