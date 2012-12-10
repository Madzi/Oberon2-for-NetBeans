package ru.madzi.o2.lexer;

/**
 *
 * @author Dmitry Eliseev
 */
public enum O2Category {

    ERROR("error"),
    WHITESPACE("whitespace"),
    SEPARATOR("separator"),
    OPERATOR("operator"),
    STRING("string"),
    NUMBER("number"),
    DIRECTIVE("directive"),
    IDENTIFIER("identifier"),
    KEYWORD("keyword"),
    COMMENT("comment");

    private String name;

    O2Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
