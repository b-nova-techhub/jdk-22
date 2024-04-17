import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import com.bnova.techhub.jep462.UserSearcher;


void main()
{
	ExecutorService executor = Executors.newFixedThreadPool(2);

	try
	{
		System.out.println("Starting the search for Tom");
		Future<String> futureTom = executor.submit(UserSearcher::findTom);

		System.out.println("Starting the search for Tim");
		Future<String> futureTim = executor.submit(UserSearcher::findTim);

		System.out.println("Something is running in the background...");

		String result = futureTom.get() + ", " + futureTim.get();

		System.out.println(result);
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		executor.shutdown();
	}
}
