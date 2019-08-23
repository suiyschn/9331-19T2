# COMP9313 Revision

+ Content:
        + Introduction
        + Big Data Processes and Management
        + Apache Hadoop and MapReduce
        + Apache Spark
        + Data Curation
        + NoSQL Technologies
        + Elasticsearch
        + Application Scenarios and Use Cases


+ Final Exam:
        + 3 hours, 3 parts


******************** 1. Introduction ********************

## 1.1 3Vs of Big Data (大数据的三个特性)

+ First 3 Vs
	+ Volume, Variety, Velocity (高容量、多类型、高速度)
	+ 数据量大，速度快(批处理), 多样化
+ Another 3 Vs
	+ Veracity, Visibility, Value 
	+ 准确性, 可视性, 合法性


## 1.2 Big Data Processes

+ Data Management
	+ Acquisition and Recording (数据采集与记录)
	+ Extraction, Cleaning and Annotation (数据提取, 清洗, 批注)
	+ Integration, Aggregation and Representation (数据集成)
+ Analytics
	+ Modeling and Analysis
	+ Interpretation
+ Big Data Analytical Techniques
	+ Text, Audio, Video, Social Media and Predictive Analytics

## 1.3 Big Data Technologies Overview

+ Hadoop
	+ Open-source data storage and processing platform
	+ HDFS + Hadoop MapReduce + Hbase (opensource)
		+ HDFS: Hadoop Distributed File System
				Hadoop分布式文件系统
	+ 提供的特性:
		+ Redundant, fault-tolerant data storage (高容错性)
		+ Parallel computation framework (并行计算, 即把文件分块)
		+ Job coordination 
+ Spark	
	+ Spark 解决了Hadoop的很多不足
		+ 传统的Hadoop基于MapReduce方案适用于离线批处理场景，对于实时查询，迭代计算等场景不合适。
		+ MapReduce的局限性:
			+ more suitable for one-pass computation on a large dataset
			+ Hard to compose and nest multiple operations 
			+ No means of expressing iterative operations
		+ 由Hadoop内在局限性决定
			+ All datasets are read from disk, then stored back on to disk 
			+ All data is (usually) triple-replicated for reliability 
			+ Not easy to write MapReduce programs using Java
			+ MapReduce的中间处理结果是放在HDFS系统中的，每次的落地和读取都要消耗大量的时间和资源。(P57)
	+ Spark 特性
		+ Keep more data in-memory
		+ Extend the MapReduce model(迭代计算等)
		+ Enhance programmability(可用python, scala)
	+ Spark Summary:
		+ 通过内存中计算等提高效率
		+ 通过支持Java, Python, Scala的API来提高可用性
		+ Spark使用Hadoop仅仅为了存储的目的
		+ P60看一眼
+ NoSQL
	+ ACID properties: atomicity, consistency, isolation, durability
	  (ACID，是指数据库管理系统在写入或更新资料的过程中，为保证事务是正确可靠的，所必须具备的四个特性：原子性、一致性、隔离性、持久性。 在数据库系统中，一个事务是指：由一系列数据库操作组成的一个完整的逻辑过程。)
	+ Not Only SQL
	+ Does not use SQL as its primary querying language
	+ One or more ACID properties
	+ Non-relational
	+ Do not require strict schema (P63)
	+ Why NoSql
		+ Low and predictable response time (latency) 低延时
		+ Scalability & elasticity (at low cost!) 低成本
		+ High availability 可用性高
		+ Flexible schemas / semi-structured data 模式灵活
		+ multiple datacenters 多个数据中心
+ Elasticsearch
	+ Provides a distributed, full-text search engine with a REST APIs
	+ Document oriented (JSON as serialization format for documents)
	+ Developed in Java (cross platform)
	+ 关键概念: Cluster包含node, node里有index, 
		+ Cluster(集群):
			+ a collection of nodes 
			+ Identified by a unique name
			+ Data is stored in this collection of nodes
			+ Provide indexing and search capabilities across all nodes
		+ Node(结点): 
			+ A single server in the cluster 
			+ Identified by a unique name 
			+ Stores all or parts of the whole dataset 
			+ Contributes to the indexing and search capabilities of Elasticsearch
		+ Index(索引):
			+ Individual instances of Lucene index 
			+ Elasticsearch leverages Lucene indexing in a distributed system
		+ Shard(分片):
			+ Distributed across shards 
			+ Replicas (fault tolerance)
	+ 与数据库类比：
		Relational DB ⇒ Databases ⇒ Tables ⇒ Rows ⇒ Columns
		Elasticsearch ⇒ Indices ⇒ Types ⇒ Documents ⇒ Fields

	+ 集群，一个ES集群由一个或多个节点（Node）组成，每个集群都有一个cluster name作为标识。
	+ 节点，一个节点是你集群中的一个服务器，作为集群的一部分，它存储你的数据，参与集群的索引和搜索功能。
	+ 索引，一个索引就是一个拥有相似特征的文档的集合。比如说，你可以有一个客户数据的索引，另一个产品目录的索引，还有一个订单数据的索引
	+ 分片，一个索引可以存储超出单个结点硬件限制的大量数据。比如，一个具有10亿文档的索引占据1TB的磁盘空间，而任一节点可能没有这样大的磁盘空间来存储或者单个节点处理搜索请求，响应会太慢。为了解决这个问题，Elasticsearch提供了将索引划分成多片的能力，这些片叫做分片。


