//package com.beyond.eth.es;
//
//import java.net.InetAddress;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.Map;
//
//import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsRequest;
//import org.elasticsearch.action.admin.indices.mapping.get.GetFieldMappingsResponse;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.search.SearchRequestBuilder;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.cluster.node.DiscoveryNode;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.index.query.BoolQueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.search.SearchHits;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.junit.Test;
//
///**
// * 使用java API操作elasticSearch
// * 
// * @author yx
// *
// */
//public class elastaicTest {
//
//	private TransportClient client;
//	private IndexRequest source;
//
//	private String index = "my-application_ppp";
//	private String type = "bank";
//	/**
//	 * 获取连接, 第一种方式
//	 * 
//	 * @throws Exception
//	 */
//	// @Before
//	public void before() throws Exception {
//	// 客户端创建 方式1
//		Settings settings = Settings.builder().put("cluster.name", "my-application_ppp").put("client.transport.sniff", "true")// 客户端可以嗅到集群的其它部分
//				.put("client.transport.ping_timeout", 5) // 报错, ping等待时间,
//				.build();
//		TransportClient client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//
//	}
//
//	/**
//	 * 查看集群信息
//	 */
//	@Test
//	public void testInfo() {
//		List<DiscoveryNode> nodes = client.connectedNodes();
//		for (DiscoveryNode node : nodes) {
//			System.out.println(node.getHostAddress());
//		}
//	}
//   
//	public void ss(){
//		List<String> list = new ArrayList<String>();
//		String fieldName = "item_name";
//		GetFieldMappingsRequest fieldMappingsRequest = new GetFieldMappingsRequest().indices(index).types(type).fields(fieldName);
//		GetFieldMappingsResponse responseActionFuture = client.admin().indices().getFieldMappings(fieldMappingsRequest).actionGet();
//		GetFieldMappingsResponse.FieldMappingMetaData fieldMappingMetaData = responseActionFuture.fieldMappings(index,type,fieldName);
//		Object field = fieldMappingMetaData.sourceAsMap().get(fieldName);
//		if(field == null){
//		    //return list;
//		}
//		Map<String, Object> fieldsMap = (Map)((Map)field).get("fields");
//		if(fieldsMap == null){
//		    // return list;
//		}else{
//		    Iterator<Map.Entry<String, Object>> entries = fieldsMap.entrySet().iterator();
//		    while (entries.hasNext()) {
//		        Map.Entry<String, Object> entry = entries.next();
//		        System.out.println("Key = " + entry.getKey());
//		        list.add(entry.getKey());
//		    }
//		}
//		//构建查询条件
//		SearchRequestBuilder builder = client.prepareSearch(index).setTypes(type);
//		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
////		for(String field1 : list){
////		    boolQueryBuilder.should(QueryBuilders.fuzzyQuery(query.getKey() + "." +field1, query.getValue()));
////		}
//		builder.setQuery(boolQueryBuilder);
//		SearchResponse searchResponse = builder.execute().actionGet();
//		SearchHits hits = searchResponse.getHits();
//	}
//}