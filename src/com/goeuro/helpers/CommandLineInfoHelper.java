package com.goeuro.helpers;

import java.util.Scanner;

/**
 * Created by hayk on 1/23/15.
 */
public class CommandLineInfoHelper {

	private static Cmd CMD;

	public static Cmd getCMD() {
		if (CMD == null) {
			CMD = new Cmd();
		}
		return CMD;
	}

	public static class Cmd implements AutoCloseable {
		private Scanner scanner;

		public String read(String message) {
			if (scanner == null) {
				scanner = new Scanner(System.in);
			}
			if (message != null) {
				System.out.print(message);
			}
			return scanner.nextLine();
		}

		@Override
		public void close() throws Exception {
			if (scanner != null) {
				scanner.close();
			}
		}
	}
}
