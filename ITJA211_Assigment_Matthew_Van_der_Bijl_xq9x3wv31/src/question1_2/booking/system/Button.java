package question1_2.booking.system;

import java.awt.event.ActionListener;
import java.util.Objects;
import javax.swing.JButton;

/**
 * Custom Button class used in the project.
 *
 * @author Matthew Van der Bijl - xq9x3wv31
 *
 * @see javax.swing.JButton
 * @see java.awt.event.ActionListener
 */
public class Button extends JButton {

    /**
     * The name of the <code>Button</code>. Used to reference the button.
     */
    private final String name;

    /**
     * Default constructor. Used to construct the <code>Button</code>.
     *
     * @param text the text displayed on the button
     * @param name the name of the button
     * @param toolTipText the button's tool tip text
     * @param parent the frame the the button is on
     */
    public Button(String text, String name, String toolTipText, ActionListener parent) {
        super(text);
        this.name = name;

        super.addActionListener(parent);
        super.setToolTipText(toolTipText);
    }

    /**
     * @return the name of the button
     */
    @Override
    public String getName() {
        if (name == null) {
            return super.getName();
        } else {
            return this.name;
        }
    }

    @Override
    public String toString() {
        return "Button[" + getName() + "]";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Button) {
            return ((Button) obj).getName().equals(getName());
        }
        return false;
    }
}
