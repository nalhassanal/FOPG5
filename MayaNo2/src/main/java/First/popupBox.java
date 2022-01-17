package First;

/**
 *
 * @author Hassanal
 */
import javax.swing.JOptionPane;

/**
 *
 * @author Hassanal
 */
public class popupBox{

    /**
     * empty constructor
     */
    public popupBox() {
    }
    
    /**
     * this method/class is responsible of creating a popup window
     * which will halt all processes in the console
     * @param infoMessage - what to show in the body of the popup box
     * @param titleBar - the title of the popup box
     */
    public void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
