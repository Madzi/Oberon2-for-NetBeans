package ru.madzi.o2.ast.nodes.visitors;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import ru.madzi.o2.ast.ASTNode;

/**
 * @author Dmitry Eliseev
 */
public class DefaultTreePathVisitor extends DefaultVisitor {

    private LinkedList<ASTNode> path = new LinkedList<ASTNode>();

    private List<ASTNode> unmodifablePath;

    public DefaultTreePathVisitor() {
        unmodifablePath = Collections.unmodifiableList(path);
    }

    public List<ASTNode> getPath() {
        return unmodifablePath;
    }

}