******************** 2. Big Data Processes and Management ********************

## 2.1 Big Data Processes

+ Acquisition and Storage

+ Extraction, Cleaning and Annotation

+ Integration, Aggregation and Representation

+ Modeling and Analysis

+ Interpretation

## 2.2 Management Challenges

+ Privacy

+ Security

+ Compliance

+ Data Governance

## 2.3 Big Data Management Dos and Don’ts



******************** 3. Apache Hadoop and MapReduce ********************

## 3.1 Hadoop

'HDFS负责分布式存储，MapReduce负责分布式计算' 

+ Basic
	+ 见1.3
+ Hadoop结构(全是Apache家的框架)
	+ HDFS --- 分布式文件系统 --- 存储数据
		+ Runs on commodity hardware (商品硬件上运行)
		+ Horizontally scalable (水平可扩展)
	+ MapReduce --- 核心计算模型 --- 处理数据
		+ Parallelized (scalable) processing
		+ Fault Tolerant
	+ Hive(建立在Hadoop体系架构上的一层SQL抽象)(数据仓库)
	+ Hbase(与HDFS一样属于数据存储层)
	+ P7 图看一眼
+ 关系型数据库与Hadoop对比
	+ P11

## 3.2 MapReduce

'输入文件 ----> 输入分片 ----> Map ----> Combine ----> Shuffle ----> Reduce ----> 输出文件'

+ 为了 parallel data processing

+ Motivation for MapReduce
	+ need for an abstraction that hides many system-level details from the programmer.(底层抽象来掩盖复杂性)
	+ 一般流程:
		• Iterate over a large number of records
		• Extract something of interest from each(MAP)
		• Shuffle and sort intermediate results
		• Aggregate intermediate results
		• Generate final output
+ The Idea of MapReduce
	+ Map ------> a transformation over a dataset
	+ Reduce -------> an aggregation operation 
	+ Map: 数据输入,做初步的处理,输出形式的中间结果；
	+ Shuffle: 按照partition、key对中间结果进行排序合并,输出给reduce线程；
		+ sort: 按键分组传给reducer
	+ Combiner:(可选的) 其实是Reduce的一种。
		+ Combiners are a general mechanism to reduce the amount of intermediate data, thus saving network time
		+ It must have the same output key-value types as the Mapper class
		+ Works only if reduce function is commutative and associative
		+ 本地化Reduce操作
	+ Partitioner
		+ The total number of partitions is the same as the number of reduce tasks for the job.
		+ System uses HashPartitioner by default
		+ Routing pairs of <key,value> to specific partitions
	+ Reduce: 对相同key的输入进行最终的处理,并将结果写入到文件中。(看看P26的例子)
	+ + Map和Reduce的逻辑必须人为来写，sort和shuffle由自带框架自动运行。

+ Data Structures in MapReduce
	+ 基本数据结构：键值对(<Key,value> pairs)
	+ Map transforms the input into key-value pairs to process
	+ Reduce aggregates the list of values for each key

+ Understanding MapReduce
	+ Map和Reduce的逻辑必须人为来写，sort和shuffle由自带框架自动运行。

+ Writable
	+ simple, efficient, serialization protocol
	+ 实现序列化(序列化serialization是指将结构化的对象转为字节流, 便于在网络上传输或写入硬盘)
	+ Hadoop定义的一个类，包括字符串和整数
	+ 在<key, value>里 所有的key必须实现WritableComparable
	+ 所有Writable类都继承自WritableComparable

看一下P48

******************** 4. Apache Spark ********************

## 4.1 Spark

+ Motivation of Spark and Limitations of MapReduce
	+ 见1.3
+ Basic
	+ for large-scale data processing
	+ Written in Scala, with bindings in Java, Python and R
	+ In-memory computing primitives
	+ Rich APIs in Scala, Java, Python, R and Interactive shell
	+ Expressive computing system, 不仅限于MapReduce
	+ Achieve fault-tolerance by re-execution
	+ in-memory system

