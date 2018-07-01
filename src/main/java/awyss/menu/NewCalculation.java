package awyss.menu;

import javax.swing.*;

public class NewCalculation {

    private static void createAndShowGUI() {

        JFrame frame = new JFrame( "Nowa Kalkulacja" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 900,900 );

        frame.pack();
        frame.setVisible( true );


    }
    public static void main( String[] args ) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });

    }
}
