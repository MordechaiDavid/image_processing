import javax.swing.*;
import java.awt.*;

public class AppPanels extends JPanel {
    public final int SCREEN_WIDTH = 1000;
    public final int SCREEN_HEIGHT = 600;
    public final int PANEL_WIDTH = SCREEN_WIDTH / 3;
    public final int ELEMENT_WIDTH = 150;
    public final int ELEMENT_HEIGHT = 50;

    protected ImagePanel origImgPanel;
    protected ImagePanel procImgPanel;
    protected ButtonsPanel buttonsPanel;

    protected Filters filters;

    public AppPanels(){
        // COMPONENTS
        origImgPanel = new ImagePanel(Color.black, PANEL_WIDTH/2 - (ELEMENT_WIDTH/2), 40, ELEMENT_WIDTH, ELEMENT_HEIGHT);

        buttonsPanel = new ButtonsPanel(this, Color.orange, PANEL_WIDTH/2 - (ELEMENT_WIDTH/2));

        procImgPanel = new ImagePanel(Color.black, PANEL_WIDTH/2 - (ELEMENT_WIDTH/2), 40, ELEMENT_WIDTH, ELEMENT_HEIGHT);

        this.add(origImgPanel);
        this.add(buttonsPanel);
        this.add(procImgPanel);

        this.filters = new Filters(this);

        this.setLayout(new GridLayout(0,3));
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
    }
}
