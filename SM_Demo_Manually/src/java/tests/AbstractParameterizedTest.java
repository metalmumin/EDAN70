package tests;

import java.io.File;
import java.util.Collection;
import java.util.LinkedList;

/**
 * A parameterized test suite. Adds helper methods for
 * parameterized testing.
 */
abstract public class AbstractParameterizedTest extends AbstractTestSuite {

	/**
	 * File extension for test input files. EDIT ME
	 */
	protected static final String IN_EXTENSION = ".lang";
	/**
	 * File extension for expected test output
	 */
	private static final String EXPECTED_EXTENSION = ".expected";

	protected final File inFile;
	protected final File expectedFile;

	/**
	 * @param testDirectory
	 * @param testFile
	 */
	public AbstractParameterizedTest(String testDirectory, String testFile) {
		super(testDirectory);
		inFile = getTestInputFile(testFile);
		expectedFile = getTestExpectedOutputFile(testFile);
	}

	protected File getTestInputFile(String filename) {
		return new File(testDirectory, filename);
	}

	protected File getTestExpectedOutputFile(String filename) {
		String simpleName = filename.substring(0,
			filename.length()-IN_EXTENSION.length());
		return new File(testDirectory, simpleName+EXPECTED_EXTENSION);
	}

	@SuppressWarnings("javadoc")
	public static Iterable<Object[]> getTestParameters(String testDirectory) {
		Collection<Object[]> tests = new LinkedList<Object[]>();
		File testDir = new File(testDirectory);
		if (!testDir.isDirectory()) {
			throw new Error("Could not find '" + testDirectory + "' directory!");
		}
		for (File f: testDir.listFiles()) {
			if (f.getName().endsWith(IN_EXTENSION)) {
				tests.add(new Object[] {f.getName()});
			}
		}
		return tests;
	}
}
