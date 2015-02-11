package tests;

import static org.junit.Assert.fail;
import lang.ast.ErrorMessage;
import lang.ast.Program;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests name analysis
 */
@RunWith(Parameterized.class)
public class ShowErrors extends AbstractParameterizedTest {
	/**
	 * Directory where test files live
	 */
	private static final String TEST_DIR = "testfiles";

	/**
	 * Construct a new JastAdd test
	 * @param filename filename of test input file
	 */
	public ShowErrors(String filename) {
		super(TEST_DIR, filename);
	}
	/**
	 * Run the JastAdd test
	 */
	@Test
	public void runTest() {
		try {
			Program program = (Program) parse(inFile);
			StringBuilder sb = new StringBuilder();
			for (ErrorMessage m: program.errors()) {
				sb.append(m).append("\n");
			}
			compareOutput(sb.toString(), expectedFile);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@SuppressWarnings("javadoc")
	@Parameters(name = "{0}")
	public static Iterable<Object[]> getTests() {
		return getTestParameters(TEST_DIR);
	}
}
