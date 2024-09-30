import io.intino.legio2maven.Legio2Maven;
import org.junit.Test;

public class Legio2MavenTest {

	@Test
	public void testProject() {
		Legio2Maven.main(new String[]{"/Users/oroncal/workspace/infrastructure/archetype", null});
	}
}
