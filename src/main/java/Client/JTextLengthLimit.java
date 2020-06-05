package Client;

import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;
import javax.swing.text.BadLocationException;

class JTextLengthLimit extends PlainDocument {
    private int limit;
    JTextLengthLimit(int limit) {
        super();
        this.limit = limit;
    }

    JTextLengthLimit(int limit, boolean upper) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}


    //textfield1.setDocument(new JTextLengthLimit(10));
