package org.stack.algorithms.basic.algo;

import java.util.Stack;

public class UndoRedoEditor {
    private StringBuilder text;
    private Stack<Character> undoStack;
    private Stack<Character> redoStack;

    public UndoRedoEditor() {
        text = new StringBuilder();
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public void type(char c) {
        text.append(c);
        undoStack.push(c);
        redoStack.clear();
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            char removed = undoStack.pop();
            redoStack.push(removed);
            text.deleteCharAt(text.length() - 1);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            char restored = redoStack.pop();
            text.append(restored);
            undoStack.push(restored);
        }
    }

    public String getText() {
        return text.toString();
    }

    public static void main(String[] args) {
        UndoRedoEditor editor = new UndoRedoEditor();

        editor.type('H');
        editor.type('e');
        editor.type('l');
        editor.type('l');
        editor.type('o');
        System.out.println(editor.getText());

        editor.undo();
        editor.undo();
        System.out.println(editor.getText());

        editor.redo();
        System.out.println(editor.getText());

        editor.type('!');
        System.out.println(editor.getText());
    }
}

