/**
 * 
 */
package za.co.sindi.wumdrop;

import za.co.sindi.wumdrop.exception.RequestException;
import za.co.sindi.wumdrop.exception.ResponseException;
import za.co.sindi.wumdrop.impl.WumDropAPIv1;

/**
 * @author Bienfait Sindi
 * @since 09 December 2014
 *
 */
public class WumDropAPITest {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		API api = new WumDropAPIv1("e881d08f89856ff96bee2e12d44567ac6d50b9e1ca891472d36dfd4c");
		try {
//			api.getDeliveries();
			System.out.println(api.test());
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResponseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
