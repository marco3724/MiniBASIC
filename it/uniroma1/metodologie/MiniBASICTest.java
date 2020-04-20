package it.uniroma1.metodologie;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Nota bene: questo codice non deve essere in nessun modo modificato
 * 
 * @author navigli
 * @author fabiano
 */
class MiniBASICTest
{
	@ParameterizedTest
	@ValueSource(strings = {"prg/28/successione", "prg/28/fibonacci", "prg/full/prg1", "prg/full/fibonacci", "prg/full/pari_dispari", "prg/full/ordina"})
	public void test(String filename)
	{
		System.out.println("Test " + filename);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		try
		{
			Programma p = Programma.fromFile(filename + ".bas");
			new MiniBASIC().esegui(p);

			assertEquals(Files.readString(Paths.get(filename + ".out")).replaceAll("\r", ""), baos.toString().replaceAll("\r", ""));
		}
		catch(Exception e)
		{
			e.printStackTrace();
			fail();
		}
		finally
		{
			System.out.flush();
			System.setOut(old);
		}
		System.out.println("Success.");
	}
}
