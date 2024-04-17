import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;
import com.bnova.techhub.jep462.UserSearcher;


void main()
{
	ExecutorService executor = Executors.newFixedThreadPool(2);

	try (var scope = new StructuredTaskScope.ShutdownOnFailure())
	{
		System.out.println("Starting the search for Tom");
		Supplier<String> tom = scope.fork(UserSearcher::findTom);

		System.out.println("Starting the search for Tim");
		Supplier<String> tim = scope.fork(UserSearcher::findTim);

		System.out.println("Something is running in the background...");

		scope.join()            // Join both subtasks
				.throwIfFailed();  // ... and propagate errors

		System.out.println("Something is running still in the background...");

		String result = tom.get() + ", " + tim.get();
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