## 4.2 Introduction to Scala
+ Basic 
	+ 。。没啥东西 跟Java差不多
+ 代码

## 4.3 Introduction to RDDs
+ 主要动机(方便理解)
	+ 迭代算法
	+ 交互式数据挖掘工具
	+ 在分布式计算系统中，数据存储在中间稳定的分布式存储中，
	+ 有效地实现容错，RDD基于粗粒度转换提供限制形式的共享内存
+ Basic
	+ Resilient Distributed Dataset
	+ 一个数据集，并且是分布式的，可以分布在不同机器上，can be cached in memory across cluster 
	+ spark对其提供了丰富的数据操作和容错性
	+ can express many parallel algorithms

+ Trits
	+ In-Memory Rdd中的data一般存储在内存中
	+ Immutable or Read-Only Rdd只能进行变成另一个Rdd, 不可对已生成RDD进行更改
	+ Lazy evaluated 你写了很多转换rdd的代码，但其实是在action后才真正执行(until an action is executed)，提高计算性能
	+ Cacheable
	+ Parallel
	+ Typed
	+ Partitioned 分区后分布到节点上
+ Operations
	+ 就两个 Transformation(转化)和Action(执行)
	+ Transformation
		+ 返回一个新Rdd
		+ 比如创建RDD, map, filter
		+ Use lazy evaluation: Results not computed right away – instead Spark remembers set of transformations applied to base dataset
	+ Action
		+ 返回一个value
		+ 比如collect, count
+ Lineage Graph
	+ 每个RDD都包含了他是如何由其他RDD变换过来的以及如何重建某一块数据的信息。因此RDD的容错机制又称“血统(Lineage)”容错
	+ 定义: RDD Lineage is a graph of all the parent RDDs of a RDD. It is built as a result of applying transformations to the RDD and creates a logical execution plan.
+ SparkContext
	+ entry point to Spark for a Spark application
	+ 创建后就可以进行其他操作如Create RDDs
+ RDD Persistence(Rdd 持久化)
	+ 在 shuffle 操作中（例如 reduceByKey），即便是用户没有调用 persist 方法，Spark 也会自动缓存部分中间数据。这么做的目的是，在 shuffle 的过程中某个节点运行失败时，不需要重新计算所有的输入数据。如果用户想多次使用某个 RDD，强烈推荐在该 RDD 上调用 persist 方法。
	+ 持久化一个RDD到内存中 
	+ each node stores any partitions of it. 每个节点都将参与计算的所有分区数据存储到内存中。
	+ You can reuse it in other actions on that dataset 重复利用哦
	+ 每一个持久化RDD可以使用不同的存储级别
	+ 原因: reduce the data loading cost for further actions on the same data
	+ Spark 自动监控各个节点上的缓存使用率，并以最近最少使用的方式（LRU）将旧数据块移除内存
'可能考P51 试一下'
+ DAG 对计算过程的抽象, RDD是对计算对象的抽象
	+ directed acyclic graph, 有向无环图
	+ 描述了任务执行的拓扑结构，代表了从输入RDD到结果RDD的变换关系。

+ Map vs. FlatMap
	+ ，我们希望对每个输入元素生成多个输出元素。实现该功能的操作叫作 flatMap()。 和 map() 类似，我们提供给 flatMap() 的函数被分别应用到了输入 RDD 的每个元素上。不 过返回的不是一个元素，而是一个返回值序列的迭代器。输出的 RDD倒不是由迭代器组 成的。我们得到的是一个包含各个迭代器可访问的所有元素的 RDD。
	+ map: Returns a new distributed dataset formed by passing each element of the source through a function func
	+ flatMap: Similar to map, but each input item can be mapped to 0 or more output items (so func should return a Seq rather than a single item)


******************** 5. Data Curation ********************

## 5.1 

+ Data curation is the process of identifying which data sources are needed, putting that data in the context of the business so that business users can interact with it, understand it, and use it to create their analysis. (判断哪些data是有用的)

+ 数据质量的维度
	+ Accessibility
	+ Appropriate amount of data
	+ Believability
	+ Completeness
	+ Concise representation
	+ Consistent representation
	+ Ease of manipulation
	+ Free-of-error
	+ Interpretability
	+ Objectivity
	+ Relevancy
	+ Reputation
	+ Security
	+ Timeliness
	+ Understandability
	+ Value-added
+ Ingestion
	+ Obtaining / Importing data from potentially large number of sources
	+ 存储: HDFS, Amazon S3, HBase, etc
	+ Volume, Velocity, Visibility
+ Validation
	+ Is this data valid and does it represent true facts?
	+ Veracity Value
+ Transformation
	+ Variety, Visibility
+ Correction
	+ Any good big data project needs to satisfy certain quality criteria (garbage in -> garbage out)
	+ Veracity
