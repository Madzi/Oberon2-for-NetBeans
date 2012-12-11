package ru.madzi.o2.lexer;

/**
 *
 * @author Dmitry Eliseev
 */
public enum O2Category {

    ERROR("error"),
    WARNING("warning"),
    WHITESPACE("whitespace"),
    CHARACTER("character"),
    SEPARATOR("separator"),
    OPERATOR("operator"),
    STRING("string"),
    NUMBER("number"),
    TAG("tag"),
    IDENTIFIER("identifier"),
    KEYWORD("keyword"),
    TYPE("type"),
    SYSTEM("system"),
    POINTER("pointer"),
    COMMENT("comment");

    private String name;

    O2Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
