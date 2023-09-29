import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class ItemTagsTest {

	@Test
	public void itemTagKeyTest() {
		String key = "one_two_three_four";
		String[] parts = key.split("_");
		String out = String.join("_", Arrays.copyOfRange(parts, 0, parts.length - 1));
		Assertions.assertThat(out).isEqualTo("one_two_three");
	}
}
