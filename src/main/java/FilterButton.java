import javax.swing.*;

public class FilterButton extends JButton {
    protected String name;
    protected int buttonID;
    protected ButtonsPanel buttonsPanel;

    public FilterButton(String name, int buttonID, ButtonsPanel buttonsPanel) {
        this.name = name;
        this.setText(name);
        this.buttonID = buttonID;
        this.buttonsPanel = buttonsPanel;
        addAction();
    }

    public void addAction(){
        this.addActionListener( (event) -> {
            try {
                switch (buttonID) {
                    case 1:
                            Filters.Grayscale(buttonsPanel.procesImg);
                        break;
                    case 2:
                        Filters.ColorShiftRight(buttonsPanel.procesImg);
                        break;
                    case 3:

                        Filters.ColorShiftLeft(buttonsPanel.procesImg);
                        break;
                    case 4:
                        Filters.mirror(buttonsPanel.procesImg);

                        break;
                    case 5:
                        Filters.EliminateRed(buttonsPanel.procesImg);
                        break;
                    case 6:
                        Filters.negative(buttonsPanel.procesImg);
                        break;
                    case 7:
                        Filters.contract(buttonsPanel.procesImg);
                        break;
                    case 8:
                        Filters.sepia(buttonsPanel.procesImg);
                        break;
                    case 9:
                        Filters.lighter(buttonsPanel.procesImg);
                        break;
                    case 10:
                        Filters.darker(buttonsPanel.procesImg);
                        break;
                }
            }catch (Exception e){
                error(e);
            }

        });

    }


    private void error (Exception e){
        JOptionPane.showMessageDialog(new JFrame(),
                e.getMessage(),
                "error",
                JOptionPane.PLAIN_MESSAGE);
    }

}
