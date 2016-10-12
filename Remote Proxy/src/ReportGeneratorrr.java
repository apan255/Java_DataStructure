import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReportGeneratorrr extends Remote{

	public String generateDailyReport() throws RemoteException;

}