import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.types.Page;
import com.restfb.types.Post;

import java.util.Arrays;
import java.util.List;

/**
 * Demo of using facebook api through restFB library
 */
public class Logic {

	public static String _LIMIT = "limit";

	/**
	 * Just want to provide a list of id for testing
	 * @return
	 */
	public List<String> getPageId(){
		return Arrays.asList(new String[]{
				"hk.nextmedia", //apple dialy
				"100most"}); //100 mo
	}

	FacebookClient facebookClient = new DefaultFacebookClient("683346095063887|hxZsJkAX-JLP2SGfQPjRGxAyXoU"); //My facebook application secret key

	/**
	 * Function to fetch a `Page` object with attributes
	 * @param id
	 * @return
   */
	public Page getPage(String id){
		return facebookClient.fetchObject(id, Page.class);
	}

	/**
	 * Function to get Post (i.e Feed) using id of User / Pages ....
	 * @param id
	 * @param limit
	 * @return
   */
	public List<Post> getFeeds(String id, int limit){
		Connection<Post> conn = facebookClient.fetchConnection(id+"/feed",Post.class, Parameter.with(_LIMIT, limit));
		return conn.getData();
	}

	/**
	 * Simple function to Print all the Post of object in `getPageId`
	 */
	public void test(){
		for(String id: getPageId())
			for(Post post : getFeeds(id ,20)){  //get first 20 object
				System.out.println(post);
			}
	}

	public static void main(String[] args){
		Logic logic = new Logic();
		logic.test();
	}


}
