import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import java.io._

import scala.xml.XML
import scala.collection.mutable.ListBuffer
import scala.collection.mutable.Set
import scalaj.http.{Http, HttpOptions}
import play.api.libs.json._

// test file

object CaseIndex {
  def main(args: Array[String]): Unit = {

       val index_result = Http("http://localhost:9200/legal_idx")
         .header("Content-Type", "application/json")
         .method("PUT")
         .option(HttpOptions.readTimeout(10000))
         .asString
    
       val type_and_mapping_result = Http("http://localhost:9200/legal_idx/cases/_mapping?pretty")
         .postData("""{
                      	"cases":{
                      		"properties":{
                      			"person":{
                      				"type":"text"
                     			},
                     			"location":{
                     				"type":"text"
                     			},
                     			"organization":{
                     				"type":"text"
                     			}
                           "name":{
                      				"type":"text"
                     			}
                           "sentence":{
                     				"type":"text"
                     			}
                           "catchphrase":{
                     				"type":"text"
                     			}
                           "id":{
                     				"type":"text"
                     			}
                     		}
                     	}
                       }""")
         .header("Content-Type", "application/json")
         .method("PUT")
         .option(HttpOptions.readTimeout(10000))
         .asString
    // create an index
    

  }
}