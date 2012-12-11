package ru.madzi.o2.ast.nodes.visitors;

import ru.madzi.o2.ast.ASTNode;

/**
 * @author Dmitry Eliseev
 */
public class DefaultVisitor implements Visitor {

    public void scan(ASTNode node) {
        if (node != null) {
            node.accept(this);
        }
    }

    public void scan(Iterable<? extends ASTNode> nodes) {
        if (nodes != null) {
            for (ASTNode node : nodes) {
                scan(node);
            }
        }
    }

    @Override
    public void visit(ASTNode node) {
    }

}