+ Consolidation




******************** 6. NoSQL Technologies ********************

存储数据的时候不使用关系型结构，也就是不使用行列表存储结构。
用于超大规模数据的存储。

## 6.1 Introduction to NoSQL

+ Key Features
	+ non-relational 非关系型
	+ doesn’t require strict schema 无需严谨的表格模式
	+ data are replicated to multiple nodes (so, identical & fault-tolerant) and can be partitioned
	  数据被复制到多个节点，所以有容错性，并且可被分区
	+ down nodes easily replaced
	+ no single point of failure
	+ horizontal scalability
	+ cheap, easy to implement (open-source)
	+ massive write performance
	+ fast key-value access
	+ 总的来说，低延时，低成本，高可扩展性，架构的灵活性，半结构化数据，分布式计算

+ CAP Theorem
	+ 指出对于一个分布式计算系统来说，不可能同时满足以下三点:(最多只能同时较好的满足两个)
		+ Consistency, Availability, Partition-tolerance
		+ 一致性(Consistency) (所有节点在同一时间具有相同的数据)
		+ 可用性(Availability) (保证每个请求不管成功或者失败都有响应)
			System is available during software and hardware upgrades and node failures
		+ 分隔容忍(Partition tolerance) (系统中任意信息的丢失或失败不会影响系统的继续运作)
			A system can continue to operate in the presence of a network partitions.
	+ 因此，根据 CAP 原理将 NoSQL 数据库分成了满足 CA 原则、满足 CP 原则和满足 AP 原则三大类:
		+ CA - 单点集群，满足一致性，可用性的系统，通常在可扩展性上不太强大。
		+ CP - 满足一致性，分区容忍性的系统，通常性能不是特别高。
		+ AP - 满足可用性，分区容忍性的系统，通常可能对一致性要求低一些。

+ BASE
	+ BASE是NoSQL数据库通常对*可用性*及*一致性*的弱要求原则
	+ 两种一致性:
		+ strong consistency – ACID
		+ weak consistency – BASE

+ Consistency Model
	+ A consistency model determines rules for visibility and apparent order of updates

+ Eventual Consistency(最终一致性)
	+ When no updates occur for a long period of time, eventually all updates will propagate through the system and all the nodes will be consistent

+ NoSql 数据库分类
	+ key-value存储
		+ handle massive load 
		+ 可以通过key快速查询到其value。一般来说，存储不管value的格式，照单全收
		+ API 查询 GET, PUT, DELETE等
		+ 优点:
			+ 飞快
			+ 可扩展 very scalable
			+ 简单模型 simple model
			+ 最终一致性 eventual consistancy
			+ 容错性 fault-tolerant
		+ 缺点
			+ 不能建立复杂模型

	+ Column stores 列存储
		+ 按列存储数据的。最大的特点是方便存储结构化和半结构化数据，方便做数据压缩，对针对某一列或者某几列的查询有非常大的IO优势。
		+ Very sparse, most cells have null values
		+ Comparison: RDBMS vs column-based NoSQL
			+ RDBMS: must fetch data from several places on disk and glue together
			  选择(Selection)时即使只涉及某几列，所有数据也都会被读取
			+ Column-based NoSQL: only fetch column families of those columns that are required by a query
			  查询时只有涉及到的列会被读取
	+ Document stores 文档存储
		+ 可以建立复杂模型
		+ Tables: Similar to RDBMS, but handle semi-structured data
	+ Graph databases 图存储
		+ 图形关系的最佳存储
		+ Focus on modeling the structure of data

+ Nosql 优点和缺点
	+ 优点
		+ Massive scalability
		+ High availability 
		+ Lower cost
		+ predictable elasticity 
		+ Schema flexibility, sparse & semi-structured data
	+ 缺点
		+ Doesn’t fully support relational features
		+ Eventual consistency is not intuitive to program for
		+ Not always easy to integrate with other applications that support SQL
		+ Relaxed ACID (see CAP theorem) fewer guarantees

+ Conclusion
	+ NOSQL database cover only a part of dataintensive cloud applications (mainly Web applications)

## 6.2 Introduction to HBase

+ Basic
	+ HBase的数据是存储于HDFS里面的
	+ 分布式的、可伸缩的海量数据存储系统。
	+ HBase常被用来存放一些结构简单，但数据量非常大的数据(通常在TB/PB级别)，如历史订单记录，日志数据，监控Metris数据等等，HBase提供了简单的基于Key值的快速查询能力。
	+ HBase as a schema-less data store, 即, 每一行中，列的组成都是灵活的，行与行之间并不需要遵循相同的列定义.that is, it’s fluid — we can add to, subtract from or modify the schema as you we along
	+ 




































