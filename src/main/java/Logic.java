import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.Page;

import java.util.Arrays;
import java.util.List;

/**
 * Created by fafa on 9/5/2016.
 */
public class Logic {

	public List<String> getPageId(){
		return Arrays.asList(new String[]{
				"hk.nextmedia", //apple dialy
				"100most"}); //100 mo
	}

	FacebookClient facebookClient = new DefaultFacebookClient("3603f5ca77e2b22f6d1df14518aa8715");

	public Page getPage(String id){
		return facebookClient.fetchObject(id, Page.class);
	}

	public void test(){
		Page page = getPage(getPageId().get(0));
		System.out.println(page);
	}

	public static void main(String[] args){
		Logic logic = new Logic();
		logic.test();
	}


}
