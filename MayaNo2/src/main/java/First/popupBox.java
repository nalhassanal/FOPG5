package First;

/**
 *
 * @author Hassanal
 */
import javax.swing.JOptionPane;

public class popupBox{

    public popupBox() {
    }
    
    
    public void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
