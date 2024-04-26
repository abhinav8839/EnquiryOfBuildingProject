package Text;

//Importing all the required packages;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 For Writing The Output in the TEXT FILE;
 */
public class TextUtility {

	//writeOutput() method with the string argument to write the output in TEXT FILE;
	public void writeOutput(String output) throws IOException
	{
		
		//Creating a file object for the desired loction; 
		File file = new File("./src/TextOutput/Output.txt");
		
		/*
		 * This while is for deleting the exisiting TEXT Document
		 * and Creating a fresh TEXT Document;
		 */
		while(true)
		{
			if(file.exists())
			{
				file.delete();
			}
			else
			{
				file.createNewFile();
				break;
			}
		}
		if(file.exists())
		{
			FileWriter writer = new FileWriter(file);
			writer.write(output);//Writing the Output to the TEXT Document;
			writer.close();//closing the resource after use;
		}
	}
}
