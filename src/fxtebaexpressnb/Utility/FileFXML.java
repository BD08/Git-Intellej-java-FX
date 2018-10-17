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
    },
    TARIF_LIST_VIEW{
        @Override
        public String toString() {
            return "TarifListView.fxml";
        }
    },
    TARIF_EDIT_VIEW{
        @Override
        public String toString() {
            return "TarifInsertView.fxml";
        }
    },
    TRANSACTION_LIST_VIEW{
        @Override
        public String toString() {
            return "TransactionListView.fxml";
        }
    },
    INSERT_TRANSACTION{
        @Override
        public String toString() {
            return "InsertTransaction.fxml";
        }
    }
}
