import java.rmi.Naming;

public class ReportGeneratorClient {

	public static void main(String[] args) {
		new ReportGeneratorClient().generateReport();
	}

	public void generateReport(){
		try {
		 ReportGeneratorrr reportGenerator = (ReportGeneratorrr)Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");
		
		//	ReportGeneratorrr reportGenerator = (ReportGeneratorrr)Naming.lookup("C:\\Users\\Anku\\workspace\\Remote Proxy\\clientReport.txt");

			//	ReportGeneratorrr reportGenerator = (ReportGeneratorrr)Naming.lookup("rmi://127.0.0.1/PizzaCoRemoteGenerator");

			System.out.println(reportGenerator.generateDailyReport());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}