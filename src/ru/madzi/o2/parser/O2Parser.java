package ru.madzi.o2.parser;

import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;
import org.netbeans.spi.lexer.LexerRestartInfo;
import ru.madzi.o2.lexer.O2Lexer;
import ru.madzi.o2.ast.ASTNode;
import ru.madzi.o2.lexer.O2LanguageHierarchy;
import ru.madzi.o2.lexer.O2TokenId;

/**
 * @author Dmitry Eliseev
 */
public class O2Parser extends Parser {

    private boolean cancelled = false;
    private ASTNode ast;
    private Snapshot snapshot;

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) throws ParseException {
        cancelled = false;
        this.snapshot = snapshot;
        // for {
        // parsong snapshot.getText()
        // if (cancelled) return;
        // }
        // ast = ...;
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return new O2ParserResult(snapshot, this);
    }

    public ASTNode getAST() {
        return ast;
    }

    public void cancel()  {
        cancelled = true;
    }

    @Override
    public void addChangeListener(ChangeListener changeListener) {
    }

    @Override
    public void removeChangeListener(ChangeListener changeListener) {
    }

    public static class O2ParserResult extends Result {

        private O2Parser parser;
        private boolean valid = true;
        private ASTNode ast;

        public O2ParserResult(Snapshot snapshot, O2Parser parser) {
            super(snapshot);
            this.parser = parser;
            this.ast = parser.getAST();
        }

        public O2Parser getO2Parser() throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return parser;
        }

        public ASTNode getAST() throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return ast;
        }

        @Override
        protected void invalidate() {
            valid = false;
            ast = null;
        }
    }

}
