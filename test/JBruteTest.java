import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;

import javax.xml.crypto.AlgorithmMethod;

import org.junit.Before;
import org.junit.Test;

import controller.JBrute;


public class JBruteTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@Test
	public void test1(){
		File f = new File(".pandoras.box");
		String [] args = {"--encrypt", "--word=hola", "--algorithm=6"};
		String [] args2 = {"--decrypt", "--method=brute", "--algorithm=6", 
		"--hash=e83e8535d6f689493e5819bd60aa3e5fdcba940e6d111ab6fb5c34f24f86496bf3726e2bf4ec59d6d2f5a2aeb1e4f103283e7d64e4f49c03b4c4725cb361e773"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}
		JBrute.main(args2);

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}

	@Test
	public void test2(){
		File f = new File(".pandoras.box");
		String [] args = {"--encrypt", "--word=hola", "--algorithm=19"};
		String [] args2 = {"--decrypt", "--method=brute", "--algorithm=19", 
		"--hash=37d2de01465e1b56cb88b65d136f1a94"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}
		JBrute.main(args2);

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}


	@Test
	public void test3(){
		File f = new File(".pandoras.box");
		String [] args = {"--encrypt", "--word=hola" ,"--algorithm=191", "--chained_case=UU"};
		String [] args2 = {"--decrypt", "--method=brute", "--algorithm=191", "--chained_case=UU",
		"--hash=ddd43ffd082131ba706eeecdea73d066"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}
		JBrute.main(args2);

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}

	@Test
	public void test4(){
		File f = new File(".pandoras.box");
		String [] args = {"--encrypt", "--word=hola", "--algorithm=19", "--chained_case=U"};
		String [] args2 = {"--decrypt", "--method=brute", "--algorithm=19", "--chained_case=U",
		"--hash=f60d814e1738622b5d3e3b4fc03f72a1"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}
		JBrute.main(args2);

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}


	@Test
	public void test5(){
		File f = new File(".pandoras.box");
		String [] args = {"--encrypt", "--word=hola", "--algorithm=19", "--chained_case=R"};
		String [] args2 = {"--decrypt", "--method=brute", "--algorithm=19", "--chained_case=R",
		"--hash=8d08ccc440b0fec48007d9ed925448bb"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}
		JBrute.main(args2);

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}


	@Test
	public void test6(){
		File f = new File(".pandoras.box");
		String [] args = {"--encrypt", "--word=hola", "--algorithm=19", "--chained_case=R", 
		"--upper"};
		String [] args2 = {"--decrypt", "--method=brute", "--algorithm=19", "--chained_case=R",
		"--hash=8D08CCC440B0FEC48007D9ED925448BB"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}
		JBrute.main(args2);

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}


	@Test
	public void test7(){
		File f = new File(".pandoras.box");
		String [] args = {"--encrypt", "--word=hola" ,"--algorithm=1"};
		String [] args2 = {"--decrypt", "--method=brute", "--algorithm=1", 
		"--hash=4d186321c1a7f0f354b297e8914ab240"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}
		JBrute.main(args2);

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}
		
		if(f.exists()){
			f.delete();
		}
		
		outContent.reset();
	}



	@Test
	public void test8(){
		File f = new File(".pandoras.box");
		String [] args = {"--decrypt", "--method=brute", "--algorithm=1", "--hash=4d186321c1a7f0f354b297e8914ab240", "--minlength=3", "--maxlength=5"};
		JBrute.main(args);
		if(f.exists()){
			f.delete();
		}

		String output=outContent.toString();
		if(!output.contains("--> hola")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}

	@Test
	public void test9(){
		File f = new File(".pandoras.box");
		String [] args = {"--test", "--algorithm=9", "--threads=2"};

		JBrute.main(args);
	
		String output=outContent.toString();
		if(!output.contains("Benchmarking")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}
	
	@Test
	public void test10(){
		File f = new File(".pandoras.box");
		String [] args = {"--test", "--algorithm=9", "--threads=2"};

		JBrute.main(args);
	
		String output=outContent.toString();
		if(!output.contains("Benchmarking")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}
	
	@Test
	public void test11(){
		File f = new File(".pandoras.box");
		String [] args = {"--guess", "--lucky", "--hash=4d186321c1a7f0f354b297e8914ab240"};

		JBrute.main(args);
	
		String output=outContent.toString();
		if(!output.contains("MD5")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}
	
	@Test
	public void test12(){
		File f = new File(".pandoras.box");
		String [] args = {"--guess", "--lucky", "--hash=4d186321c1a7f0f354b297e8914ab240"};

		JBrute.main(args);
	
		String output=outContent.toString();
		if(!output.contains("MD5")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}
	
	@Test
	public void test13(){
		File f = new File(".pandoras.box");
		String [] args = {"--help"};

		JBrute.main(args);
	
		String output=outContent.toString();
		if(!output.contains("Available parameters:")){
			fail("Failed to decrypt");
		}

		outContent.reset();
	}
	
	@Test
	public void test14(){
		File f = new File(".pandoras.box");
		
		int i = 0;
		String[] algorithm = {"--algorithm=1","--algorithm=2","--algorithm=5","--algorithm=6",
				"--algorithm=9","--algorithm=C",
				"--algorithm=D","--algorithm=E","--algorithm=F","--algorithm=G","--algorithm=H",
				"--algorithm=I","--algorithm=I","--algorithm=K","--algorithm=L"};
		
		if(f.exists()){
			f.delete();
		}
		
			while(i < algorithm.length){
			String [] args = {"--encrypt", "--word=hola", algorithm[i]};
			JBrute.main(args);
			
			String output=outContent.toString();
			int index = output.lastIndexOf(":");
			String hash = output.substring(index + 1, output.length()).trim();
			
			if(f.exists()){
				f.delete();
			}
			
			String [] args2 = {"--decrypt", "--method=brute", algorithm[i], "--hash=" + hash};
			JBrute.main(args2);
			
			output=outContent.toString();
			if(!output.contains("--> hola")){
				fail("Failed to decrypt");
			}
			
			outContent.reset();
			i++;
		}
	}
	
	@Test

	public void test15(){

	File f = new File(".pandoras.box");

	String [] args = {"--encrypt", "--word=hola", "--presalt=harsh","--algorithm=1"};

	String [] args2 = {"--decrypt", "--method=brute", "--presalt=harsh","--algorithm=1", 

	"--hash=5755061c841f3d67f04a23dc0e4e9a93"};

	JBrute.main(args);

	if(f.exists()){

	f.delete();

	}

	JBrute.main(args2);



	String output=outContent.toString();

	if(!output.contains("--> hola")){

	fail("Failed to decrypt");

	}



	outContent.reset();

	}




	@Test

	public void test19(){

	File f = new File(".pandoras.box");

	String [] args = {"--encrypt", "--word=hola","--threads=2", "--presalt=harsh","--algorithm=6"};

	String [] args2 = {"--decrypt", "--method=brute", "--presalt=harsh","--algorithm=1", 

	"--hash=5755061c841f3d67f04a23dc0e4e9a93"};

	JBrute.main(args2);

//		 if(f.exists()){

//		 f.delete();

//		 }

//		 JBrute.main(args2);

	//

//		 String output=outContent.toString();

//		 if(!output.contains("--> hola")){

//		 fail("Failed to decrypt");

//		 }



	outContent.reset();

	}


	@Test

	public void test16(){

	File f = new File(".pandoras.box");

	String [] args = {"--encrypt", "--word=hola", "--postsalt=harsh","--algorithm=6"};

	String [] args2 = {"--decrypt", "--method=brute", "--postsalt=harsh","--algorithm=6", 

	"--hash=22178733a15b1106b0f411c412ca674523fb300185f42e9eaa50e5c85efe4a5e5f82d9be1009db380de1310e93553345fb308ccebb86aa7cb070c39150c5ee64"};

	JBrute.main(args);


	if(f.exists()){

	f.delete();

	}

	JBrute.main(args2);



	String output=outContent.toString();

	if(!output.contains("--> hola")){

	fail("Failed to decrypt");

	}



	outContent.reset();

	}


	@Test

	public void test17(){

	File f = new File(".pandoras.box");

	String [] args = {"--encrypt", "--word=hola", "--salt_type=hex","--postsalt=15AB","--algorithm=6"};

	String [] args2 = {"--decrypt", "--method=brute", "--salt_type=hex","--postsalt=15AB","--algorithm=6", 

	"--hash=54dd062b7eb252796554209bc5490b3b9039e7ccd5d7182bd4f05ed4906b35577af25091d403c05493dfd4d41a5b5417565483f06a6082e1ac0afb46231f7022"};

	JBrute.main(args);


	if(f.exists()){

	f.delete();

	}

	JBrute.main(args2);



	String output=outContent.toString();

	if(!output.contains("--> hola")){

	fail("Failed to decrypt");

	}



	outContent.reset();

	}


	@Test

	public void test18(){

	File f = new File(".pandoras.box");

	String [] args = {"--encrypt", "--word=hola", "--salt_type=int64","--postsalt=1234","--algorithm=6"};

	String [] args2 = {"--decrypt", "--method=brute", "--salt_type=int64","--postsalt=1234","--algorithm=6", 

	"--hash=3b84d2ab3526c0685ccc894303657556eb0c46edcfcf7d46fbe067594b0a3cb9c3f6c65350fba625151509a8531bb92d21562f9cf533d6d88c007d477421d24d"};

	JBrute.main(args);


	if(f.exists()){

	f.delete();

	}

	JBrute.main(args2);



	String output=outContent.toString();

	if(!output.contains("--> hola")){

	fail("Failed to decrypt");

	}



	outContent.reset();

	}
}
