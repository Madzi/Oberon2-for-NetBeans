package ru.madzi.o2.ast;

import ru.madzi.o2.ast.nodes.visitors.Visitor;

/**
 * @author Dmitry Eliseev
 */
public abstract class ASTNode {

    private int startOffset;
    private int endOffset;

    public ASTNode(int startOffset, int endOffset) {
        this.startOffset = startOffset;
        this.endOffset = endOffset;
    }

    public final int getStartOffset() {
        return startOffset;
    }

    public final ASTNode setStartOffset(int startOffset) {
        this.startOffset = startOffset;
        return this;
    }

    public final int getEndOffset() {
        return endOffset;
    }

    public final ASTNode setEndOffset(int endOffset) {
        this.endOffset = endOffset;
        return this;
    }

    public abstract void accept(Visitor visitor);

}
