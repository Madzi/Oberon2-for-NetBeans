package ru.madzi.o2.chars;

/**
 * @author Dmitry Eliseev
 */
public class O2SnapshotCharStream extends O2AbstractCharStream {

    private CharSequence sequence;

    private int pos = 0;

    public O2SnapshotCharStream(CharSequence sequence) {
        this.sequence = sequence;
    }

    @Override
    protected char read() {
        char ch = EOF;
        if (pos < sequence.length()) {
            ch = sequence.charAt(pos++);
        }
        return ch;
    }

    @Override
    protected void backup(int count) {
        if (pos - count >= 0) {
            pos = pos - count;
        }
    }

}
