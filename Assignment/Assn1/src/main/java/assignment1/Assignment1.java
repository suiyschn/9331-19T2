package assignment1;

import java.util.*;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import javax.lang.model.type.ArrayType;

/**
 *
 * This class solves the problem posed for Assignment1
 *
 */

public class Assignment1 {

    public static class Map extends Mapper<Object, Text, Text, Text>{
        private Text valueStr = new Text();
        private Text keyStr = new Text();
        private FileSplit fileSplit;

        public void map(Object key, Text value, Context context) throws IOException, InterruptedException{
            fileSplit = (FileSplit)context.getInputSplit();
            Configuration conf = context.getConfiguration();
            String valueN = conf.get("valueN");
            // Get configuration information form main class.

            int n = Integer.parseInt(valueN);
            String sentence = value.toString();
            String filePath = fileSplit.getPath().getName();
            // Get all the information from the file which map is dealing with, and the file name.

            String[] parts = sentence.split(" ");
            // Split every single word.

            String[] result = new String[parts.length - n + 1];
            // Set a list to store ngram.
            for(int i = 0; i < parts.length - n + 1; i++) {
                StringBuilder sb = new StringBuilder();
                int j = 0;
                do {
                    if(j > 0) sb.append(' ');
                    sb.append(parts[i+j]);
                    j++;
                }while (j < n);
                result[i] = sb.toString();
            }
            // Get the ngram by a double loop algorithm

            for (String ngram : result){
                keyStr.set(ngram);
                valueStr.set(filePath);
                context.write(keyStr, valueStr);
            }
            // Set <key:ngram, value:filepath> to context, pass to reducer
        }
    }

    public static class Reduce extends Reducer<Text,Text,Text,Text>{
        Text newValue = new Text();
        public void reduce(Text key,Iterable<Text> values,Context context) throws IOException, InterruptedException{
            int sum = 0;
            Configuration conf = context.getConfiguration();
            String mincount = conf.get("mincount");
            int min = Integer.parseInt(mincount);
            // Get configuration information form main class.

            String files = "";
            for(Text value:values){
                files += value+" ";
                sum += 1;
            }
            // Add up the times of same ngram shown up.
            if (sum >= min){
                newValue.set(sum+"  "+files);
                context.write(key,newValue);
            }
            // If it meet the requirements of minimum times then set it to context

        }
    }

    public static void main(String[] args) throws Exception {
        Configuration conf = new Configuration();

        conf.set("valueN", args[0]);
        conf.set("mincount", args[1]);
        // Set the parameters

        Job job = new Job(conf, "ngrams");
        // Set the job name
        job.setJarByClass(Assignment1.class);
        job.setMapperClass(Map.class);
        job.setReducerClass(Reduce.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        // Set mapreduce class
        FileInputFormat.addInputPath(job, new Path(args[2]));
        FileOutputFormat.setOutputPath(job, new Path(args[3]));
        // Set file input/output parameters
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}