package uk.co.exahertz.friendlysociety;

import javax.swing.UIManager;

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