/**
 * Clase correspondiente a la ventana de ingreso
 * de puntaje de jugadores.
 * 
 * @author Bonino, Francisco Ignacio.
 * 
 * @version 1.0.0
 * 
 * @since 06/03/2021
 */

import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import net.miginfocom.swing.MigLayout;

@SuppressWarnings("serial")
public class RatingFrame extends JFrame {

    // Campos privados.
    private JPanel masterPanel, centerPanel, southPanel;
    private JButton finishButton, cancelButton;
    private HashMap<Player, JSpinner> spinnersMap; // Mapa que asocia a cada jugador un JSpinner.

    /**
     * Creación de la ventana de ingreso de puntajes.
     */
    public RatingFrame() {
        centerPanel = new JPanel(new MigLayout("wrap 4"));
        southPanel = new JPanel(new MigLayout("wrap"));
        masterPanel = new JPanel(new MigLayout());

        finishButton = new JButton("Finalizar");
        cancelButton = new JButton("Cancelar");

        spinnersMap = new HashMap<>();

        for (Player[] playersSet : InputFrame.playersSets) {
            centerPanel.add(new JLabel(playersSet[0].getPosition().toString()), "span");
            centerPanel.add(new JSeparator(JSeparator.HORIZONTAL), "growx, span");

            for (Player player : playersSet) {
                spinnersMap.put(player, new JSpinner(new SpinnerNumberModel(1, 1, 5, 1)));

                centerPanel.add(new JLabel(player.getName()));
                centerPanel.add(spinnersMap.get(player));
            }
        }

        southPanel.add(finishButton, "span");
        southPanel.add(cancelButton, "span");

        masterPanel.add(southPanel, "south");
        masterPanel.add(centerPanel, "center, span");

        add(masterPanel);
        setResizable(false);
        setTitle("Puntuaciones");
        setIconImage(MainFrame.iconBall.getImage());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }
}