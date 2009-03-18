package uk.co.exahertz.friendlysociety;

import javax.swing.UIManager;
import uk.co.exahertz.friendlysociety.core.Core;
import uk.co.exahertz.friendlysociety.database.MySQL;
import uk.co.exahertz.friendlysociety.gui.LoginScreen;
import java.sql.SQLException;

/**
 * The main class of the application, which includes the main entry point in
 * to the Friendly Society Mortgage application.
 * 
 * @author Niall Scott
 * @version 0.0.1
 * @since 0.0.1
 */
public final class Main {
    /** Major release number of application */
    public final static int VERSIONMAJOR = 0;
    /** Minor release number of application */
    public final static int VERSIONMINOR = 0;
    /** Release revision of application */
    public final static int VERSIONREVISION = 1;
    /** The title of the application */
    public final static String APPLICATIONTITLE = "Friendly Society Mortgage " +
            "System";
    
    /**
     * This constructor does nothing, please do not initialise this class.
     * 
     * @since 0.0.1
     */
    public Main() {
    }
    
    /**
     * The main entry point in to the application
     * 
     * @param args The command line arguments
     * @since 0.0.1
     */
    public static void main(String[] args) {
        if(args.length > 0) {
            if(args[0].trim().toLowerCase().equals("-v")
                    || args[0].trim().toLowerCase().equals("--version"))
            {
                System.out.println(APPLICATIONTITLE);
                System.out.println("Version: " + getVersion());
            } else {
                System.out.println("Incorrect command line parameters.");
            }
        } else {
            try {
                UIManager.setLookAndFeel(
                        UIManager.getSystemLookAndFeelClassName());
                final Core core = new Core(new MySQL());
                javax.swing.SwingUtilities.invokeLater(new Runnable () {
                    public void run() {
                        LoginScreen login = new LoginScreen(core);
                        login.setVisible(true);
                    }
                });
            } catch(ClassNotFoundException e) {
                System.err.println("The MySQL JDBC could not be found. " +
                        "Application exiting.");
                System.exit(0);
            } catch(SQLException e) {
                System.err.println("A MySQL exception has occurred. Error:");
                System.err.println(e.toString());
                System.err.println("Exiting...");
                System.exit(0);
            } catch(Exception e) {
                // Put in debug code
            }
        }
    }
    
    /**
     * Get the version of the application, which is the concatination of the
     * VERSIONMAJOR, VERSIONMINOR and VERSIONREVISION static variables in this
     * class.
     * 
     * @return The version of the program in String form.
     * @since 0.0.1
     */
    public final static String getVersion() {
        return VERSIONMAJOR + "." + VERSIONMINOR + "." + VERSIONREVISION;
    }
}