package ru.madzi.o2.parser;

import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.ParseException;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

/**
 * @author Dmitry Eliseev
 */
public class O2Parser extends Parser {

    private Snapshot snapshot;

    @Override
    public void parse(Snapshot snapshot, Task task, SourceModificationEvent event) throws ParseException {
        this.snapshot = snapshot;
        //
    }

    @Override
    public Result getResult(Task task) throws ParseException {
        return new O2ParserResult(snapshot, this);
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

        public O2ParserResult(Snapshot snapshot, O2Parser parser) {
            super(snapshot);
            this.parser = parser;
        }

        public O2Parser getO2Parser() throws ParseException {
            if (!valid) {
                throw new ParseException();
            }
            return parser;
        }

        @Override
        protected void invalidate() {
            valid = false;
        }
    }

}
