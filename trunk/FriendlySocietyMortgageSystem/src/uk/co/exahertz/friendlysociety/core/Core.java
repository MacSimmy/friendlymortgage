package uk.co.exahertz.friendlysociety.core;

import uk.co.exahertz.friendlysociety.database.*;

public class Core {
    private MortgageDatabase dataSource;
    private StaffMember loggedInAs;

    public Core(final MortgageDatabase dataSource) {
        if(dataSource == null) throw new IllegalArgumentException("The data " +
                "source must not be null.");
        this.dataSource = dataSource;
    }

    /**
     * Log in a member of staff to use the system
     *
     * @param username The username of the member of staff
     * @param password The password of the member of staff
     * @return True if person is now logged in, false if not
     */
    public boolean logIn(final String username, final String password) {
        StaffMember staff = dataSource.getStaffMemberByUsername(username);
        if(staff == null) return false;
        if(staff.isPasswordCorrect(password) && staff.getIsStillWithCompany()) {
            loggedInAs = staff;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Get the StaffMember object of who is logged in to the application
     *
     * @return The StaffMember object of who is logged in to the application,
     * null if nobody is logged in
     * @since 0.0.1
     */
    public StaffMember getLoggedInAs() {
        return loggedInAs;
    }
}