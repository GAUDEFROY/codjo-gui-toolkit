/*
 * Team : AGF AM / OSI / SI / BO
 *
 * Copyright (c) 2001 AGF Asset Management.
 */
package net.codjo.gui.toolkit.text;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
/**
 * Composant graphique peremettant d'�diter un texte.
 *
 * <p> Le composant permet de restreindre la saisie en limitant le nombre de caract�res admis tout en filtrant
 * les caract�res non autoris�s. De plus, il permet de passer en mode UpperCase. </p>
 */
public class TextField extends JTextField {
    private int maxTextLength = -1;
    private String notAllowedCharsPattern = null;
    private boolean upperCaseMode = false;


    public TextField() {
        setDocument(new TextDocument());
    }


    /**
     * Positionne le nombre maximum de caract�res autoris�s
     *
     * @param maxTextLength Le nombre maximum de caract�res autoris�s
     */
    public void setMaxTextLength(int maxTextLength) {
        this.maxTextLength = maxTextLength;
    }


    /**
     * Positionne le Pattern de caract�res non autoris�s (ex : [^a-zA-Z0-9] => tout caract�re sauf les les
     * lettres et les chiffres)
     *
     * @param notAllowedCharsPattern Le Pattern de caract�res non autoris�s
     */
    public void setNotAllowedCharsPattern(String notAllowedCharsPattern) {
        this.notAllowedCharsPattern = notAllowedCharsPattern;
    }


    /**
     * Positionne le mode UpperCase
     *
     * @param upperCaseMode True pour passer en mode UpperCase false sinon
     */
    public void setUpperCaseMode(boolean upperCaseMode) {
        this.upperCaseMode = upperCaseMode;
    }


    private class TextDocument extends PlainDocument {
        @Override
        public void insertString(int offs, String str, AttributeSet attributeSet)
              throws BadLocationException {
            if (str == null) {
                return;
            }

            if (maxTextLength != -1) {
                int remainingChars = maxTextLength - TextField.this.getText().length() ;
                str = str.substring(0, Math.min(str.length(), remainingChars));
            }

            String filteredStr;

            if (notAllowedCharsPattern != null) {
                filteredStr = str.replaceAll(notAllowedCharsPattern, "");
            }
            else {
                filteredStr = str;
            }

            if (upperCaseMode) {
                super.insertString(offs, filteredStr.toUpperCase(), attributeSet);
            }
            else {
                super.insertString(offs, filteredStr, attributeSet);
            }
        }
    }
}
