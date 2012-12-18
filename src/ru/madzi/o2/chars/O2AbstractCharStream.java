package ru.madzi.o2.chars;

import java.util.TreeSet;

/**
 * @author Dmitry Eliseev
 */
public abstract class O2AbstractCharStream {

    public static final char EOF = (char) -1;

    private TreeSet<Integer> newLines = new TreeSet<Integer>();

    private int index = 0;

    private int line = 1;

    private int charPositionInLine = 0;

    public O2AbstractCharStream() {
        newLines.add(Integer.valueOf(0));
    }

    public int getLine() {
        return line;
    }

    public O2AbstractCharStream setLine(int line) {
        this.line = line;
        return this;
    }

    public int getCharPositionInLine() {
        return charPositionInLine;
    }

    public O2AbstractCharStream setCharPositionInLine(int charPositionInLine) {
        this.charPositionInLine = charPositionInLine;
        return this;
    }

    public int index() {
        return index;
    }

    public char readChar() {
        char ch = read();
        index++;
        charPositionInLine++;
        if (ch == '\n') {
            line++;
            charPositionInLine = 0;
            newLines.add(Integer.valueOf(index));
        }
        return ch;
    }

    public void undoChar(int count) {
        int newIdx = index - count;
        assert newIdx > 0;
        while (newLines.last() > newIdx) {
            newLines.remove(newLines.last());
        }
        index = newIdx;
        line = newLines.size();
        charPositionInLine = index - newLines.last();
        backup(count);
    }

    protected abstract char read();

    protected abstract void backup(int count);

}
