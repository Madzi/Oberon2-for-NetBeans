package ru.madzi.o2.ast.nodes.visitors;

import ru.madzi.o2.ast.ASTNode;

/**
 * @author Dmitry Eliseev
 */
public interface Visitor {

    public void visit(ASTNode node);

}
