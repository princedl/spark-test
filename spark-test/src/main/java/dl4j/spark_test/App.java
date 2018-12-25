package dl4j.spark_test;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
 
/**
* Hello world!
*
*/
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.setProperty("hadoop.home.dir", "C:\\Users\\pdl\\Downloads\\bin-master\\");
 
        SparkConf conf = new SparkConf().setAppName("firstSparkProject").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        String path = "linecount.txt";
 
        System.out.println("Trying to open: " + path);
        
        Path p1 = Paths.get(".");
        System.out.println(p1.toAbsolutePath());
        
        JavaRDD<String> lines = sc.textFile(path.toString());
        System.out.println("Lines count: " + lines.count());
        sc.stop();
    }
}