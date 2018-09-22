package fxtebaexpressnb.Utility;

public enum FileFXML {
    DASHBOARDFILE{
        @Override
        public String toString() {
            return "DashboardView.fxml";
        }
    },
    USER_ACCOUNT_CREATE_EDIT_VIEW{
        @Override
        public String toString() {
            return "InsertUserAccountView.fxml";
        }
    },
    USER_ACCOUNT_LIST_VIEW{
        @Override
        public String toString() {
	        return "UserAccountList.fxml"; //To change body of generated methods, choose Tools | Templates.
        }
        
    }
//    private static String fileData="../View/";
//    public static String DASHBOARDFILE=fileData+"dashBoard.fxml";
}
