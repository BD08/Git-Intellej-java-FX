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
        
    },
    CUSTOMER_LIST_VIEW{
        @Override
        public String toString() {
            return "CustomerListView.fxml";
        }
    },
    CUSTOMER_UPDATE_VIEW{
        @Override
        public String toString() {
            return "InsertCustomerView.fxml";
        }
    }
//    private static String fileData="../View/";
//    public static String DASHBOARDFILE=fileData+"dashBoard.fxml";
}
