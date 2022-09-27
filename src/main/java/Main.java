import logic.MainAppCode;

public class Main {
    public static void main(String[] args) throws Exception {
        MainAppCode mainAppCode = new MainAppCode();
        mainAppCode.filesPath("src/main/resources");
        mainAppCode.uniqueParameters();
        mainAppCode.nameBoreholeAndMinMaxAveParameters(10, 30);
        mainAppCode.boreholeToDeposit();
    }
}

