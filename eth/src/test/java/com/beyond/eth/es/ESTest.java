package com.beyond.eth.es;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.aspectj.lang.annotation.Before;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.adjacency.AdjacencyMatrix.Bucket;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.aggregations.metrics.sum.Sum;
import org.elasticsearch.search.sort.SortOrder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;



/**
 * 需要从官网确定ES版本对应的客户端jar包
 * 
 * @author yx
 *
 */
public class ESTest {
	TransportClient client;
	// 索引库名
	String index = "my_index";
	// 类型名称
	String type = "stu";

	@Before(value = "1")
	@SuppressWarnings("resource")
	public void before() throws UnknownHostException {

		// 客户端创建 方式1
		Settings settings = Settings.builder().put("cluster.name", "my-application_ppp").put("client.transport.sniff", "true")// 客户端可以嗅到集群的其它部分
				.build();
		TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));

		// 客户端创建 方式2
		// TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
		// .addTransportAddress(new
		// InetSocketTransportAddress(InetAddress.getByName("host1"), 9300))
		// .addTransportAddress(new
		// InetSocketTransportAddress(InetAddress.getByName("host2"), 9300));
		System.out.println("连接信息:" + client.toString());
		/**
		 * 3：查看集群信息 注意我的集群结构是： 131的elasticsearch.yml中指定为主节点不能存储数据，
		 * 128的elasticsearch.yml中指定不为主节点只能存储数据。 所有控制台只打印了192.168.79.128,只能获取数据节点
		 * 
		 */
		List<DiscoveryNode> connectedNodes = client.connectedNodes();
		for (DiscoveryNode node : connectedNodes) {
			System.out.println("===========" + node.getHostAddress());
		}

	}

	/**
	 * 创建索引-传入Map对象
	 */
	// @Test
	public void addIndex3() {
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("userName", "张三");
			map.put("sendDate", new Date());
			map.put("msg", "你好李四");
			IndexResponse response = client.prepareIndex(index, "tweet").setSource(map).get();
			System.out.println("map索引名称:" + response.getIndex() + "\n map类型:" + response.getType() + "\n map文档ID:" + response.getId() + "\n当前实例map状态:" + response.status());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加索引:传入json字符串
	 * 
	 * @Title: addIndex2
	 * @author sunt
	 * @date 2017年11月23日
	 * @return void
	 */
	@Test
	public void addIndex2() {
		String jsonStr = "{" + "\"userName\":\"张三\"," + "\"sendDate\":\"2017-11-30\"," + "\"msg\":\"你好李四\"" + "}";
		IndexResponse response = client.prepareIndex("weixin", "tweet").setSource(jsonStr, XContentType.JSON).get();
		System.out.println("json索引名称:" + response.getIndex() + "\njson类型:" + response.getType() + "\njson文档ID:" + response.getId() + "\n当前实例json状态:" + response.status());
	}

	/**
	 * 传递json对象 需要添加依赖:gson
	 * 
	 * @Title: addIndex4
	 * @author sunt
	 * @date 2017年11月23日
	 * @return void
	 */
	// @Test
	// public void addIndex4() {
	// jso
	// JsonObject jsonObject = new JsonObject();
	// jsonObject.addProperty("userName", "张三");
	// jsonObject.addProperty("sendDate", "2017-11-23");
	// jsonObject.addProperty("msg", "你好李四");
	//
	// IndexResponse response = client.prepareIndex("qq",
	// "tweet").setSource(jsonObject, XContentType.JSON).get();
	//
	// System.out.println("jsonObject索引名称:" + response.getIndex() + "\n
	// jsonObject类型:" + response.getType() + "\n jsonObject文档ID:" +
	// response.getId() + "\n当前实例jsonObject状态:" + response.status());
	// }

	/**
	 * 从索引库获取数据
	 * 
	 * @Title: getData1
	 * @date 2017年11月23日
	 * @return void
	 */
	@Test
	public void getData1() {
		GetResponse getResponse = client.prepareGet("msg", "tweet", "1").get();
		System.out.println("索引库的数据:" + getResponse.getSourceAsString());
	}

	/**
	 * 更新索引库数据
	 * 
	 * @Title: updateData
	 * @date 2017年11月23日
	 * @return void
	 */
	// @Test
	// public void updateData() {
	// JsonObject jsonObject = new JsonObject();
	//
	// jsonObject.addProperty("userName", "王五");
	// jsonObject.addProperty("sendDate", "2008-08-08");
	// jsonObject.addProperty("msg","你好,张三，好久不见");
	//
	// UpdateResponse updateResponse = client.prepareUpdate("msg", "tweet", "1")
	// .setDoc(jsonObject.toString(),XContentType.JSON).get();
	//
	// logger.info("updateResponse索引名称:" + updateResponse.getIndex() + "\n
	// updateResponse类型:" + updateResponse.getType()
	// + "\n updateResponse文档ID:" + updateResponse.getId() +
	// "\n当前实例updateResponse状态:" + updateResponse.status());
	// }

	/**
	 * 根据索引名称，类别，文档ID 删除索引库的数据
	 * 
	 * @Title: deleteData
	 * @author sunt
	 * @date 2017年11月23日
	 * @return void
	 */
	@Test
	public void deleteData() {
		DeleteResponse deleteResponse = client.prepareDelete("msg", "tweet", "1").get();

		System.out.println("deleteResponse索引名称:" + deleteResponse.getIndex() + "\n deleteResponse类型:" + deleteResponse.getType() + "\n deleteResponse文档ID:" + deleteResponse.getId()
				+ "\n当前实例deleteResponse状态:" + deleteResponse.status());
	}

	/**
	 * 通过prepareIndex增加文档，参数为javaBean
	 * 
	 * @throws ElasticsearchException
	 * @throws JsonProcessingException
	 */
//	@Test
//	public void testIndexBean() throws ElasticsearchException, JsonProcessingException {
//		User stu = new User();
//		stu.setUserId("2001");
//		stu.setUserName("zhangsan");
//		stu.setAge("26");
//		// 对象转json
//		ObjectMapper mapper = new ObjectMapper();
//		IndexResponse indexResponse = client.prepareIndex(index, type, "5").setSource(mapper.writeValueAsString(stu)).get();
//		System.out.println(indexResponse.getVersion());
//	}

	/**
	 * 通过prepareIndex增加文档，参数为XContentBuilder
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@Test
	public void testIndexXContentBuilder() throws IOException, InterruptedException, ExecutionException {
		XContentBuilder builder = XContentFactory.jsonBuilder().startObject().field("name", "Avivi").field("age", 30).endObject();
		IndexResponse indexResponse = client.prepareIndex(index, type, "6").setSource(builder).execute().get();
		// .execute().get();和get()效果一样
		System.out.println(indexResponse.getVersion());
	}

	/**
	 * 通过prepareDelete删除文档
	 * 
	 */
	@Test
	public void testDelete() {
		String id = "9";
		DeleteResponse deleteResponse = client.prepareDelete(index, type, id).get();
		System.out.println(deleteResponse.getVersion());
		// 删除所有记录
		// TODO
		// client.prepareDeleteByQuery(index).setTypes(type).setQuery(QueryBuilders.matchAllQuery()).get();
	}

	/**
	 * 删除索引库，不可逆慎用
	 */
	// @Test
	public void testDeleteeIndex() {
		client.admin().indices().prepareDelete("shb01", "shb02").get();
	}

	/**
	 * 求索引库文档总数
	 */

	// @Test
	public void testCount() {
		// TODO
		// long count = client.prepareCount(index).get().getCount();
		System.out.println("-----");
	}

	/**
	 * 通过prepareBulk执行批处理
	 * 
	 * @throws IOException
	 */
	@Test
	public void testBulk() throws IOException {
		// 1:生成bulk
		BulkRequestBuilder bulk = client.prepareBulk();

		// 2:新增
		IndexRequest add = new IndexRequest(index, type, "10");
		add.source(XContentFactory.jsonBuilder().startObject().field("name", "Henrry").field("age", 30).endObject());

		// 3:删除
		DeleteRequest del = new DeleteRequest(index, type, "1");

		// 4:修改
		XContentBuilder source = XContentFactory.jsonBuilder().startObject().field("name", "jack_1").field("age", 19).endObject();
		UpdateRequest update = new UpdateRequest(index, type, "2");
		update.doc(source);

		bulk.add(del);
		bulk.add(add);
		bulk.add(update);
		// 5:执行批处理
		BulkResponse bulkResponse = bulk.get();
		if (bulkResponse.hasFailures()) {
			BulkItemResponse[] items = bulkResponse.getItems();
			for (BulkItemResponse item : items) {
				System.out.println(item.getFailureMessage());
			}
		} else {
			System.out.println("全部执行成功！");
		}
	}

	/**
	 * 通过prepareSearch查询索引库 setQuery(QueryBuilders.matchQuery("name", "jack"))
	 * setSearchType(SearchType.QUERY_THEN_FETCH)
	 * 
	 */
	@Test
	public void testSearch() {
		SearchResponse searchResponse = client.prepareSearch(index).setTypes(type).setQuery(QueryBuilders.matchAllQuery()) // 查询所有
				// .setQuery(QueryBuilders.matchQuery("name",
				// "tom").operator(Operator.AND)) //根据tom分词查询name,默认or
				// .setQuery(QueryBuilders.multiMatchQuery("tom", "name",
				// "age")) //指定查询的字段
				// .setQuery(QueryBuilders.queryString("name:to* AND age:[0 TO
				// 19]")) //根据条件查询,支持通配符大于等于0小于等于19
				// .setQuery(QueryBuilders.termQuery("name", "tom"))//查询时不分词
				.setSearchType(SearchType.QUERY_THEN_FETCH).setFrom(0).setSize(10)// 分页
				.addSort("age", SortOrder.DESC)// 排序
				.get();

		SearchHits hits = searchResponse.getHits();
		long total = hits.getTotalHits();
		System.out.println(total);
		SearchHit[] searchHits = hits.getHits();
		for (SearchHit s : searchHits) {
			System.out.println(s.getSourceAsString());
		}
	}

	/**
	 * 多索引，多类型查询 timeout
	 */
	@Test
	public void testSearchsAndTimeout() {

		SearchResponse searchResponse = client.prepareSearch("shb01", "shb02").setTypes("stu", "tea").setQuery(QueryBuilders.matchAllQuery()).setSearchType(SearchType.QUERY_THEN_FETCH)
				// .setTimeout("3")
				.get();

		SearchHits hits = searchResponse.getHits();
		long totalHits = hits.getTotalHits();
		System.out.println(totalHits);
		SearchHit[] hits2 = hits.getHits();
		for (SearchHit h : hits2) {
			System.out.println(h.getSourceAsString());
		}
	}

	/**
	 * 分组
	 */
	@Test
	public void testGroupBy() {
		SearchResponse searchResponse = client.prepareSearch(index).setTypes(type).setQuery(QueryBuilders.matchAllQuery()).setSearchType(SearchType.QUERY_THEN_FETCH)
				.addAggregation(AggregationBuilders.terms("group_age").field("age").size(0))// 根据age分组，默认返回10，size(0)也是10
				.get();

		Terms terms = searchResponse.getAggregations().get("group_age");
		List<Bucket> buckets = (List<Bucket>) terms.getBuckets();
		for (Bucket bt : buckets) {
			System.out.println(bt.getKey() + " " + bt.getDocCount());
		}
	}

	/**
	 * 聚合函数,本例之编写了sum，其他的聚合函数也可以实现
	 * 
	 */
	@Test
	public void testMethod() {
		SearchResponse searchResponse = client.prepareSearch(index).setTypes(type).setQuery(QueryBuilders.matchAllQuery()).setSearchType(SearchType.QUERY_THEN_FETCH)
				.addAggregation(AggregationBuilders.terms("group_name").field("name").subAggregation(AggregationBuilders.sum("sum_age").field("age"))).get();

		Terms terms = searchResponse.getAggregations().get("group_name");
		List<Bucket> buckets = (List<Bucket>) terms.getBuckets();
		for (Bucket bt : buckets) {
			Sum sum = bt.getAggregations().get("sum_age");
			System.out.println(bt.getKey() + "  " + bt.getDocCount() + " " + sum.getValue());
		}
	}
}
