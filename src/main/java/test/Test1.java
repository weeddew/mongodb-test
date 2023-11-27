package test;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

public class Test1 {
	public static void main(String[] args) {
		String connectionString = "mongodb+srv://<id>:<pw>@cluster0.vprqb8v.mongodb.net/?retryWrites=true&w=majority";

		try (MongoClient mongoClient = MongoClients.create(connectionString)) {
			try {
				MongoDatabase database = mongoClient.getDatabase("test");
				MongoCollection<Document> collection = database.getCollection("users");

				Bson query = Filters.eq("name", "weeddew");

				DeleteResult delResult = collection.deleteMany(query);
				System.out.println(delResult);
			} catch (MongoException e) {
				e.printStackTrace();
			}
		}
	}
}
