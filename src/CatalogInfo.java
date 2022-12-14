import java.io.File;
import java.util.Arrays;

public class CatalogInfo {
	private static StringBuilder next;
	private static StringBuilder next2;

	public static void listAll(File file) {
		System.out.println(Arrays.deepToString(file.listFiles()));
		for (File item : file.listFiles()) {
			if (item.isDirectory()) {
				System.out.print(item.getName() + "\t [folder] \n");
				System.out.print(">- -- -- -- -> \n");
				next  = new StringBuilder("\t > ");
				listAll(item, next);
			} else {
				System.out.print(item.getName() + "\t [file] \n");
			}
		}
	}

	public static void listAll(File file, StringBuilder next) {
		StringBuilder extra= new StringBuilder(next);
		for (File item : file.listFiles()) {
			if (item.isDirectory()) {
				System.out.print(next.toString() + item.getName() + "\t [folder] \n");
				System.out.print(next.toString() + ">- -- -- -- -> \n");
				next2 = new StringBuilder(extra.insert(0, "\t"));
				listAll(item, next2);
			} else {
				System.out.print(next.toString() + item.getName() + "\t [file] \n");
			}
		}
	}
}
